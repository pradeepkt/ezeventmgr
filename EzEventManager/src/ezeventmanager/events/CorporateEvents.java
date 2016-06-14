/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeventmanager.events;

import ezeventmanager.user.User;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author t.pradeepkumar
 */
public class CorporateEvents extends EventsImpl{

    public CorporateEvents()  {
        super();
        Type = EventType.CORPORATE; 
    }
    
    public CorporateEvents(long id, Timestamp start, Timestamp end, User org, 
            EventType evtype, Status stat)  {
        super(id,start,end,org,evtype,stat);
        Type = EventType.CORPORATE;
    }
    
}
