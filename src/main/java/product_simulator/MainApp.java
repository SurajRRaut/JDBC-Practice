package product_simulator;
import java.util.Scanner;
// INSERT, UPDATE, DELETE, DISPLAY IN A SINGLE PROGRAM...
public class MainApp {
    private static Scanner sc = new Scanner(System.in);
    private static Product_Operations po = new Product_Operations();
    public static void main(String[] args) {
        operations();
    }
    private static void operations(){
        boolean exit = true;
        while(exit) {
            System.out.println("1. ADD PRODUCT\n2. UPDATE PRODUCT\n3. DELETE PRODUCT\n4. DISPLAY PRODUCT\n5. EXIT");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: addProduct();
                    break;
                case 2: updateProduct();
                    break;
                case 3: deleteProduct();
                    break;
                case 4: displayProduct();
                    break;
                case 5: {
                    System.out.println("EXITED SUCCESSFULLY");
                    exit = false;
                }
                    break;
                default: {
                    System.out.println("SOMETHING WENT WRONG");
                }
            }
        }
    }
    private static void addProduct(){
        System.out.println("ENTER PRODUCT ID");
        int id = sc.nextInt();
        System.out.println("ENTER PRODUCT NAME");
        String name = sc.next();
        System.out.println("ENTER PRODUCT CATEGORY");
        String category = sc.next();
        System.out.println("ENTER PRODUCT SUB CATEGORY");
        String sub_category = sc.next();
        System.out.println("ENTER PRODUCT PRICE");
        double price = sc.nextDouble();
        System.out.println("ENTER PRODUCT QUANTITY");
        int qty = sc.nextInt();
        po.add(id,name,category,sub_category,price,qty);
    }
    private static void updateProduct(){
        System.out.println("Enter id to Update details");
        int id = sc.nextInt();
        po.update(id);
    }
    private static void deleteProduct(){
        System.out.println("ENTER PRODUCT NAME TO DELETE");
        String pName = sc.next();
        po.delete(pName);
    }
    private static void displayProduct(){
        po.display();
    }
}
