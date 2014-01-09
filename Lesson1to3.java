//just a line of comment

public class Lesson1to3 {
	
	/*A non-empty zero-indexed string S is given. String S consists of N characters from the set of upper-case English letters A, C, G, T.
	This string actually represents a DNA sequence, and the upper-case letters represent single nucleotides.
	You are also given non-empty zero-indexed arrays P and Q consisting of M integers. These arrays represent queries about minimal nucleotides. We represent the letters of string S as integers 1, 2, 3, 4 in arrays P and Q, where A = 1, C = 2, G = 3, T = 4, and we assume that A < C < G < T.
	Query K requires you to find the minimal nucleotide from the range (P[K], Q[K]), 0 ≤ P[i] ≤ Q[i] < N.
	For example, consider string S = GACACCATA and arrays P, Q such that:
	    P[0] = 0    Q[0] = 8
	    P[1] = 0    Q[1] = 2
	    P[2] = 4    Q[2] = 5
	    P[3] = 7    Q[3] = 7
	The minimal nucleotides from these ranges are as follows:
	(0, 8) is A identified by 1,
	(0, 2) is A identified by 1,
	(4, 5) is C identified by 2,
	(7, 7) is T identified by 4.
	Write a function:
	class Solution { public int[] solution(String S, int[] P, int[] Q); }
	that, given a non-empty zero-indexed string S consisting of N characters and two non-empty zero-indexed arrays P and Q consisting of M integers, returns an array consisting of M characters specifying the consecutive answers to all queries.
	The sequence should be returned as:
	a Results structure (in C), or
	a vector of integers (in C++), or
	a Results record (in Pascal), or
	an array of integers (in any other programming language).
	For example, given the string S = GACACCATA and arrays P, Q such that:
	    P[0] = 0    Q[0] = 8
	    P[1] = 0    Q[1] = 2
	    P[2] = 4    Q[2] = 5
	    P[3] = 7    Q[3] = 7
	the function should return the values [1, 1, 2, 4], as explained above.
	Assume that:
	N is an integer within the range [1..100,000];
	M is an integer within the range [1..50,000];
	each element of array P, Q is an integer within the range [0..N − 1];
	P[i] ≤ Q[i];
	string S consists only of upper-case English letters A, C, G, T.
	Complexity:
	expected worst-case time complexity is O(N+M);
	expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
	Elements of input arrays can be modified.
	*/
	public int[] GenomicRangeQuery(String S, int[] P, int[] Q) {
		char[] ch = S.toCharArray();
		int[][] cumulativeCounter = new int[4][ch.length+1];
		for(int i = 0; i < ch.length; i++){
			for(int j = 0; j < 4; j++){
				cumulativeCounter[j][i+1] = cumulativeCounter[j][i];
			}
    		switch(ch[i]){
				case 'A':
					cumulativeCounter[0][i+1]++;
					break;
				case 'C':
					cumulativeCounter[1][i+1]++;
					break;
				case 'G':
					cumulativeCounter[2][i+1]++;
					break;
				case 'T':
					cumulativeCounter[3][i+1]++;
					break;
    		}
		}
		int[] min = new int[P.length];
		for(int i = 0; i < min.length; i++){
			for(int j = 0; j < 4; j++){
				if(cumulativeCounter[j][Q[i]+1] - cumulativeCounter[j][P[i]] > 0){
					min[i] = j + 1;
					break;
				}
			}
		}
		return min;
		
		/*here comes a failed solution. 
    	public int[] genomicRangequeryFailed(String S, int[] P, int[] Q) {
        // write your code in Java SE 6
    	int[] sum = new int[S.length()];
    	int[] min = new int[P.length];
    	for(int i = 0; i < sum.length; i++){
    		if(i-1 >= 0)
    			sum[i] = sum[i-1];
    		int charVal = 0;
    		switch(S.charAt(i)){
    			case 'A':
    				charVal = 1;
    				break;
    			case 'C':
    				charVal = 2;
    				break;
    			case 'G':
    				charVal = 3;
    				break;
    			case 'T':
    				charVal = 4;
    				break;
    		}
    		sum[i] += charVal; 
    	}
    	for(int i = 0; i< min.length; i++){
    		if(P[i] == Q[i]){
    			if(P[i] == 0)
    				min[i] = sum[P[i]];
    			else
    				min[i] = sum[P[i]] - sum[P[i]-1];
    		}else if(P[i] != 0)
    			min[i] = (Q[i] - P[i] + 1) - (sum[Q[i]] - sum[P[i]-1]) % (Q[i] - P[i] + 1);
    		else
    			min[i] = (Q[i] - P[i] + 1) - (sum[Q[i]]) % (Q[i] - P[i] + 1);
    	}
    	return min;  	
    }*/
	}
	
