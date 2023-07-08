package practice.P_2;
//USE POINTS TABLE FOR THIS FROM DATABASE....
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        access();
    }
    private static void access(){
        while (true) {
            System.out.println("CHECK POINTS TABLE ✔");
            System.out.println("1. DISPLAY THE 4 TEAM WHICH ARE QUALIFIED");
            System.out.println("2. DISPLAY THE TEAM DETAILS WHERE PERFORMANCE IS BEST/AVERAGE/WORST");
            System.out.println("3. DISPLAY THE TEAM NAMES WHOSE WIN AND LOSS PERCENTAGE IS SAME");
            System.out.println("4. DISPLAY THE TEAM NAMES WHOSE MATCHES ARE TIED");
            System.out.println("5. DISPLAY THE TEAM WHOSE WINING MATCHES ARE GREATER THAN AS COMPARE TO LOSING MATCH");
            System.out.println("6. DISPLAY ALL THE TEAMS ACCORDING TO THE POINTS");
            System.out.println("7. EXIT");
            int check = sc.nextInt();
            switch (check) {
                case 1:
                    Operation.qualifiedTeams();
                    break;
                case 2:
                    Operation.performance();
                    break;
                case 3:
                    Operation.sameWinLossPerTeamName();
                    break;
                case 4:
                    Operation.matchTiedTeamNames();
                    break;
                case 5:
                    Operation.teamsWinRateMaxThanLoseRate();
                    break;
                case 6:
                    Operation.displayAllTeamByPoints();
                    break;
                case 7:
                    System.out.println("SUCCESSFULLY EXITED..😊 :)");
                    System.exit(0);
                    break;
                default: {
                    System.out.println("YOU CHOOSE WRONG OPTION..😒 :(");
                }
            }
        }
    }
}
