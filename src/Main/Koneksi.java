package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Koneksi {

    public Connection cn;
    public Statement sn;
    
    public Connection koneksiDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/db_cakramas", "root", "");
            sn = cn.createStatement();

        } catch (Exception e) {

            System.out.println("show error " + e.getMessage());
        }
        return cn;
    }
}
