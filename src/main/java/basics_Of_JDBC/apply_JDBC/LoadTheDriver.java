package basics_Of_JDBC.apply_JDBC;
// ADD THE DRIVER (ITS OPTIONAL HEAR ITS AUTOMATICALLY ADD BUT IS GOOD TO KNOW ALREADY..... HOW TO ADD DRIVER)
public class LoadTheDriver {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
        }
        catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
