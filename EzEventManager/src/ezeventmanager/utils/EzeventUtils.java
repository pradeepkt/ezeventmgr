/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeventmanager.utils;

import ezeventmanager.user.CorporateUser;
import ezeventmanager.user.Customer;
import ezeventmanager.user.User;
import ezeventmanager.user.VendorUser;
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
     *
     * @return get all contacts
     */
    public static ArrayList<Contact> getAllContacts() {
        class Local {
        }
        String function_name = Local.class.getEnclosingMethod().getName();
        System.out.println("Function name: " + function_name);
        Connection conn = null;
        Statement stmt = null;
        ArrayList<Contact> theList = new ArrayList<>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(Constants.JDBC_DRIVER);

            //STEP 3: Open a connection
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USER,
                    Constants.DB_PASS);

            //STEP 4: Execute a query
            //System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Contact ;";
            //STEP 5: Extract data from result set
            try (ResultSet rs = stmt.executeQuery(sql)) {
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
            }
            stmt.close();
            conn.close();
            return theList;
        } catch (SQLException | ClassNotFoundException se) {
            //Handle errors for JDBC
            System.out.println(se.getMessage());
        } //Handle errors for Class.forName
        finally {
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
        //System.out.println("Goodbye!");
        return null;
    }

    /**
     * Get all the contacts
     *
     * @return get all contacts
     */
    public static ArrayList<User> getAllUsers() {
        class Local {
        }
        String function_name = Local.class.getEnclosingMethod().getName();
        System.out.println("Function name: " + function_name);
        Connection conn = null;
        Statement stmt = null;
        ArrayList<User> theList = new ArrayList<>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(Constants.JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USER,
                    Constants.DB_PASS);

            //STEP 4: Execute a query
            //System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM User ;";
            //STEP 5: Extract data from result set
            try (ResultSet rs = stmt.executeQuery(sql)) {
                //STEP 5: Extract data from result set
                while (rs.next()) {
                    User tobeAdded = null;
                    String role = rs.getString("userrole");
                    if (null != role) {
                        switch (role) {
                            case "CUSTOMER":
                                tobeAdded = new Customer();
                                break;
                            case "VENDOR":
                                tobeAdded = new VendorUser();
                                break;
                            case "CORPORATE":
                                tobeAdded = new CorporateUser();
                                break;
                            default:
                                tobeAdded = new Customer();
                        }
                    } else {
                        tobeAdded = new Customer();
                    }
                    Contact userContact = new Contact();
                    userContact.retrieveContact(rs.getLong("contactId"));
                    tobeAdded.setContact(userContact);
                    tobeAdded.setUserId(rs.getLong("iduser"));
                    tobeAdded.setEventLists(rs.getString("listEvents"));
                    tobeAdded.setRole(tobeAdded.getRoleFromString(rs.getString("userRole")));
                    tobeAdded.setVendorId(rs.getLong("vendorid"));
                    //Add to the list
                    theList.add(tobeAdded);
                }
                //STEP 6: Clean-up environment
            }
            stmt.close();
            conn.close();
            return theList;
        } catch (SQLException | ClassNotFoundException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } //Handle errors for Class.forName
        finally {
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
        //System.out.println("Goodbye!");
        return null;
    }

}
