package Graphs.sheet.part_1;

public class CycleBfs {
    /*
    If you visit an already visited neighbour that is NOT your parent, then you've found a cycle.
    Queue stores
        (node, parent)
    Rule
        for(neighbour) {
            if(!visited[neighbour]) {
                visited[neighbour] = true;
                q.offer(new Pair(neighbour, node));
            }

            else if(neighbour != parent) { // here vis[neighbour] = true && neighbour != parent
                return true;
        }
    */
}
