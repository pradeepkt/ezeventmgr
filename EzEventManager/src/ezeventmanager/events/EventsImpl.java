/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeventmanager.events;

import ezeventmanager.user.User;
import java.time.LocalDateTime;

/**
 *
 * @author t.pradeepkumar
 */
public abstract class EventsImpl implements Events {
    
    /**
     * Organizer
     */
    protected User organizer ;
    
    @Override
    public void scheduleEvent(LocalDateTime timeStart)
    {
        // Temp function to be filled later

    }
}
