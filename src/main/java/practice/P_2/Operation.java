package practice.P_2;

import java.sql.*;

public class Operation {
    static Connection con =null;
    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void qualifiedTeams() {
        Statement stmt = null;
        ResultSet rs = null;
        String query ="SELECT * FROM pointstable ORDER BY points DESC LIMIT 4";
        try {
            stmt =con.createStatement();
            rs=stmt.executeQuery(query);
            System.out.println("THIS TEAMS IS QUALIFIED : ");
            while (rs.next()){
                System.out.println(rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6)+"\t"+rs.getDouble(7)+"\t"+rs.getInt(8));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void performance() {
        Statement stmt = null;
        ResultSet rs = null;
        String best ="SELECT * FROM pointstable WHERE win =(SELECT MAX(win)FROM pointstable)";
        String worst ="SELECT * FROM pointstable WHERE win =(SELECT MIN(win)FROM pointstable)";
        String avg ="SELECT * FROM pointstable WHERE win =(SELECT ROUND(AVG(win))FROM pointstable) order by nrr desc limit 1";

        try {
            stmt =con.createStatement();
            rs=stmt.executeQuery(best);
            if (rs.next()){
                System.out.println("THIS IS BEST PERFORMANCE TEAMS : ");
                System.out.println(rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6)+"\t"+rs.getDouble(7)+"\t"+rs.getInt(8));
            }
            rs=stmt.executeQuery(worst);
            if (rs.next()){
                System.out.println("THIS IS WORST PERFORMANCE TEAMS : ");
                System.out.println(rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6)+"\t"+rs.getDouble(7)+"\t"+rs.getInt(8));
            }
            rs=stmt.executeQuery(avg);
            System.out.println("THIS IS AVERAGE PERFORMANCE TEAMS : ");
            if (rs.next()){
                System.out.println(rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6)+"\t"+rs.getDouble(7)+"\t"+rs.getInt(8));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sameWinLossPerTeamName() {
        Statement stmt = null;
        ResultSet rs = null;
        String query ="SELECT team FROM pointstable WHERE win=loss;";
        try {
            stmt =con.createStatement();
            rs=stmt.executeQuery(query);
            System.out.println("THIS IS TEAMS WHOSE WIN AND LOSE PERCENTAGE ARE SAME");
            while (rs.next()){
                System.out.println(rs.getString(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void matchTiedTeamNames() {
        Statement stmt = null;
        ResultSet rs = null;
        String query ="SELECT team FROM pointstable WHERE tied IS NOT NULL";
        try {
            stmt =con.createStatement();
            rs=stmt.executeQuery(query);
            System.out.println("MATCH TIED TEAM NAMES ARE : ");
            while (rs.next()){
                System.out.println(rs.getString(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void teamsWinRateMaxThanLoseRate() {
        Statement stmt = null;
        ResultSet rs = null;
        String query ="SELECT * FROM pointstable WHERE win>loss";
        try {
            stmt =con.createStatement();
            rs=stmt.executeQuery(query);
            System.out.println("THIS IS TEAMS WHOSE WINING MATCHES ARE GREATER THAN LOSE");
            while (rs.next()){
                System.out.println(rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6)+"\t"+rs.getDouble(7)+"\t"+rs.getInt(8));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void displayAllTeamByPoints() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query ="SELECT team,points FROM pointstable ORDER BY points DESC";
        try {
            pstmt =con.prepareStatement(query);
            rs=pstmt.executeQuery();
            int num=1;
            while(rs.next()) {
                System.out.print(num+++"\t");
                System.out.println(rs.getString(1) + "\t" + rs.getInt(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
