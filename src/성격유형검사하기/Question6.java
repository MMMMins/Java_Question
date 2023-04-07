package 성격유형검사하기;

import java.util.HashMap;

public class Question6 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        char[][] type = {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
        HashMap<Character, Integer> map = new HashMap<>();
        for(char[] ch : type){
            map.put(ch[0],0);
            map.put(ch[1],0);
        }
        for(int i=0; i<survey.length; i++){
            if(choices[i] > 4){
                map.put(survey[i].charAt(1),map.get(survey[i].charAt(1))+choices[i]-4);
            }else{
                map.put(survey[i].charAt(0),map.get(survey[i].charAt(0))+4-choices[i]);
            }
        }
        for(char[] ch : type){
            answer += map.get(ch[0]) >= map.get(ch[1]) ? ch[0] : ch[1];
        }

        return answer;
    }
}
