package practice.P_3;

import practice.P_2.Operation;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        access();
    }
    private static void access(){
        while (true) {
            System.out.println("CHECK WHAT YOU WANT ✔");
            System.out.println("1. DISPLAY WEAPON NAME WHOSE DAMAGE IS WORST ");
            System.out.println("2. DISPLAY THE WEAPON DETAILS WHOSE RANGE IS BETWEEN 400 - 600");
            System.out.println("3. DISPLAY THE WEAPON TYPE AND THEIR COUNT PRESENT INSIDE THE TABLE");
            System.out.println("4. DISPLAY THE TOTAL DAMAGE CLONE BY ASSAULT RIFFLE AND SNIPER RIFFLE");
            System.out.println("5. DISPLAY THE WEAPON NAMES WHICH DOES NOT CONTAIN 'C' CHARACTERS");
            System.out.println("6. DISPLAY ALL THE WEAPON NAME AND WEAPON TYPE AFTER REMOVING FF FROM THEIR NAME");
            System.out.println("7. EXIT");
            int check = sc.nextInt();
            switch (check) {
                case 1:
                    Operations.worstWeapon();
                    break;
                case 2:
                    Operations.weaponRange400_600();
                    break;
                case 3:
                    Operations.weaponTypeAndCount();
                    break;
                case 4:
                    Operations.totalDamageByAssAndSniRiffle();
                    break;
                case 5:
                    Operations.weaponNameWhoNotContain_C_Char();
                    break;
                case 6:
                    Operations.weaponNameAndItsTypeAfterRemoving_FF();
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
