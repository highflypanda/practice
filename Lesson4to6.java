import java.util.Arrays;
import java.util.Stack;


public class Lesson4to6 {
	
	/*A non-empty zero-indexed array A consisting of N integers is given.
	The leader of this array is the value that occurs in more than half of the elements of A.
	An equi_leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
	For example, given array A such that:
	    A[0] = 4
	    A[1] = 3
	    A[2] = 4
	    A[3] = 4
	    A[4] = 4
	    A[5] = 2
	we can find two equi_leaders:
	0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
	2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
	The goal is to count the number of equi_leaders. Write a function:
	class Solution { public int solution(int[] A); }
	that, given a non-empty zero-indexed array A consisting of N integers, returns the number of equi_leaders.
	For example, given:
	    A[0] = 4
	    A[1] = 3
	    A[2] = 4
	    A[3] = 4
	    A[4] = 4
	    A[5] = 2
	the function should return 2, as explained above.
	Assume that:
	N is an integer within the range [1..100,000];
	each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
	Elements of input arrays can be modified.
	*/
	public int EquiLeader(int[] A){		
		if(A.length == 0)
			return 0;
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0; i < A.length; i++){
			if(s.isEmpty()){
				s.push(A[i]);
			}else if(s.peek().intValue() == A[i]){
				s.push(A[i]);
			}else{
				s.pop();
			}
		}
		if(s.isEmpty())
			return 0;
		int candidate = s.peek().intValue();
		int count = 0;
		for(int i = 0; i < A.length; i++){
			if(A[i] == candidate)
				count++;
		}
		if(count <= A.length/2)
			return 0;
		
		int equiLeaderNum = 0;
		int leftCount = 0;
		int rightCount = count;
		
