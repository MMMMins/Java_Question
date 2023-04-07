package 같은숫자는싫어;

import java.util.Stack;

public class Question4 {
    public static void main(String[] args) {
        int[] ans = solution(new int[]{1,1,3,3,0,1,1});

        for(int x : ans){
            System.out.println(x);
        }
    }
    public static int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        for(int num : arr){
            int temp;
            if(stack.isEmpty()){
                stack.push(num);
                continue;
            }
            temp = stack.pop();
            if(temp != num) stack.push(temp);
            stack.push(num);
        }
        answer = new int[stack.size()];
        for(int i=answer.length-1; i>=0; i--){
            answer[i] = stack.pop();
        }


        return answer;
    }
}
