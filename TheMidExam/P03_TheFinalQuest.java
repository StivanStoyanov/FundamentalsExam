package MidExamRetake;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_TheFinalQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String commands = scanner.nextLine();

        while (!commands.contains("Stop")){

            String command = commands.split("\\s+")[0];
            String word1 = "";
            String word2 = "";
            int index = 0;
            switch (command){
                case "Delete":
                    index = Integer.parseInt(commands.split("\\s+")[1]);
                    if (input.size() - 1 > index){
                        input.remove(index + 1);
                    } else if (input.size() - 1 <= index) {
                    break;
                }
                    break;
                case "Swap":
                    word1 = commands.split("\\s+")[1];
                    word2 = commands.split("\\s+")[2];
                    if (input.contains(word1) && input.contains(word2)){
                        int index1 = input.indexOf(word1);
                        int index2 = input.indexOf(word2);
                        input.remove(index1);
                        input.add(index1, word2);
                        input.remove(index2);
                        input.add(index2, word1);
                    } else {
                        break;
                    }
                    break;
                case "Put":
                    word1 = commands.split("\\s+")[1];
                    index = Integer.parseInt(commands.split("\\s+")[2]);

                    if (input.size() - 1 > index && index != 0){
                        input.add(index - 1, word1);
                    } else if (input.size() - 1 == index){
                        input.add(word1);
                    } else {
                        break;
                    }
                    break;
                case "Sort":
                    Collections.sort(input, Collections.reverseOrder());
                    break;
                case "Replace":
                    String replacement = commands.split("\\s+")[1];
                    String toReplace = commands.split("\\s+")[2];
                    if (input.contains(toReplace)){
                        index = input.indexOf(toReplace);
                        input.remove(toReplace);
                        input.add(index, replacement);
                    } else {
                        break;
                    }
                    break;
            }

            commands = scanner.nextLine();
        }
        System.out.println(String.join(" ", input));
    }
}