		for(int i = 0; i < A.length-1; i++){
			if(A[i] == candidate){
				leftCount++;
				rightCount--;
			}
			if(leftCount > (i+1)/2 && rightCount > (A.length-1-i)/2)	//should pay attention to this "if" flow
				equiLeaderNum++;
		}
		return equiLeaderNum; 
	}
	
	/*A zero-indexed array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
	For example, consider array A such that
	A[0] = 3    A[1] = 4    A[2] =  3
	A[3] = 2    A[4] = 3    A[5] = -1
	A[6] = 3    A[7] = 3
	The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
	Write a function
	class Solution { public int solution(int[] A); }
	that, given a zero-indexed array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.
	Assume that:
	N is an integer within the range [0..100,000];
	each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
	For example, given array A such that
	A[0] = 3    A[1] = 4    A[2] =  3
	A[3] = 2    A[4] = 3    A[5] = -1
	A[6] = 3    A[7] = 3
	the function may return 0, 2, 4, 6 or 7, as explained above.
	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
	Elements of input arrays can be modified.
	*/
    public int Dominator(int[] A) {
        // write your code in Java SE 6
		if(A.length == 0)
			return -1;
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0; i < A.length; i++){
			if(s.isEmpty()){
				s.push(A[i]);
			}else if(s.peek().intValue() == A[i]){
				s.push(A[i]);
			}else{
				s.pop();
			}
		}
		if(s.isEmpty())
			return -1;
		int candidate = s.peek().intValue();
		int index = -1;
		int count = 0;
		for(int i = 0; i < A.length; i++){
			if(A[i] == candidate){
				count++;
				index = i;
			}
		}
		if(count > A.length/2)
			return index;
		return -1;
		
    }
	
	/*You are given two non-empty zero-indexed arrays A and B consisting of N integers. Arrays A and B represent N voracious fish in a river, ordered downstream along the flow of the river. The fish are numbered from 0 to N − 1, fish number P is represented by A[P] and B[P], and if P < Q then fish P is initially upstream of fish Q. Initially, each fish has a unique position.
	Array A contains the sizes of the fish. All its elements are unique. Array B contains the directions of the fish. It contains only 0s and/or 1s, where:
	0 represents a fish flowing upstream,
	1 represents a fish flowing downstream.
	If two fish move in opposite directions and there are no other (living) fish between them, they will eventually meet each other. Then only one fish can stay alive − the larger fish eats the smaller one. More precisely, we say that two fish P and Q meet each other when P < Q, B[P] = 1 and B[Q] = 0, and there are no living fish between them. After they meet:
	If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,
	If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.
	We assume that all the fish are flowing at the same speed. That is, fish moving in the same direction never meet. The goal is to calculate the number of fish that will stay alive.
	For example, consider arrays A and B such that:
	  A[0] = 4    B[0] = 0
	  A[1] = 3    B[1] = 1
	  A[2] = 2    B[2] = 0
	  A[3] = 1    B[3] = 0
	  A[4] = 5    B[4] = 0
	Initially all the fish are alive and all except fish number 1 are moving upstream. Fish number 1 meets fish number 2 and eats it, then it meets fish number 3 and eats it too. Finally, it meets fish number 4 and is eaten by it. The remaining two fish, numbers 0 and 4, never meet and therefore stay alive.
	Write a function:
	class Solution { public int solution(int[] A, int[] B); }
	that, given two non-empty zero-indexed arrays A and B consisting of N integers, returns the number of fish that will stay alive.
	For example, given the arrays shown above, the function should return 2, as explained above.
	Assume that:
	N is an integer within the range [1..100,000];
	each element of array A is an integer within the range [0..1,000,000,000];
	each element of array B is an integer that can have one of the following values: 0, 1;
	the elements of A are all distinct.
	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
	Elements of input arrays can be modified.
	*/
	public int Fish(int[] A, int[] B) {
		int survivors = 0;
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0; i < A.length; i++){
			if(B[i] == 0){
				if(s.isEmpty()){
					survivors++;
				}else{
					while(!s.isEmpty()){
						if(s.peek() > A[i]){
							break;
						}else{
							s.pop();
						}
					}
					if(s.isEmpty())
						survivors++;
				}
			}else{
				s.push(A[i]);
			}
		}
		return survivors + s.size();
		/*	bugs on this solution, but I do not know what exactly it is @_@ 
		Stack<int[]> s = new Stack<int[]>();
		for(int i = 0; i < B.length; i++){
			if(s.isEmpty() || B[i] == 1){
				s.push(new int[]{A[i], B[i]});
			}else if(s.peek()[1] == 1){
				if(s.peek()[0] < A[i]){
					s.pop();
					s.push(new int[]{A[i], B[i]});
				}
			}else{
				s.push(new int[]{A[i], B[i]});
			}
		}
		return s.size();*/	
    }
	
	/*A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
	S is empty;
	S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
	S has the form "VW" where V and W are properly nested strings.
	For example, the string "{[()()]}" is properly nested but "([)()]" is not.
	Write a function:
	class Solution { public int solution(String S); }
	that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
	For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
	Assume that:
	N is an integer within the range [0..200,000];
	string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
	*/
	public int Brackets(String S){
		//handle '[ ] ( ) { }'
		Stack<Character> s = new Stack<Character>();
		for(int i = 0; i < S.length(); i++){
			switch(S.charAt(i)){
			case '}':
				if(!s.isEmpty() && s.peek() == '{')
					s.pop();
				else
					s.push(S.charAt(i));
				break;
			case ']':
				if(!s.isEmpty() && s.peek() == '[')
					s.pop();
				else
					s.push(S.charAt(i));
				break;
			case ')':
				if(!s.isEmpty() && s.peek() == '(')
					s.pop();
				else
					s.push(S.charAt(i));
				break;
			default:
				s.push(S.charAt(i));
				break;
			}
		}

		if(s.size() == 0)
			return 1;
		return 0;
	}
	
	/*A non-empty zero-indexed array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
	For example, array A such that:
	  A[0] = -3
	  A[1] = 1
	  A[2] = 2
	  A[3] = -2
	  A[4] = 5
	  A[5] = 6
	contains the following example triplets:
	(0, 1, 2), product is −3 * 1 * 2 = −6
	(1, 2, 4), product is 1 * 2 * 5 = 10
	(2, 4, 5), product is 2 * 5 * 6 = 60
	Your goal is to find the maximal product of any triplet.
	Write a function:
	class Solution { public int solution(int[] A); }
	that, given a non-empty zero-indexed array A, returns the value of the maximal product of any triplet.
	For example, given array A such that:
	  A[0] = -3
	  A[1] = 1
	  A[2] = 2
	  A[3] = -2
	  A[4] = 5
	  A[5] = 6
	the function should return 60, as the product of triplet (2, 4, 5) is maximal.
	Assume that:
	N is an integer within the range [3..100,000];
	each element of array A is an integer within the range [−1,000..1,000].
	Complexity:
	expected worst-case time complexity is O(N*log(N));
	expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
	Elements of input arrays can be modified.
	*/
	public int MaxProductOfThree(int[] A) {
		Arrays.sort(A);
		//assume element within -1000 to 1000
		//no overflow problem occurs
		int max = -1000000001;
	    for(int i = 2; i < A.length; i++){
	    	if(A[i-2] + A[i-1] > - A[i] && A[i-1] + A[i] > A[i-2] && A[i-2] + A[i] > A[i-1])
	    		if(A[i-2]*A[i-1]*A[i] > max)
	    			max = A[i-2]*A[i-1]*A[i];
	    }
		return max;
	}
	
	/*A zero-indexed array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
	A[P] + A[Q] > A[R],
	A[Q] + A[R] > A[P],
	A[R] + A[P] > A[Q].
	For example, consider array A such that:
	  A[0] = 10    A[1] = 2    A[2] = 5
	  A[3] = 1     A[4] = 8    A[5] = 20
	Triplet (0, 2, 4) is triangular.
	Write a function:
	class Solution { public int solution(int[] A); }
	that, given a zero-indexed array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise. For example, given array A such that:
	  A[0] = 10    A[1] = 2    A[2] = 5
	  A[3] = 1     A[4] = 8    A[5] = 20
	the function should return 1, as explained above. Given array A such that:
	  A[0] = 10    A[1] = 50    A[2] = 5
	  A[3] = 1
	the function should return 0.
	Assume that:
	N is an integer within the range [0..1,000,000];
	each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
	Complexity:
	expected worst-case time complexity is O(N*log(N));
	expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
	Elements of input arrays can be modified.
	*/
	public int Triangle(int[] A) {
        // write your code in Java SE 6
		Arrays.sort(A);
		long tmp0 = 0;	//using long to avoid overflow problem
		long tmp1 = 0;
		long tmp2 = 0;
	    for(int i = 2; i < A.length; i++){
	    	//but only 3-contig elements checking is enough?
	    	//should be as the elements are sorted!!!
	    	tmp0 = A[i-2] + A[i-1] - A[i];
	    	tmp1 = - A[i-2] + A[i-1] + A[i];
	    	tmp2 = A[i-2] + A[i] - A[i-1];
	    	if(tmp0 > 0 && tmp1 > 0 && tmp2 > 0)
	    		return 1;
	    }
		return 0;
    }
}
