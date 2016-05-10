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
public class Contact {
    
    /**
     * Name of the contact
     */
    private String _name = new String();
    public String getName()
    {
        return _name;
    }
    public void setName(String name)
    {
        _name = name;
    }
    
    /**
     * Mail
     */
    private String _email = new String();
    public String getEmail()
    {
        return _email;
    }
    public void setEmail(String email)
    {
        _email = email;
    }

    /**
     * Mobile
     */
    private String _mobile = new String();
    public String getMobile()
    {
        return _mobile;
    }
    public void setMobile(String mobile)
    {
        _mobile = mobile;
    }

    /**
     * Phone
     */
    private String _phone = new String();
    public String getPhone()
    {
        return _phone;
    }
    public void setPhone(String phone)
    {
        _phone = phone;
    }

    /**
     * Address Office
     */
    private String _addressOffice = new String();
    public String getAddressOffice()
    {
        return _addressOffice;
    }
    public void setAddressOffice(String addr_off)
    {
        _addressOffice = addr_off;
    }

    /**
     * Address Home
     */
    private String _addressHome = new String();
    public String getAddressHome()
    {
        return _addressHome;
    }
    public void setAddressHome(String addr_home)
    {
        _addressHome = addr_home;
    }
    
}
