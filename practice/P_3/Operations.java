package practice.P_3;

import java.sql.*;

public class Operations {
    static Connection con =null;
    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void worstWeapon() {
        Statement stmt = null;
        ResultSet rs = null;
        String worst ="SELECT * FROM freefire WHERE Damage=(SELECT MIN(Damage)FROM freefire)";
        try {
            stmt =con.createStatement();
            rs=stmt.executeQuery(worst);
            if (rs.next()){
                System.out.println("THIS IS WORST WEAPON : ");
                System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6)+"\t"+rs.getInt(7));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void weaponRange400_600() {
        Statement stmt = null;
        ResultSet rs = null;
        String worst ="SELECT * FROM freefire  WHERE Rangee BETWEEN 400 AND 600";
        try {
            stmt =con.createStatement();
            rs=stmt.executeQuery(worst);
            System.out.println("THE WEAPON ARE RANGE BETWEEN 400 TO 600 : ");
            while(rs.next()){
                System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6)+"\t"+rs.getInt(7));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void weaponTypeAndCount() {
        Statement stmt = null;
        ResultSet rs = null;
        String worst ="SELECT weaponType,COUNT(WeaponType) AS HowMuch FROM freefire GROUP BY WeaponType";
        try {
            stmt =con.createStatement();
            rs=stmt.executeQuery(worst);
            System.out.println("TYPE OF WEAPON WITH COUNT : ");
            while(rs.next()){
                System.out.println(rs.getString(1)+"\t"+rs.getInt(2));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void totalDamageByAssAndSniRiffle() {
        Statement stmt = null;
        ResultSet rs = null;
        String worst ="SELECT SUM(Damage) AS Total_DMG_By_AssaultAndSnipper_Riffle FROM freefire WHERE WeaponType='ASSAULT_RIFFLE' OR WeaponType='SNIPPER_RIFFLE'";
        try {
            stmt =con.createStatement();
            rs=stmt.executeQuery(worst);
            if(rs.next()){
                System.out.println("TOTAL DAMAGE BY ASSAULT AND SNIPER RIFFLE : ");
                System.out.println(rs.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void weaponNameWhoNotContain_C_Char() {
        Statement stmt = null;
        ResultSet rs = null;
        String worst ="SELECT WeaponName FROM freefire WHERE WeaponName NOT LIKE '%C%'";
        try {
            stmt =con.createStatement();
            rs=stmt.executeQuery(worst);
            System.out.println("THE LIST OF WEAPON NAME BELOW WHO NOT CONTAINS C CHAR : ");
            while(rs.next()){
                System.out.println(rs.getString(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void weaponNameAndItsTypeAfterRemoving_FF() {
        Statement stmt = null;
        ResultSet rs = null;
        String worst ="SELECT REPLACE(WeaponName,'FF','') AS Weapon_Name,REPLACE(WeaponType,'FF','') AS WeaponType FROM freefire";
        try {
            stmt =con.createStatement();
            rs=stmt.executeQuery(worst);
            System.out.println("THE LIST OF WEAPON NAME AND WEAPON TYPE BELOW AFTER REMOVING FF FROM THEIR NAMES : ");
            while(rs.next()){
                System.out.println(rs.getString(1)+"\t"+rs.getString(2));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
