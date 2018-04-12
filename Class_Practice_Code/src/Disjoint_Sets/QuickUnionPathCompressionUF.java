package Disjoint_Sets;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionPathCompressionUF {
    int[] id;
    int count;

    public QuickUnionPathCompressionUF(int n){
        count = n;
        id = new int[n];
        for (int i=0; i<n;i++){
            id[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public int find(int p){
        int root = p;
        while (root != id[root]){
            root = id[root];
        }
        while (p != root){
            int newP = id[p];
            id[p] = root;
            p = newP;
        }
        return root;
    }

    private void validate(int p){
        if (p<0 || p >= id.length){
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (id.length-1));
        }
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        id[rootP] = rootQ;
        count--;
    }


    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickUnionPathCompressionUF uf = new QuickUnionPathCompressionUF(n);
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
