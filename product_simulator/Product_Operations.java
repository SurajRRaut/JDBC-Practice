package product_simulator;
// DEPENDS ON PRODUCT TABLE CREATED IN DATABASE...
import java.sql.*;
import java.util.Scanner;
public class Product_Operations {
    static Scanner sc = new Scanner(System.in);
    static  Statement stmt = null;
    static Connection con = null;
    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(int id, String name, String category, String sub_category, double price, int qty) {
        String insertQuery = "insert into product values("+id+",'"+name+"','"+category+"','"+sub_category+"',"+price+","+qty+")";
        try {
            int count = con.createStatement().executeUpdate(insertQuery);
            if (count>0){
                System.out.println(count + "DATA Inserted Successfully");
            } else{
                System.out.println("DATA Not Found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id) {
        System.out.println("Choose option what u want update\n1. ID\n2. NAME\n3. CATEGORY\n4. SUB-CATEGORY\n5. PRICE\n6. QUANTITY");
        int update = sc.nextInt();
        switch(update){
            case 1 : {
                System.out.println("Enter new Id");
                int newId = sc.nextInt();
                String query = "update product set product_id="+newId+" where product_id="+id;
                try {
                    int count = con.createStatement().executeUpdate(query);
                    if (count>0){
                        System.out.println(count+"Data Updated Successfully");
                    }
                    else {
                        System.out.println("Data Not Found");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            break;
            case 2 : {
                System.out.println("Enter New Name");
                String newName = sc.next();
                String query = "update product set product_name='"+newName+"' where product_id="+id;
                try {
                    int count = con.createStatement().executeUpdate(query);
                    if (count>0){
                        System.out.println(count+"Data Updated Successfully");
                    }
                    else {
                        System.out.println("Data Not Found");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            break;
            case 3 : {
                System.out.println("Enter New Category");
                String newCategory = sc.next();
                String query = "update product set product_cat='"+newCategory+"' where product_id="+id;
                try {
                    int count = con.createStatement().executeUpdate(query);
                    if (count>0){
                        System.out.println(count+"Data Updated Successfully");
                    }
                    else {
                        System.out.println("Data Not Found");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            break;
            case 4 : {
                System.out.println("Enter New Sub-Category");
                String newSubCategory = sc.next();
                String query = "update product set product_sub_cat='"+newSubCategory+"' where product_id="+id;
                try {
                    int count = con.createStatement().executeUpdate(query);
                    if (count>0){
                        System.out.println(count+"Data Updated Successfully");
                    }
                    else {
                        System.out.println("Data Not Found");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            break;
            case 5 : {
                System.out.println("Enter New Product Price");
                double newProductPrice = sc.nextDouble();
                String query = "update product set product_price="+newProductPrice+" where product_id="+id;
                try {
                    int count = con.createStatement().executeUpdate(query);
                    if (count>0){
                        System.out.println(count+"Data Updated Successfully");
                    }
                    else {
                        System.out.println("Data Not Found");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            break;
            case 6 : {
                System.out.println("Enter New Product Quantity");
                int newProductQty = sc.nextInt();
                String query = "update product set product_qty="+newProductQty+" where product_id="+id;
                try {
                    int count = con.createStatement().executeUpdate(query);
                    if (count>0){
                        System.out.println(count+"Data Updated Successfully");
                    }
                    else {
                        System.out.println("Data Not Found");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            break;
            default :{
                System.out.println("Something Went Wrong......");
            }
        }
    }
    public void delete(String pName) {
        String query = "delete from product where product_name='"+pName+"'";
        try {
            int count = con.createStatement().executeUpdate(query);
            if (count>0){
                System.out.println(count+"Data DELETED Successfully");
            }
            else {
                System.out.println("Data Not Found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void display() {
        ResultSet rs = null;
        String displayQuery = "select product_name,product_price from product";
        try {
            stmt = con.createStatement();
            rs=stmt.executeQuery(displayQuery);
            while (rs.next()){
                System.out.println(rs.getString(1)+"\t"+rs.getInt(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
