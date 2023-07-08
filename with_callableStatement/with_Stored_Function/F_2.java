package with_callableStatement.with_Stored_Function;

import java.sql.*;

public class F_2 {
    public static void main(String[] args) {
        Connection con = null;
        CallableStatement cstmt = null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            cstmt=con.prepareCall("{?=call Demo1(?)}");
            cstmt.setInt(2,1);
            cstmt.registerOutParameter(1, Types.VARCHAR);
            cstmt.execute();
            System.out.println(cstmt.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
