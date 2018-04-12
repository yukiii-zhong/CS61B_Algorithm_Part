package Disjoint_Sets;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionUF {
    int[] parent;
    int count;

    public QuickUnionUF(int n){
        count = n;
        parent = new int[n];
        for (int i=0; i<n;i++){
            parent[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public int find(int p){
        validate(p);
        while (p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    private void validate(int p){
        if (p<0 || p >= parent.length){
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (parent.length-1));
        }
    }

    public boolean isConnect(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }


    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.isConnect(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }

}
