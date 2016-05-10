/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeventmanager.events;

import java.time.LocalDateTime;

/**
 *
 * @author t.pradeepkumar
 */
public interface Events {
    
    /**
     * Allows scheduling an event
     * @param timeStart Start the time
     */
    void scheduleEvent(LocalDateTime timeStart);
    
}
