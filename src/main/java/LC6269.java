import java.util.Stack;

public class LC6269 {

    public static void main(String[] args) {
        System.out.println(closetTarget(new String[] {"hello","i","am","leetcode","hello"},"hello", 1));
        System.out.println(closetTarget(new String[] {"a","b","leetcode"}, "leetcode", 0));
        System.out.println(closetTarget(new String[] {"i","eat","leetcode"}, "ate", 0));


    }

    //6269. Shortest Distance to Target String in a Circular Array
    ////You are given a 0-indexed circular string array words and a string target. A circular array means that the array's end connects to the array's beginning.
    //
    //Formally, the next element of words[i] is words[(i + 1) % n] and the previous element of words[i] is words[(i - 1 + n) % n], where n is the length of words.
    //Starting from startIndex, you can move to either the next word or the previous word with 1 step at a time.
    //
    //Return the shortest distance needed to reach the string target. If the string target does not exist in words, return -1.
    //
    //
    //
    //Example 1:
    //
    //Input: words = ["hello","i","am","leetcode","hello"], target = "hello", startIndex = 1
    //Output: 1
    //Explanation: We start from index 1 and can reach "hello" by
    //- moving 3 units to the right to reach index 4.
    //- moving 2 units to the left to reach index 4.
    //- moving 4 units to the right to reach index 0.
    //- moving 1 unit to the left to reach index 0.
    //The shortest distance to reach "hello" is 1.
    //Example 2:
    //
    //Input: words = ["a","b","leetcode"], target = "leetcode", startIndex = 0
    //Output: 1
    //Explanation: We start from index 0 and can reach "leetcode" by
    //- moving 2 units to the right to reach index 3.
    //- moving 1 unit to the left to reach index 3.
    //The shortest distance to reach "leetcode" is 1.
    //Example 3:
    //
    //Input: words = ["i","eat","leetcode"], target = "ate", startIndex = 0
    //Output: -1
    //Explanation: Since "ate" does not exist in words, we return -1.
    //
    //
    //Constraints:
    //
    //1 <= words.length <= 100
    //1 <= words[i].length <= 100
    //words[i] and target consist of only lowercase English letters.
    //0 <= startIndex < words.length

    public static int closetTarget(String[] words, String target, int startIndex){
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        stack1.push(words[startIndex]);
        stack2.push(words[startIndex]);

        int count1 = startIndex + 1;
        int count2 = startIndex - 1;

        while(!stack1.peek().equals(target)){
            if(count1 > words.length-1){
                count1 = 0;
            }
            stack1.push(words[count1]);
            if(stack1.size()> words.length) return -1;
            count1++;
        }

        while(!stack2.peek().equals(target)){
            if(count2 < 0){
                count2 = words.length-1;
            }

            stack2.push(words[count2]);
            if(stack2.size() > words.length) return -1;
            count2--;
        }

        return Math.min(stack1.size() - 1, stack2.size() -1);
    }
}
