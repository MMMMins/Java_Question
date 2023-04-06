package 체육복;

import java.util.Arrays;
import java.util.HashMap;

public class Question3 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // 1. 1차 에러 문제점 해결
        Arrays.sort(lost);
        Arrays.sort(reserve);

        //초기화
        HashMap<Integer, Integer> stu = new HashMap<>();
        for(int i=1; i<=n; i++){
            stu.put(i,1);
        }

        //도난당한 학생
        for (int key : lost) {
            stu.put(key, stu.get(key) - 1);
        }

        //여분있는 학생
        for (int key : reserve) {
            stu.put(key, stu.get(key) + 1);
        }

        // 2. 1차 에러 문제점 해결
        for(int k : stu.keySet()){
            if(stu.get(k) == 0){
                if(k > 1 && stu.getOrDefault(k-1,0) == 2){
                    stu.put(k-1, stu.get(k-1)-1);
                    stu.put(k, stu.get(k)+1);
                }else if(k != n+1 && stu.getOrDefault(k+1, 0) == 2){
                    stu.put(k+1, stu.get(k+1)-1);
                    stu.put(k, stu.get(k)+1);
                }
            }
        }

        for(int k : stu.keySet()){
            if(stu.get(k) >= 1){
                answer++;
            }
        }

        return answer;
    }
}
