/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeventmanager.events;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author t.pradeepkumar
 */
public interface Events {
    
    /**
     * User roles
     */
    public enum EventType {
        BIRTHDAY,
        CORPORATE,
        CORPORATE_TEAMOUTING,
        INVALID
    }

    /**
     * Get Type string
     * @param type
     * @return 
     */
    public String getTypeStr(EventType type);
    
    /**
     * Get Type from string
     * @param typestr
     * @return 
     */
    public EventType getTypeFromStr(String typestr);
    
    public enum Status  {
        STARTED,
        PAID,
        INPROGRESS,
        DONE,
        INVALID
    }
    
    /**
     * Get string from status
     * @param stat
     * @return 
     */
    public String getStatusStr(Status stat);
    
    /**
     * Get Status from string
     * @param statstr
     * @return 
     */
    public Status getStatus(String statstr);
    
    /**
     * Allows scheduling an event
     * @param timeStart Start the time
     */
    public void scheduleEvent(Timestamp timeStart, Timestamp timeEnd);
    
    /**
     * Persist this.
     * @return 
     */
    public long persist();
    
    
}
