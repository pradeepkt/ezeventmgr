/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeventmanager.user;
import ezeventmanager.vendor.*;
import java.util.ArrayList;

/**
 *
 * @author t.pradeepkumar
 */
public class VendorUser implements User{
    
    /**
     * Vendor Roles
     */
    private ArrayList _vendorRoleList = new ArrayList();
    public ArrayList getVendorRoles()
    {
        return _vendorRoleList;
    }
    
    public void addRole(Vendor vendorRole)
    {
        _vendorRoleList.add(vendorRole);
    }
    
}
