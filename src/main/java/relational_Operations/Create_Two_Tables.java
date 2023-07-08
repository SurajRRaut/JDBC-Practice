package relational_Operations;

// CREATE THE TABLE CUSTOMER AND PRODUCTS (DEPENDS ON PRODUCTS AND CUSTOMER TABLE CREATED IN DATABASE)..
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Create_Two_Tables {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        Statement stmt = null;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Enter Details for Customer Table");
        System.out.println("You Want Insert Values In Customer Table\n1. Yes\n2. No");
        int sure = sc.nextInt();
        if (sure==1) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Enter customer id");
                int id = sc.nextInt();
                System.out.println("Enter Customer name");
                String name = sc.next();
                System.out.println("Enter Customer Address");
                String add = sc.next();

                String query1 = "insert into customer values(" + id + ",'" + name + "','" + add + "')";
                try {
                    stmt = con.createStatement();
                    int count = stmt.executeUpdate(query1);
                    if (count > 0) {
                        System.out.println(count + " Data Inserted Successfully");
                    } else {
                        System.out.println("Data Not Inserted");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("WANT TO EXIT ?\n1. Yes(FOR EXIT...!)\n2. No(CONTINUE TO NEXT ROW...)");
                int x = sc.nextInt();
                if(x==1){
                    break;
                }
            }
        }else {
            System.out.println("RECORD NO INSERT YET IN CUSTOMER TABLE 👍");
            System.out.println("-----------------------------------------");
        }
        System.out.println("Want To Insert Records In Product Table ?\n1. yes\n2. no");
        int confirm = sc.nextInt();
        if(confirm==1){
            System.out.println("Enter details for product table");
            for (int i = 0; i < 10; i++) {
                System.out.println("Enter Product id");
                int id = sc.nextInt();
                System.out.println("Enter Product name");
                String name = sc.next();
                System.out.println("Enter Product Category");
                String cat = sc.next();
                System.out.println("Enter Product Price");
                double price = sc.nextDouble();
                System.out.println("Enter Product Reference");
                int ref = sc.nextInt();
                String query2 = "insert into products values (" + id + ",'" + name + "','" + cat + "'," + price + "," + ref + ")";
                try {
                    stmt = con.createStatement();
                    int count2 = stmt.executeUpdate(query2);
                    if (count2 > 0) {
                        System.out.println(count2 + " Data Inserted Successfully");
                    } else {
                        System.out.println("Data Not Inserted");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("WANT TO EXIT ?\n1. Yes(FOR EXIT...!)\n2. No(CONTINUE TO NEXT ROW...)");
                int x = sc.nextInt();
                if(x==1){
                    break;
                }
            }
        }
        else {
            System.out.println("RECORD NO INSERT YET IN PRODUCT TABLE 👍");
            System.out.println("----------------------------------------");
        }
        System.out.println("EXITED SUCCESSFULLY....!\nTIP : IF WANT INSERT RECORDS ? RUN THE PROGRAM AGAIN");
    }
}
