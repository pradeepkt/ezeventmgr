/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeventmanager.utils;

import java.sql.*;

/**
 *
 * @author t.pradeepkumar
 */
public class DBConnectionManager {
    // JDBC driver name and database URL

    /**
     * Used for insert queries
     * @param insertQuery
     * @return 
     */
    public static long persist(String insertQuery)
    {
        
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(Constants.JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USER, 
                    Constants.DB_PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            int result = stmt.executeUpdate(insertQuery);

            //STEP 6: Clean-up environment
            stmt.close();
            conn.close();
            return Constants.SUCCESS;
        } catch (SQLException se) {
            //Handle errors for JDBC
            System.out.println(se.getMessage());
        } catch (Exception e) {
            //Handle errors for Class.forName
            System.out.println(e.getMessage());
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                System.out.println(se2.getMessage());
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                System.out.println(se.getMessage());
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return Constants.DB_CONN_ERR;
    }
    
    /**
     * 
     */
    public static void connectToDB() {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(Constants.JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USER, 
                    Constants.DB_PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Contact";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String id = rs.getString("idContact");
                String name = rs.getString("Name");
                String mail = rs.getString("email");
                String mob = rs.getString("mobile");
                String phone = rs.getString("phone");
                String addr_o = rs.getString("addressoffice");
                String addr_h = rs.getString("addresshome");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Name: " + name);
                System.out.print(", Mail: " + mail);
                System.out.print(", Mobile: " + mob);
                System.out.print(", phone: " + phone);
                System.out.print(", Addr_Off: " + addr_o);
                System.out.println(", Addr_Home: " + addr_h);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            System.out.println(se.getMessage());
        } catch (Exception e) {
            //Handle errors for Class.forName
            System.out.println(e.getMessage());
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                System.out.println(se2.getMessage());
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                System.out.println(se.getMessage());
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

}
