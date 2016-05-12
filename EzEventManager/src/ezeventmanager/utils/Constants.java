/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeventmanager.utils;

/**
 *
 * @author t.pradeepkumar
 */
public final class Constants {
    
    /**
     * Error codes
     */
    public static final long SUCCESS = 0x00000000L;
    
    /**
     * DB Errors
     */
    public static final long DB_CONN_ERR = 0x10000001L;
    
    /**
     * DB Constants
     */
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost/EzEvents";

    //  Database credentials
    public static final String DB_USER = "root";
    public static final String DB_PASS = "root";
}
