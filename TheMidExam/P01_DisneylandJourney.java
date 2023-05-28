package MidExamRetake;

import java.util.Scanner;

public class P01_DisneylandJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double journeyCost = Double.parseDouble(scanner.nextLine());
        int monthsForSaving = Integer.parseInt(scanner.nextLine());

        double savedMoney = 0;
        for (int i = 1; i <= monthsForSaving; i++) {

            if (i % 2 == 1 && i != 1){
                savedMoney = savedMoney - (savedMoney * 0.16);
            }
            if (i % 4 == 0){
                savedMoney = savedMoney + (savedMoney * 0.25);
            }
            savedMoney = savedMoney + (journeyCost * 0.25);
        }
        if (savedMoney >= journeyCost){
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", savedMoney - journeyCost);
        } else {
            System.out.printf("Sorry. You need %.2flv. more.", journeyCost - savedMoney);
        }
    }
}
