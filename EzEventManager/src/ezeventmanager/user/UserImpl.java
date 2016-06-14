/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeventmanager.user;

import ezeventmanager.utils.Contact;
import ezeventmanager.utils.DBConnectionManager;

/**
 *
 * @author t.pradeepkumar
 */
public abstract class UserImpl implements User {

    /**
     * Contact information for the user
     */
    protected Contact _userContact = new Contact();

    /**
     * User Id
     */
    private long _userId;

    /**
     * Get the user id
     *
     * @return
     */
    @Override
    public long getUserId() {
        return _userId;
    }

    /**
     * Set the user id
     *
     * @param uid
     */
    @Override
    public void setUserId(long uid) {
        _userId = uid;
    }

    /**
     * Get the contact information
     *
     * @return
     */
    @Override
    public Contact getContact() {
        return _userContact;
    }

    /**
     * Set the contact info
     *
     * @param cont
     */
    @Override
    public void setContact(Contact cont) {
        _userContact = cont;
    }

    /**
     * User role
     */
    private UserRole _role;

    /**
     * Get the role
     *
     * @return
     */
    @Override
    public UserRole getRole() {
        return _role;
    }

    /**
     * Set the role
     *
     * @param rl
     */
    @Override
    public void setRole(UserRole rl) {
        _role = rl;
    }

    /**
     * Event List
     */
    private String _eventLists = new String();

    /**
     * Get the list of events associated with the user
     *
     * @return
     */
    @Override
    public String getEventLists() {
        return _eventLists;
    }

    /**
     * Set the list of events
     *
     * @param evList
     */
    @Override
    public void setEventLists(String evList) {
        _eventLists = evList;
    }

    /**
     * Default constructor
     */
    protected UserImpl() {

    }

    /**
     * User implementation
     *
     * @param cont
     */
    protected UserImpl(Contact cont) {
        _userContact = new Contact(cont);
    }

    /**
     * Vendor Id
     */
    private long _vendorId;
    
    /**
     * Get vendor Id
     * @return
     */
    @Override
    public long getVendorId()
    {
        return _vendorId;
    }
    
    /**
     * Set the vendor Id
     * @param vendor 
     */
    public void setVendorId(long vendor)
    {
        _vendorId = vendor;
    }
    /**
     * Get the role string
     *
     * @param role
     * @return
     */
    @Override
    public String getRoleString(UserRole role) {
        switch (role) {
            case CORPORATE:
                return "CORPORATE";
            case CUSTOMER:
                return "CUSTOMER";
            case VENDOR:
                return "VENDOR";
            default:
                return null;
        }
    }

    /**
     * Get the role
     *
     * @param role
     * @return
     */
    @Override
    public UserRole getRoleFromString(String role) {
        if (null != role) {
            switch (role) {
                case "CORPORATE":
                    return UserRole.CORPORATE;
                case "CUSTOMER":
                    return UserRole.CUSTOMER;
                case "VENDOR":
                    return UserRole.INVALID;
                default:
                    return UserRole.INVALID;
            }
        } else {
            return UserRole.INVALID;
        }
    }

    @Override
    public String toString() {
        StringBuilder fullString = new StringBuilder();
        fullString.append("User Id: ").append(_userId).append("\n");
        fullString.append("Role: ").append(_role).append("\n");
        fullString.append("Contact: ").append(_userContact.toString()).append("\n");
        return fullString.toString();
    }

    @Override
    public long persist() {
        String insertQuery = "INSERT INTO `EzEvents`.`User`"
                + "(`idUser`,`contactID`,`listEvents`,`userRole`,'vendorID') "
                + "VALUES (" + _userId + ",'" + _userContact.getId() + "','" + _eventLists + "','"
                + getRoleString(_role) + "', '" + _vendorId + "')"
                + " on duplicate key update "
                + "idUser=" + _userId + ","
                + "contactID='" + _userContact.getId() + "',"
                + "listEvents='" + _eventLists + "',"
                + "userRole='" + getRoleString(_role) + "',"
                + "vendorId=" + _vendorId;
        //System.out.println("Insert query is " + insertQuery);
        return DBConnectionManager.persist(insertQuery);
    }
}
