package Disjoint_Sets;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {
    int count;
    int[] parent;
    int[] size;

    public WeightedQuickUnionUF(int n){
        count = n;
        parent =new int[n];
        size = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int count(){
        return count;
    }

    public int find(int p){
        validate(p);
        while(p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    public void validate(int p){
        int n = parent.length;
        if (p<0 || p>=n){
            throw new IllegalArgumentException("index" + p + "is not between 0 and " + n);
        }
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (size[rootP] > size[rootQ]){
            parent[rootQ] = rootP;
            size[rootP] +=size[rootQ];
        }
        else {
            parent[rootP] = rootQ;
            size[rootQ] +=size[rootP];
        }
        count --;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }


}