	/*A non-empty zero-indexed array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
	Array A contains only 0s and/or 1s:
	0 represents a car traveling east,
	1 represents a car traveling west.
	The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
	For example, consider array A such that:
	  A[0] = 0
	  A[1] = 1
	  A[2] = 0
	  A[3] = 1
	  A[4] = 1
	We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
	Write a function:
	class Solution { public int solution(int[] A); }
	that, given a non-empty zero-indexed array A of N integers, returns the number of passing cars.
	The function should return −1 if the number of passing cars exceeds 1,000,000,000.
	For example, given:
	  A[0] = 0
	  A[1] = 1
	  A[2] = 0
	  A[3] = 1
	  A[4] = 1
	the function should return 5, as explained above.
	Assume that:
	N is an integer within the range [1..100,000];
	each element of array A is an integer within the range [0..1].
	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
	Elements of input arrays can be modified.
	*/
	public int PassingCars(int[] A){
        int west = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == 1)
               west++;
        }
        long result = 0;
        for(int i = 0; i <A.length; i++){
            if(A[i] == 0){
                result += (long) west; 
            }else{
                west--;
            }
        }
        if(result > 1000000000)
            return -1;
        return (int) result;
	}
	
	/*You are given N counters, initially set to 0, and you have two possible operations on them:
	increase(X) − counter X is increased by 1,
	max_counter − all counters are set to the maximum value of any counter.
	A non-empty zero-indexed array A of M integers is given. This array represents consecutive operations:
	if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
	if A[K] = N + 1 then operation K is max_counter.
	For example, given integer N = 5 and array A such that:
	    A[0] = 3
	    A[1] = 4
	    A[2] = 4
	    A[3] = 6
	    A[4] = 1
	    A[5] = 4
	    A[6] = 4
	the values of the counters after each consecutive operation will be:
	    (0, 0, 1, 0, 0)
	    (0, 0, 1, 1, 0)
	    (0, 0, 1, 2, 0)
	    (2, 2, 2, 2, 2)
	    (3, 2, 2, 2, 2)
	    (3, 2, 2, 3, 2)
	    (3, 2, 2, 4, 2)
	The goal is to calculate the value of every counter after all operations.
	struct Results {
	  int * C;
	  int L;
	};
	Write a function:
	struct Results solution(int N, int A[], int M);
	that, given an integer N and a non-empty zero-indexed array A consisting of M integers, returns a sequence of integers representing the values of the counters.
	The sequence should be returned as:
	a structure Results (in C), or
	a vector of integers (in C++), or
	a record Results (in Pascal), or
	an array of integers (in any other programming language).
	For example, given:
	    A[0] = 3
	    A[1] = 4
	    A[2] = 4
	    A[3] = 6
	    A[4] = 1
	    A[5] = 4
	    A[6] = 4
	the function should return [3, 2, 2, 4, 2], as explained above.
	Assume that:
	N and M are integers within the range [1..100,000];
	each element of array A is an integer within the range [1..N + 1].
	Complexity:
	expected worst-case time complexity is O(N+M);
	expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
	Elements of input arrays can be modified.
	*/
    public int[] MaxCounters(int N, int[] A) {
        // write your code in Java SE 6
    	/* t.c = o(n+a.size), s.c = o(n)
    	 * */
        int[] ctn = new int[N];
        int maxCtn = 0;
        int lastUpdate = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] >= 1 && A[i] <= N){
            	if(ctn[A[i]-1] < lastUpdate)
            		ctn[A[i]-1] = lastUpdate;
                ctn[A[i]-1]++;
                if(ctn[A[i]-1] > maxCtn)
                    maxCtn = ctn[A[i]-1];
            }else if(A[i] == N+1){
            	lastUpdate = maxCtn;
            }
        }
        for(int i = 0; i < N; i++)
        	if(ctn[i] < lastUpdate)
        		ctn[i] = lastUpdate;
        return ctn;
    }
    
    /*A small frog wants to get to the other side of a river. The frog is currently located at position 0, and wants to get to position X. Leaves fall from a tree onto the surface of the river.
    You are given a non-empty zero-indexed array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in minutes.
    The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X.
    For example, you are given integer X = 5 and array A such that:
      A[0] = 1
      A[1] = 3
      A[2] = 1
      A[3] = 4
      A[4] = 2
      A[5] = 3
      A[6] = 5
      A[7] = 4
    In minute 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.
    Write a function:
    class Solution { public int solution(int X, int[] A); }
    that, given a non-empty zero-indexed array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.
    If the frog is never able to jump to the other side of the river, the function should return −1.
    For example, given X = 5 and array A such that:
      A[0] = 1
      A[1] = 3
      A[2] = 1
      A[3] = 4
      A[4] = 2
      A[5] = 3
      A[6] = 5
      A[7] = 4
    the function should return 6, as explained above. Assume that:
    N and X are integers within the range [1..100,000];
    each element of array A is an integer within the range [1..X].
    Complexity:
    expected worst-case time complexity is O(N);
    expected worst-case space complexity is O(X), beyond input storage (not counting the storage required for input arguments).
    Elements of input arrays can be modified.
    */
    public int ForgRiverOne(int X, int[] A) {
        // write your code in Java SE 6
    	/*
    	HashSet<Integer> hs = new HashSet<Integer>();
    	for(int i = 1; i <= X; i++)
    		hs.add(i);
    	for(int i = 0; i < A.length; i++)
    		if(hs.contains(A[i])){
    			hs.remove(A[i]);
    			if(hs.size() == 0)
    				return i;
    		}
        return -1;
        */
    	
    	/*	Here comes a simpler and quicker answer!!!
    	 * */
    	boolean[] bitMap = new boolean[X];
    	int steps = X;
    	for(int i = 0; i < A.length; i++){
    		if(!bitMap[A[i]-1]){
    			bitMap[A[i]-1] = true;
    			steps--;
    			if(steps == 0)
    				return i;
    		}
    	}
    	return -1;
    }
    
    /*A non-empty zero-indexed array A consisting of N integers is given.
    A permutation is a sequence containing each element from 1 to N once, and only once.
    For example, array A such that:
        A[0] = 4
        A[1] = 1
        A[2] = 3
        A[3] = 2
    is a permutation, but array A such that:
        A[0] = 4
        A[1] = 1
        A[2] = 3
    is not a permutation.
    The goal is to check whether array A is a permutation.
    Write a function:
    class Solution { public int solution(int[] A); }
    that, given a zero-indexed array A, returns 1 if array A is a permutation and 0 if it is not.
    For example, given array A such that:
        A[0] = 4
        A[1] = 1
        A[2] = 3
        A[3] = 2
    the function should return 1.
    Given array A such that:
        A[0] = 4
        A[1] = 1
        A[2] = 3
    the function should return 0.
    Assume that:
    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [1..1,000,000,000].
    Complexity:
    expected worst-case time complexity is O(N);
    expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
    Elements of input arrays can be modified.
    */
    public int PermCheck(int[] A) {
        // write your code in Java SE 6
        int[] tmp = new int[A.length+1];
        for(int i = 0; i < A.length; i++)
            if(A[i] < tmp.length /* this condition for avoiding array index exception*/ && tmp[A[i]] == 0)
                tmp[A[i]] = 1;
        for(int i = 1; i < tmp.length; i++)
            if(tmp[i] == 0)
                return 0;
            
        return 1;
    }
    
    /*A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.
    Any integer P, such that 0 < P < N, splits this tape into two non−empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
    The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
    In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
    For example, consider array A such that:
      A[0] = 3
      A[1] = 1
      A[2] = 2
      A[3] = 4
      A[4] = 3
    We can split this tape in four places:
    P = 1, difference = |3 − 10| = 7 
    P = 2, difference = |4 − 9| = 5 
    P = 3, difference = |6 − 7| = 1 
    P = 4, difference = |10 − 3| = 7 
    Write a function:
    class Solution { public int solution(int[] A); }
    that, given a non-empty zero-indexed array A of N integers, returns the minimal difference that can be achieved.
    For example, given:
      A[0] = 3
      A[1] = 1
      A[2] = 2
      A[3] = 4
      A[4] = 3
    the function should return 1, as explained above.
    Assume that:
    N is an integer within the range [2..100,000];
    each element of array A is an integer within the range [−1,000..1,000].
    Complexity:
    expected worst-case time complexity is O(N);
    expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
    Elements of input arrays can be modified.
    */
	public int TapeEquilibrium(int[] A){
		long left = 0;
		long right = 0;
		long min = 2001;	//each element of array A is an integer within the range [−1,000..1,000].
		for(int i = 0; i < A.length; i++)
			right += (long) A[i];
		for(int i = 0; i < A.length-1; i++){
			left += (long) A[i];
			right -= (long) A[i];
			if(Math.abs(left-right) < min)
				min = Math.abs(left-right);
		}
		return (int) min;
	}
	
	/*A zero-indexed array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
	Your goal is to find that missing element.
	Write a function:
	class Solution { public int solution(int[] A); }
	that, given a zero-indexed array A, returns the value of the missing element.
	For example, given array A such that:
	  A[0] = 2
	  A[1] = 3
	  A[2] = 1
	  A[3] = 5
	the function should return 4, as it is the missing element.
	Assume that:
	N is an integer within the range [0..100,000];
	the elements of A are all distinct;
	each element of array A is an integer within the range [1..(N + 1)].
	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
	Elements of input arrays can be modified.
	*/
    public int PermMissingElem(int[] A) {
        // write your code in Java SE 6
        long sum = 0;
        for(int i = 0; i < A.length; i++)
            sum += (long) A[i];
        return (int) (((long)(1 + A.length + 1)) * ((long)(A.length + 1)) / 2 - sum);
        
    }

    /*A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.
    Count the minimal number of jumps that the small frog must perform to reach its target.
    Write a function:
    class Solution { public int solution(int X, int Y, int D); }
    that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.
    For example, given:
      X = 10
      Y = 85
      D = 30
    the function should return 3, because the frog will be positioned as follows:
    after the first jump, at position 10 + 30 = 40
    after the second jump, at position 10 + 30 + 30 = 70
    after the third jump, at position 10 + 30 + 30 + 30 = 100
    Assume that:
    X, Y and D are integers within the range [1..1,000,000,000];
    X ≤ Y.
    Complexity:
    expected worst-case time complexity is O(1);
    expected worst-case space complexity is O(1).
    Copyright 2009–2013 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
    */
    public int FrogJump(int X, int Y, int D) {
        // write your code in Java SE 6
        return (Y - X) / D + ( (Y - X) % D == 0 ? 0 : 1);
    }

}
