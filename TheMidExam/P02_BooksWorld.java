package MidExamRetake;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_BooksWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> oldList = Arrays.stream(scanner.nextLine().split("\\s+\\|\\s+")).collect(Collectors.toList());

        String commands = scanner.nextLine();
        while (!commands.contains("Stop!")){
            String command = commands.split("\\s+")[0];
            String genre = "";
            switch (command){
                case "Join":
                genre = commands.split("\\s+")[1];
                if (!oldList.contains(genre)){
                    oldList.add(genre);
                } else {
                    break;
                }
                    break;
                case "Drop":
                    genre = commands.split("\\s+")[1];
                    if (oldList.contains(genre)){
                        oldList.remove(genre);
                    } else {
                        break;
                    }
                    break;
                case "Replace":
                    String oldGenre = commands.split("\\s+")[1];
                    String newGenre = commands.split("\\s+")[2];
                    int index = 0;
                    if (oldList.contains(oldGenre) && !oldList.contains(newGenre)){
                        for (int i = 0; i < oldList.size(); i++) {
                            String neededGenre = oldList.get(i);
                            if (neededGenre.equals(oldGenre)){
                                index = i;
                            }
                        }
                        oldList.remove(oldGenre);
                        oldList.add(index, newGenre);
                    }
                    break;
                case "Prefer":
                    int index1 = Integer.parseInt(commands.split("\\s+")[1]);
                    int index2 = Integer.parseInt(commands.split("\\s+")[2]);
                    if (oldList.size() - 1 >= index1 && oldList.size() - 1 >= index2) {
                        String genre1 = oldList.get(index1);
                        String genre2 = oldList.get(index2);
                        oldList.remove(index1);
                        oldList.add(index1, genre2);
                        oldList.remove(index2);
                        oldList.add(index2, genre1);

                    } else {
                        break;
                    }
                    break;
            }
            commands = scanner.nextLine();
        }
        System.out.println(String.join(" ", oldList));
    }
}
