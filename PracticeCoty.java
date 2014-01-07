
public class PracticeCoty {
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
}
