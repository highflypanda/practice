
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
Copyright 2009–2013 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
*/
    public int PermMissingElem(int[] A) {
        // write your code in Java SE 6
        long sum = 0;
        for(int i = 0; i < A.length; i++)
            sum += (long) A[i];
        return (int) (((long)(1 + A.length + 1)) * ((long)(A.length + 1)) / 2 - sum);
        
    }
}
