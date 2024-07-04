/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author tharu
 */
public class MYSQL {
      
    private static Connection c;
    private static final String username = "root";
    private static final String password = "";
    private static final String database = "advancar";

    public static Statement createConnection() throws Exception {
        if (c == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, username, password);
        }
        Statement s = c.createStatement();
        return s;
    }

    public static void iud(String query) {
        try {
            createConnection().executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ResultSet search(String query) throws Exception {

        ResultSet r = createConnection().executeQuery(query);
        return r;

    }
}
