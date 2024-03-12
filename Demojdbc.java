package gui_pro;

import java.sql.*;

public class Demojdbc {
    public static void main(String[] args) throws SQLException {
        String sql="select name from customer where number=9547262006";
        String url="jdbc:postgresql://localhost:5432/test";
        String username="postgres";
        String password="sql@2024";

        Connection con= DriverManager.getConnection(url,username,password);
        Statement st= con.createStatement();
        ResultSet rs=st.executeQuery(sql);
//        rs.next();
//        String name= rs.getString(1);
//        System.out.println(name);
    }
}
