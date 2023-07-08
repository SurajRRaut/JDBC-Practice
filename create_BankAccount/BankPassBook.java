package create_BankAccount;
// EXECUTABLE CLASS / OPERATION
//table uses bankptrassbook and userlogin
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BankPassBook {
    public static void main(String[] args) {
       operations();
    }
    private static void operations(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username");
        String username = sc.next();
        System.out.println("Enter password");
        String pass = sc.next();
        boolean result = UserLogin.validateLogin(username,pass);
        if (result==true){
            System.out.println("WELCOME "+UserLogin.userName);
            boolean status = true;
            while (status) {
                System.out.println("1. DEPOSITE AMT\n2. WITHDRAW AMT\n3. CHECK BALANCE\n4. ACCOUNT STATEMENT\n5. LOGOUT\n6. EXIT");
                int choice = sc.nextInt();
                switch (choice){
                    case 1 :
                        System.out.println("ENTER AMOUNT TO Deposite");
                        double amt = sc.nextDouble();
                        UserLogin.deposite(amt);
                        break;
                    case 2 :
                        System.out.println("ENTER AMOUNT TO Withdraw");
                        double amt1 = sc.nextDouble();
                        UserLogin.withdraw(amt1);
                        break;
                    case 3 :
                        UserLogin.checkBalance();
                        break;
                    case 4 :
                        UserLogin.statement();
                        break;
                    case 5 :
                        System.out.println("THANK YOU FOR VISITING");
                        UserLogin.userName= null;
                        UserLogin.accountnumber=0;
                        operations();
                        break;
                    case 6 :
                        System.out.println("EXIT SUCCESSFULLY...");
//                      System.exit(0);
                        status=false;
                        break;
                    default: {
                        System.out.println("INVALID INPUT");
                    }
                }
            }
        }else {
            System.out.println("INVALID USERNAME OR PASSWORD");
            operations();
        }
    }
}
// For check balance query is >>>
// SELECT total_amount FROM bankptrassbook FULL JOIN userlogin ON account_no=acc_no WHERE account_no = 1001 ORDER BY transaction_id DESC LIMIT 1;