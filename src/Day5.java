import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        List<List<Integer>> input = new ArrayList<>();

//        max x: 986
//        min x: 10
//        max y: 958
//        min y: 10

        while(sc.hasNext()){
            String command = sc.nextLine();
            String[] vectors = command.split(" -> ");
            String[] c1 = vectors[0].split(",");
            String[] c2 = vectors[1].split(",");

            int x1 = Integer.parseInt(c1[0]);
            int y1 = Integer.parseInt(c1[1]);
            int x2 = Integer.parseInt(c2[0]);
            int y2 = Integer.parseInt(c2[1]);

            List<Integer> coords = new ArrayList<>();
            coords.add(x1);
            coords.add(y1);
            coords.add(x2);
            coords.add(y2);
            input.add(coords);
        }

        System.out.println(part1(input));
        System.out.println(part2(input));
    }

    public static int part1(List<List<Integer>> input){
        int[][] grid = new int[1000][1000];

        int cross = 0;

        for (List<Integer> coords: input){
            int x1 = coords.get(0);
            int y1 = coords.get(1);
            int x2 = coords.get(2);
            int y2 = coords.get(3);

            if (x1 == x2){ //horizontal line
                for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++){
//                    System.out.println("Updating " + x1 + "," + i);
                    grid[x1][i] = grid[x1][i] + 1;
                    if (grid[x1][i] == 2){
                        cross++;
                    }
                }
            } else if (y1 == y2){ //vertical line
                for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++){
//                    System.out.println("Updating " + i + "," + y1);
                    grid[i][y1] = grid[i][y1] + 1;
                    if (grid[i][y1] == 2){
                        cross++;
                    }
                }
            }
        }

        return cross;
    }

    public static int part2(List<List<Integer>> input){
        int[][] grid = new int[1000][1000];

        int cross = 0;

        for (List<Integer> coords: input){
            int x1 = coords.get(0);
            int y1 = coords.get(1);
            int x2 = coords.get(2);
            int y2 = coords.get(3);

            if (x1 == x2){ //horizontal line
                for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++){
//                    System.out.println("Updating " + x1 + "," + i);
                    grid[x1][i] = grid[x1][i] + 1;
                    if (grid[x1][i] == 2){
                        cross++;
                    }
                }
            } else if (y1 == y2){ //vertical line
                for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++){
//                    System.out.println("Updating " + i + "," + y1);
                    grid[i][y1] = grid[i][y1] + 1;
                    if (grid[i][y1] == 2){
                        cross++;
                    }
                }
            } else if (Math.abs((y2 - y1) / (x2 - x1)) == 1){ //diagonal line
                int i = x1, j = y1;
                System.out.println("diagonal: " + x1 + "," + y1 + " -> " + x2 + "," + y2);
                do {
                    grid[i][j] = grid[i][j] + 1;
                    if (grid[i][j] == 2){
                        cross++;
                    }

                    if (i < x2){
                        i++;
                    } else {
                        i--;
                    }
                    if (j < y2){
                        j++;
                    } else {
                        j--;
                    }
                } while (i != x2 && j != y2);
            }
        }

        return cross;
    }
}

