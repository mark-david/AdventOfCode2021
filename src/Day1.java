import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        List<Integer> input = new ArrayList<>();

        while (sc.hasNext()){
            int num = sc.nextInt();
            if (num == -1) {
                break;
            } else {
                input.add(num);
            }
        }

        System.out.println(part1(input));
        System.out.println(part2(input));
    }

    public static int part1(List<Integer> input){
        int oldValue, newValue;
        int result = 0;

        oldValue = input.get(0);

        for (int i = 1; i < input.size(); i++){
            newValue = input.get(i);

            if (newValue > oldValue){
                result++;
            }

            oldValue = newValue;
        }

        return result;
    }

    public static int part2(List<Integer> input){
        int sum1 = 0;
        int sum2 = 0;

        int result = 0;

        for (int i = 0; i < input.size() - 3; i++){
            sum1 = input.get(i) + input.get(i + 1) + input.get(i + 2);
            sum2 = input.get(i + 1) + input.get(i + 2) + input.get(i + 3);
            System.out.println(sum2 + " > " + sum1);
            if (sum2 > sum1){
                result++;
            }
        }

        return result;
    }
}
