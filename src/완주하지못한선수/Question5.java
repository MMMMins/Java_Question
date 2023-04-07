package 완주하지못한선수;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.Comparator;

public class Question5 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        LinkedList<String> retire = new LinkedList<>(Arrays.asList(participant));
        retire.sort(Comparator.naturalOrder());
        Arrays.sort(completion);

        for (String s : completion) {
            if (retire.get(0).equals(s)) {
                retire.remove(0);
            } else if (retire.get(1).equals(s)) {
                retire.remove(1);
            }
        }
        answer = retire.get(0);
        return answer;
    }
}
