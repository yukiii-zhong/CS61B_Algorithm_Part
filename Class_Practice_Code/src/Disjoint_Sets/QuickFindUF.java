package Disjoint_Sets;

public class QuickFindUF {
    private int[] id;
    private int count;

    public QuickFindUF(int N){
        id = new int[N];
        count = N;

        for (int i=0; i<N; i++){
            id[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public int find(int p){
        validate(p);
        return id[p];
    }

    private void validate(int p){
        int n = id.length;
        if (p<0 || p>=n){
            throw new IllegalArgumentException("index" + p + "is not between 0 and " + (n-1));
        }
    }

    public boolean isConnected(int p, int q){
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

    public void union(int p, int q){
        validate(p);
        validate(q);
        int idq = id[q];
        int idp = id[p];
        for (int i=0; i< id.length;i++){
            if (id[i] == idp) id[i] = idq;
        }
        count --;
    }

    public static void main(String[] args){
        int n = StdIn.readInt();

    }

}
