
public class Rakuten {
	
	public Rakuten(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rakuten r = new Rakuten();
		int K = 0;
		int L = 0;
		int M = 5;
		int N = 4;    
				  int P = 0;
				  int Q = 0;
				  int R = 5;
				  int S = 4;
			   // System.out.println(l.equi_leader(A));
			    System.out.println(r.solution(K,L, M, N, P, Q,R,S));
	}
    public int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
        // write your code in Java SE 6
        long interX = 0;
        if(K<=P && P<M){
            if(R<M)
                interX = (long)(R-P);
            else
                interX = (long)(M-P);
        }else if(K<R){
            if(R<M)
                interX = (long)(R-K);
            else
                interX = (long)(K-M);
        }
        long interY = 0;
        if(L<=Q && Q<N){
            if(S<N)
                interY = (long)(S-Q);
            else
                interY = (long)(N-Q);
        }else if(L<S){
            if(S<N)
                interY = (long)(S-L);
            else
                interY = (long)(N-L);
        }
        long result = ((long)(M - K))*((long)(N - L)) + ((long)(R - P))*((long)(S - Q));
        if(interX != 0 && interY != 0)
            result -= interX * interY;
        if(result > 2147483647)
            return -1;
        return (int)(result);
    }
	
	
}
