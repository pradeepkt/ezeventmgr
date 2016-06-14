/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeventmanager;

import ezeventmanager.events.Birthday;
import ezeventmanager.events.Events;
import ezeventmanager.events.Events.Status;
import ezeventmanager.user.User;
import ezeventmanager.utils.Contact;
import ezeventmanager.utils.EzeventUtils;
import java.sql.Timestamp;
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
        //Contact myContact = new Contact(2L, "Jerry", "jerry@ezevents.com", "1111111111", "1111111111",
        //        "Address_Off", "Address_Home");
        //myContact.persist();
        
        //ArrayList<Contact> allList = EzeventUtils.getAllContacts();
        ArrayList<User> allUsers = EzeventUtils.getAllUsers();
        for (int i = 0; i < allUsers.size(); ++i)
        {
            System.out.println(allUsers.get(i).toString());
        }
        allUsers.get(0).setRole(User.UserRole.CUSTOMER);
        allUsers.get(0).persist();
        System.out.println(allUsers.get(0).toString());
        
        Timestamp start = new Timestamp(78,06,05,0,0,0,0);
        Timestamp end = new Timestamp(78,06,05,23,59,0,0);
        
        Birthday myday = new Birthday(2,start,end,allUsers.get(0),Events.EventType.CORPORATE_TEAMOUTING,Status.INPROGRESS);
        myday.persist();

        System.out.println("Success");
    }

}
