/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeventmanager.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author t.pradeepkumar
 */
public class EzeventUtils {
    
    /**
     * Get all the contacts
     * @return get all contacts
     * @return List of contacts
     */
    public static ArrayList<Contact> getAllContacts() {
        class Local {
        };
        String function_name = Local.class.getEnclosingMethod().getName();
        System.out.println("Function name: " + function_name);
        Connection conn = null;
        Statement stmt = null;
        ArrayList<Contact> theList = new ArrayList<>();
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
            sql = "SELECT * FROM Contact ;" ;
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                Contact tobeAdded = new Contact();
                //Retrieve by column name
                tobeAdded.setId(rs.getLong("idContact"));
                tobeAdded.setName(rs.getString("Name"));
                tobeAdded.setEmail(rs.getString("email"));
                tobeAdded.setMobile(rs.getString("mobile"));
                tobeAdded.setPhone(rs.getString("phone"));
                tobeAdded.setAddressOffice(rs.getString("addressoffice"));
                tobeAdded.setAddressHome(rs.getString("addresshome"));

                //Add to the list
                theList.add(tobeAdded);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return theList;
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
        return null;
    }    
    
}
