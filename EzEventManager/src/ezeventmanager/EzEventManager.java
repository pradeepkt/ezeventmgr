/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeventmanager;

import ezeventmanager.user.User;
import ezeventmanager.utils.Contact;
import ezeventmanager.utils.EzeventUtils;
import java.util.ArrayList;

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
//        Contact myContact = new Contact(2L, "Jerry", "jerry@ezevents.com", "1111111111", "1111111111",
//                "Address_Off", "Address_Home");
//        myContact.persist();
        
        //ArrayList<Contact> allList = EzeventUtils.getAllContacts();
        ArrayList<User> allUsers = EzeventUtils.getAllUsers();
        for (int i = 0; i < allUsers.size(); ++i)
        {
            System.out.println(allUsers.get(i).toString());
        }
        allUsers.get(0).setRole(User.UserRole.CUSTOMER);
        allUsers.get(0).persist();
        System.out.println(allUsers.get(0).toString());
        System.out.println("Success");
    }

}
