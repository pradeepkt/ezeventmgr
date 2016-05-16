/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeventmanager.user;

import ezeventmanager.utils.Contact;

/**
 *
 * @author t.pradeepkumar
 */
public interface User {

    /**
     * User roles
     */
    public enum UserRole {
        CUSTOMER,
        VENDOR,
        CORPORATE,
        INVALID
    }

    public long getUserId();

    public Contact getContact();

    public UserRole getRole();

    public void setContact(Contact cont);

    public void setRole(UserRole rl);

    public void setUserId(long uid);
    
    public long persist();
    
    public String getEventLists();
    
    public void setEventLists(String evList);
    
    public String getRoleString(UserRole role);
    
    public UserRole getRoleFromString(String role);
    
    public long getVendorId();
    
    public void setVendorId(long vendor);

}
