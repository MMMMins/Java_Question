package 모의고사;

public class Question7 {
    public static void main(String[] args) {
        int[] answer = solution(new int[]{1,2,3,4,5});
        for(int x : answer){
            System.out.println(x);
        }
    }

    public static int[] solution(int[] answers) {
        int temp=0;
        int max=0;

        int[] score = new int[3];
        int[] count = {0,0,0};

        int[] peo1 = {1,2,3,4,5};
        int[] peo2 = {2,1,2,3,2,4,2,5};
        int[] peo3 = {3,3,1,1,2,2,4,4,5,5};

        for(int i=0; i<answers.length; i++){
            if(peo1[count[0]++] == answers[i]){
                score[0]++;
            }
            if(peo2[count[1]++] == answers[i]){
                score[1]++;
            }
            if(peo3[count[2]++] == answers[i]){
                score[2]++;
            }

            if(count[0] >= peo1.length){
                count[0] = 0;
            }
            if(count[1] >= peo2.length){
                count[1] = 0;
            }
            if(count[2] >= peo3.length){
                count[2] = 0;
            }
        }

        for(int i=0; i<3; i++){
            if(score[i] >= max){
                max = score[i];
            }
        }

        for(int i=0; i<3; i++){
            if(score[i] == max){
                temp++;
            }
        }

        int[] answer = new int[temp];
        int j=0;
        for(int i=0; i<3; i++){
            if(score[i] == max){
                answer[j++] = i+1;
            }
        }


        return answer;
    }
}
