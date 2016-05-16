/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeventmanager;

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
        Contact myContact = new Contact(2L, "Jerry", "jerry@ezevents.com", "1111111111", "1111111111",
                "Address_Off", "Address_Home");
        myContact.persist();
        
        ArrayList<Contact> allList = EzeventUtils.getAllContacts();
        for (int i = 0; i < allList.size(); ++i)
        {
            System.out.println(allList.get(i).toString());
        }
        System.out.println("Success");
    }

}
