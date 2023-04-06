package K번째수;

public class Question {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = solution(array,commands);
        for(int x : answer){
            System.out.println(x);
        }

    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int n = 0;
        int[] nums;

        while(n < commands.length){
            int diff = commands[n][1] - commands[n][0] + 1;

            nums = new int[diff];
            int numsIdx = 0;
            for(int i=commands[n][0]-1; i<commands[n][1]; i++){
                nums[numsIdx++] = array[i];
            }

            merge(nums, 0, nums.length-1);
            answer[n] = nums[commands[n][2]-1];
            n++;
        }

        return answer;
    }

    public static void merge(int[] nums, int left, int right){
        if(left < right){
            int mid = (left + right)/2;

            merge(nums, left, mid);
            merge(nums, mid+1, right);
            sort(nums, left, mid, right);
        }
    }

    public static void sort(int[] nums, int left, int mid, int right){
        int[] leftNumber = slice(nums, left, mid+1);
        int[] rightNumber = slice(nums, mid+1, right+1);

        int i=0, j=0, k=left;
        int leftSize = leftNumber.length;
        int rightSize = rightNumber.length;

        while(i<leftSize && j<rightSize){
            if(leftNumber[i] <= rightNumber[j]){
                nums[k] = leftNumber[i++];
            }else{
                nums[k] = rightNumber[j++];
            }
            k++;
        }

        while(i<leftSize){
            nums[k++] = leftNumber[i++];
        }
        while(j<rightSize){
            nums[k++] = rightNumber[j++];
        }

    }

    public static int[] slice(int[] nums, int start, int end){
        int[] numbers = new int[end - start];
        int s = start;
        for(int i=0; i<numbers.length; i++){
            numbers[i] = nums[s++];
        }

        return numbers;
    }
}
