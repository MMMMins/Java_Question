package 이중우선순위큐;

import java.util.Deque;
import java.util.LinkedList;

public class Question8 {

    public static void main(String[] args) {
        // 테스트케이스 6번
        int[] b = solution(new String[]{"I 1", "I 2", "I 3", "I 4", "I 5", "I 6", "I 7", "I 8", "I 9", "I 10", "D 1", "D -1", "D 1", "D -1", "I 1", "I 2", "I 3", "I 4", "I 5", "I 6", "I 7", "I 8", "I 9", "I 10", "D 1", "D -1", "D 1", "D -1"});
        for(int a : b){
            System.out.println(a);
        }
    }
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        Deque<Integer> deque = new LinkedList<>();

        for(String strOper : operations){
            // 문자열 분리 "I 443" -> ["I", "443"]
            String[] strList = strOper.split(" ");

            if(strList[0].equals("I")){

                // Deque가 비어있으면 삽입하고 반복문 시작으로
                if(deque.isEmpty()) {
                    deque.add(Integer.parseInt(strList[1]));
                    continue;
                }

                // 변수 초기회
                /*
                status -> 정렬할때 사용
                 */
                boolean status = true;
                int num = Integer.parseInt(strList[1]);
                int max=deque.getLast();
                int min=deque.getFirst();


                while(true){
                    // status가 False라면 Deque에 맨 앞에 있는 값들을 맨뒤로 보내는 과정
                    if(!status){
                        deque.addFirst(deque.removeLast());
                        if(max == deque.getLast()){
                            break;
                        }
                        continue;
                    }

                    // max값보다 크거나 같으면 바로 삽입하고 반복종료
                    if(max <= num){
                        deque.addLast(num);
                        break;
                    }

                    //min값보다 작거나 같으면 바로 삽입하고 반복종료
                    if(min >= num){
                        deque.addFirst(num);
                        break;
                    }

                    //max min사이의 있는 값이라면 맨뒤에 있는 값을 맨앞으로 보내고 비교
                    deque.addLast(deque.removeFirst());
                    if(deque.getFirst() >= num){
                        //num이 알맞는 자리에 들어가면 맨앞으로 보낸 값들을 맨뒤로 보내기위해 status를 false로 변경
                        deque.addFirst(num);
                        status = false;
                    }
                }

            }
            else if(!deque.isEmpty() && strList[1].equals("1")){
                deque.pollLast();
            }else if(!deque.isEmpty() && strList[1].equals("-1")){
                deque.pollFirst();
            }

        }

        if(deque.isEmpty()){
            answer = new int[]{0, 0};
        }else if(deque.size() == 1){
            answer = new int[]{deque.peekFirst(), 0};
        }else{
            answer = new int[]{deque.getLast(),deque.getFirst()};
        }
        return answer;
    }
}
