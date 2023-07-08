package practice.P_1;
// table uses the redbusapp and redbuslogin
import java.util.Scanner;

public class RED_BUS {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        processing();
    }
    private static void processing() {
        System.out.println("ENTER USER NAME");
        String nm = sc.next();
        System.out.println("ENTER USER PASSWORD");
        String ps = sc.next();
        boolean status = USER.userLogin(nm, ps);
        if (status == true) {
            boolean condition = true;
            while(condition) {
                System.out.println("WELCOME " + USER.name + " SELECT OPTION TO FURTHER PROCESS");
                System.out.println("1. BOOK A NEW TICKET");
                System.out.println("2. MODIFY YOUR DETAILS OF TICKET");
                System.out.println("3. DELETE THE TICKET");
                System.out.println("4. SHOW TICKET DETAILS");
                System.out.println("5. LOGOUT THE APP");
                System.out.println("6. EXIT THE APP");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("ENTER BUS TYPE");
                        String bType = sc.next();
                        System.out.println("ENTER SEAT NUMBER");
                        int sNumber = sc.nextInt();
                        System.out.println("ENTER GENDER");
                        String gender = sc.next();
                        System.out.println("ENTER AGE");
                        int age = sc.nextInt();
                        System.out.println("ENTER BOOKING REFERENCE");
                        int bRef = sc.nextInt();
                        USER.bookTicket(bType,sNumber,gender,age,bRef);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        nm = null;
                        ps = null;
                        System.out.println("LOGOUT SUCCESSFULLY");
                        processing();
                        break;
                    case 6:
                        System.out.println("EXITED SUCCESSFULLY...");
                        System.exit(0);
                        break;
                    default: {
                        System.out.println("YOU CHOOSE WRONG OPTION PLS TRY AGAIN....");
                    }
                }
            }
        }
        else {
            processing();
        }
    }
}
