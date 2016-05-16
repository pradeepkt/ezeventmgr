/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basefunctionalitytest;

import ezeventmanager.utils.Contact;

/**
 *
 * @author t.pradeepkumar
 */
public class ContactTest {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Contact myContact = new Contact(1L);
        myContact.setAddressHome("Madurai");
        myContact.persist();
        System.out.println(myContact.toString());
        System.out.println("Success");
    }

}
