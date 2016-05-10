/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeventmanager;

import ezeventmanager.utils.DBConnectionManager;

/**
 *
 * @author t.pradeepkumar
 */
public class EzEventManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBConnectionManager.connectToDB();
        System.out.println("Success");
    }
    
}
