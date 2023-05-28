package TheFinalExam;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_MessagesTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String regex = "![A-Z]{1}[a-z]{2,}!:\\[[A-Za-z0-9]{8,}\\]";
        Pattern pattern = Pattern.compile(regex);

        Map<String, List<String>> map = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String text = scanner.nextLine();
            Matcher matcher = pattern.matcher(text);
            if (!matcher.find()) {
                System.out.println("The message is invalid");
            } else {
                String name = text.split(":")[0];
                String realName = name.substring(1, name.length() - 1);
                String command = text.split(":")[1];
                String realCommand = command.substring(1, command.length() - 1);

                map.put(realName, new ArrayList<>());
                for (char symbol : realCommand.toCharArray()) {
                    char currentSymbol = symbol;
                    int valueOfSymbol = Character.valueOf(currentSymbol);
                    String value = String.valueOf(valueOfSymbol);

                    map.get(realName).add(value);

                }
                    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                        System.out.printf("%s: %s%n", entry.getKey(), String.join(" ", entry.getValue()));
                    }
            }
        }
    }
}
