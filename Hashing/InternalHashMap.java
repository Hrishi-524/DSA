package Hashing;
import java.util.*;

public class InternalHashMap {
    public static class HashMap<K,V> {
        private class Node {
            K key;
            V value;
            private Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
        
        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.n = 0;
            this.N = 4;
            this.buckets = new LinkedList[N];
            for(int i=0; i<N; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for(int i=0; i<ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key) {
                    return di;
                }
                di++;
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void reshash() {
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[2*N];
            N = 2*N;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
            for (int i = 0; i < oldBuck.length; i++) {
                LinkedList<Node> ll = oldBuck[i];
                for(int j=0; j<ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }  

        public void put(K key, V value) { // O(lambda) ~ O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {    
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double)n/N;
            double threshold = 2.0;
            if(lambda > threshold) {
                reshash();
            }
        }

        public boolean containsKey(K key) { // O(lambda) ~ O(1)
            int bi = hashFunction(key);
            LinkedList<Node> ll = buckets[bi];

            for(int i=0; i<ll.size(); i++) {
                Node node = ll.get(i);
                if(key == node.key) {
                    return true;
                }
            }

            return false;
        }

        public V get(K key) { // O(lambda) ~ O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> ks = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(i);
                    ks.add(node.key);
                }
            }
            return ks;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("Dubai", 40);
        hm.put("USA", 60);
        hm.put("UK", 10);
        hm.put("China", 30);
    }
}