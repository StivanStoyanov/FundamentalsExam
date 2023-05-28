package TheFinalExam;

import java.util.Scanner;

public class P01_StringGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String text = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.contains("Done")) {
            String command = input.split("\\s+")[0];
            StringBuilder sb = new StringBuilder(input);
            switch (command) {
                case "Change":
                    char toReplace = input.split("\\s+")[1].charAt(0);
                    char replacement = input.split("\\s+")[2].charAt(0);

                    text = text.replace(toReplace, replacement);
                    System.out.println(text);
                    break;
                case "Includes":
                    String includes = input.split("\\s+")[1];
                    if (text.contains(includes)){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String endWith = input.split("\\s+")[1];
                    String [] textArr = text.split("\\s+");
                    String lastWord = textArr[textArr.length - 1];
                    if (lastWord.equals(endWith)){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    text = text.toUpperCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    char indexOf = input.split("\\s+")[1].charAt(0);
                    int index = 0;
                    index = text.indexOf(indexOf);
                    System.out.println(index);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(input.split("\\s+")[1]);
                    int length = Integer.parseInt(input.split("\\s+")[2]);

                    text = text.substring(startIndex, startIndex + length);
                    System.out.println(text);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}