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

/**
 *
 * @author t.pradeepkumar
 */
public class Contact {

    /**
     * Name of the contact
     */
    private long _id = 0;

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    /**
     * Name of the contact
     */
    private String _name = new String();

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    /**
     * Mail
     */
    private String _email = new String();

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    /**
     * Mobile
     */
    private String _mobile = new String();

    public String getMobile() {
        return _mobile;
    }

    public void setMobile(String mobile) {
        _mobile = mobile;
    }

    /**
     * Phone
     */
    private String _phone = new String();

    public String getPhone() {
        return _phone;
    }

    public void setPhone(String phone) {
        _phone = phone;
    }

    /**
     * Address Office
     */
    private String _addressOffice = new String();

    public String getAddressOffice() {
        return _addressOffice;
    }

    public void setAddressOffice(String addr_off) {
        _addressOffice = addr_off;
    }

    /**
     * Address Home
     */
    private String _addressHome = new String();

    public String getAddressHome() {
        return _addressHome;
    }

    public void setAddressHome(String addr_home) {
        _addressHome = addr_home;
    }

    /**
     *
     */
    public Contact() {

    }

    /**
     * Create contact from DB
     *
     * @param id
     */
    public Contact(long id) {
        _id = id;
        retrieveContact(_id);
    }

    /**
     * Constructor
     *
     * @param id
     * @param name
     * @param email
     * @param mobile
     * @param phone
     * @param addr_off
     * @param addr_home
     */
    public Contact(long id, String name, String email, String mobile, String phone,
            String addr_off, String addr_home) {
        _id = id;
        _name = name;
        _email = email;
        _mobile = mobile;
        _phone = phone;
        _addressOffice = addr_off;
        _addressHome = addr_home;
    }

    /**
     * Persist the current contact object
     *
     * @return
     */
    public long persist() {
        String insertQuery = "INSERT INTO `EzEvents`.`Contact`"
                + "(`idContact`,`Name`,`Email`,`Mobile`,`Phone`,"
                + "`AddressOffice`,`AddressHome`) "
                + "VALUES (" + _id + ",'" + _name + "','" + _email + "','"+ _mobile + "','" + _phone + "','"
                + _addressOffice + "','" + _addressHome + "') on duplicate key update "
                + "idContact=" + _id + ","
                + "Name='" + _name + "',"
                + "Email='" + _email + "',"
                + "Mobile='" + _mobile + "',"
                + "Phone='" + _phone + "',"
                + "AddressOffice='" + _addressOffice + "',"
                + "AddressHome='" + _addressHome + "'";
        System.out.println("Insert query is " + insertQuery);
        return DBConnectionManager.persist(insertQuery);
    }

    /**
     * Retrieve contact based on ID
     *
     * @param id
     */
    public void retrieveContact(long id) {
        class Local {
        };
        String function_name = Local.class.getEnclosingMethod().getName();
        System.out.println("Function name: " + function_name);
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
            sql = "SELECT * FROM Contact where idContact = " + id;
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                _name = rs.getString("Name");
                _email = rs.getString("email");
                _mobile = rs.getString("mobile");
                _phone = rs.getString("phone");
                _addressOffice = rs.getString("addressoffice");
                _addressHome = rs.getString("addresshome");

                //Display values
                System.out.println(toString());
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

    public String toString() {
        StringBuffer fullString = new StringBuffer();
        fullString.append("ID: " + _id );
        fullString.append(", Name: " + _name );
        fullString.append(", Mail: " + _email );
        fullString.append(", Mobile: " + _mobile );
        fullString.append(", phone: " + _phone );
        fullString.append(", Addr_Off: " + _addressOffice );
        fullString.append(", Addr_Home: " + _addressHome);
        return fullString.toString();

    }
}
