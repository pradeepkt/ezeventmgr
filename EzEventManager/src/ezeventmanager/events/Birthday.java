/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeventmanager.events;

import ezeventmanager.user.User;
import java.sql.Timestamp;

/**
 *
 * @author t.pradeepkumar
 */
public class Birthday extends EventsImpl {

    public Birthday()  {
        super();
        Type = EventType.BIRTHDAY; 
    }
    
    public Birthday(long id, Timestamp start, Timestamp end, User org, 
            EventType evtype, Status stat)  {
        super(id,start,end,org,evtype,stat);
        Type = EventType.BIRTHDAY;
    }

    
}
