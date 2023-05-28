package TheFinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_MessagesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        Map<String, Integer> sentMessages = new LinkedHashMap<>();
        Map<String, Integer> receivedMessages = new LinkedHashMap<>();

        while (!input.equals("Statistics")){
            String command = input.split("=")[0];
            switch (command){
                case "Add":
                    String username = input.split("=")[1];
                    int sent = Integer.parseInt(input.split("=")[2]);
                    int received = Integer.parseInt(input.split("=")[3]);
                    if (sentMessages.containsKey(username)){
                        break;
                    } else {
                        sentMessages.put(username, sent);
                        receivedMessages.put(username, received);
                    }
                    break;
                case "Message":
                    String sender = input.split("=")[1];
                    String receiver = input.split("=")[2];
                    if (sentMessages.containsKey(sender) && receivedMessages.containsKey(receiver)){
                        sentMessages.put(sender, sentMessages.get(sender) + 1);
                        receivedMessages.put(receiver, receivedMessages.get(receiver) + 1);
                    }
                    if (sentMessages.get(sender) + receivedMessages.get(sender) >= n){
                        System.out.printf("%s reached the capacity!%n", sender);
                        sentMessages.remove(sender);
                        receivedMessages.remove(sender);
                    } else if (sentMessages.get(receiver) + receivedMessages.get(receiver) >= n){
                        System.out.printf("%s reached the capacity!%n", receiver);
                        sentMessages.remove(receiver);
                        receivedMessages.remove(receiver);
                    }
                    break;
                case "Empty":
                    String name = input.split("=")[1];
                    if (sentMessages.containsKey(name)){
                        sentMessages.remove(name);
                        receivedMessages.remove(name);
                    } else {
                        sentMessages.clear();
                        receivedMessages.clear();
                    }
                    break;
            }


            input = scanner.nextLine();
        }
            int membersSize = sentMessages.size();
        System.out.printf("Users count: %d%n", membersSize);
        for (Map.Entry<String, Integer> entry : sentMessages.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue() + receivedMessages.get(entry.getKey()));
        }

    }
}
