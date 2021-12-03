import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        List<List<Integer>> input = new ArrayList<>();

        while(sc.hasNext()){
            String command = sc.nextLine();

            String direction = command.substring(0, command.indexOf(" "));
            String value = command.substring(command.indexOf(" ") + 1);

            List<Integer> step = new ArrayList<>();
            if (direction.equals("forward")){
                step.add(0);
            } else if (direction.equals("up")){
                step.add(1);
            } else if (direction.equals("down")){
                step.add(2);
            }
            step.add(Integer.parseInt(value));

            input.add(step);
        }

        System.out.println(part1(input));
        System.out.println(part2(input));
    }

    public static int part1(List<List<Integer>> input){
        int hor = 0, depth = 0;

        for (List<Integer> commands : input) {
            int val = commands.get(1);

            if (commands.get(0) == 0) { //forward
                hor += val;
            } else if (commands.get(0) == 1) { //up
                depth -= val;
            } else if (commands.get(0) == 2) { //down
                depth += val;
            }
        }

        return hor * depth;
    }

    public static int part2(List<List<Integer>> input){
        int hor = 0, depth = 0, aim = 0;

        for (List<Integer> commands : input) {
            int val = commands.get(1);

            if (commands.get(0) == 0) { //forward
                hor += val;
                depth += aim * val;
            } else if (commands.get(0) == 1) { //up
                aim -= val;
            } else if (commands.get(0) == 2) { //down
                aim += val;
            }
        }

        return hor * depth;
    }
}
