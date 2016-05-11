/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager;

import ezeventmanager.events.*;
import ezeventmanager.user.*;
import java.util.ArrayList;

/**
 *
 * @author t.pradeepkumar
 */
public abstract class EventManagerImpl implements EventManager {
    
    /**
     * List of Events to be managed
     */
    protected ArrayList<Events> eventList = new ArrayList<>();
    
    /**
     * List of users associated with events
     */
    protected ArrayList<User> userList = new ArrayList<>();
    
}
