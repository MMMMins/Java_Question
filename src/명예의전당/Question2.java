package 명예의전당;
import java.util.ArrayList;
import java.util.Collections;

public class Question2 {
    public static void main(String[] args) {
        for(int x: solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})){
            System.out.println(x);
        }
    }

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<score.length; i++){
            list.add(score[i]);
            Collections.sort(list, Collections.reverseOrder());
            if(list.size() > k){
                answer[i] = list.get(k-1);
            }else{
                answer[i] = list.get(list.size()-1);
            }
        }

        return answer;
    }

}
