/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeventmanager.events;

import ezeventmanager.user.User;
import ezeventmanager.utils.DBConnectionManager;
import java.sql.Timestamp;

/**
 *
 * @author t.pradeepkumar
 */
public abstract class EventsImpl implements Events {

    /**
     * Event Id
     */
    protected long _eventId;

    /**
     * Get the event Id
     *
     * @return
     */
    public long getEventId() {
        return _eventId;
    }

    /**
     * Set the event Id
     *
     * @param id
     */
    public void setEventId(long id) {
        _eventId = id;
    }

    /**
     * Organizer
     */
    protected User Organizer;

    /**
     * Returns the organizer
     *
     * @return
     */
    public User getOrganizer() {
        return Organizer;
    }

    /**
     * Sets organizer
     *
     * @param org
     */
    public void setOrganizer(User org) {
        Organizer = org;
    }

    /**
     * Type of the event
     */
    protected EventType Type;

    /**
     * Get type
     *
     * @return
     */
    public EventType getType() {
        return Type;
    }

    /**
     * Set Type
     *
     * @param type
     */
    public void setType(EventType type) {
        Type = type;
    }

    /**
     * Start time
     */
    protected Timestamp StartTime;

    /**
     * Get Start time
     *
     * @return
     */
    public Timestamp getStartTime() {
        return StartTime;
    }

    /**
     * Set Start time
     *
     * @param start
     */
    public void setStartTime(Timestamp start) {
        StartTime = start;
    }

    /**
     * End Time
     */
    protected Timestamp EndTime;

    /**
     * Status
     */
    protected Status CurrentStatus;

    /**
     * Get status
     *
     * @return
     */
    public Status getStatus() {
        return CurrentStatus;
    }

    /**
     * Set status
     *
     * @param stat
     */
    public void setStatus(Status stat) {
        CurrentStatus = stat;
    }

    public EventsImpl() {

    }

    public EventsImpl(long id, Timestamp start, Timestamp end, User org,
            EventType evtype, Status stat) {
        _eventId = id;
        StartTime = start;
        EndTime = end;
        Organizer = org;
        Type = evtype;
        CurrentStatus = stat;
    }

    /**
     * Schedule this event
     *
     * @param timeStart
     * @param timeEnd
     */
    public void scheduleEvent(Timestamp timeStart, Timestamp timeEnd) {
        // Temp function to be filled later
        StartTime = timeStart;
        EndTime = timeEnd;
    }

    /**
     * Persist the same
     *
     * @return
     */
    @Override
    public long persist() {
     
        String insertQuery = "INSERT INTO `ezevents`.`event`"
                + "(`idEvent`,`organizer`,`StartSchedule`,`EndSchedule`,`Status`,`EventType`) "
                + "VALUES (" + _eventId + "," + Organizer.getUserId() + ",'" + StartTime + "','"
                + EndTime + "', '" + CurrentStatus + "','" + getTypeStr(Type) + "')"
                + " on duplicate key update "
                + "idEvent=" + _eventId + ","
                + "organizer=" + Organizer.getUserId() + ","
                + "StartSchedule='" + StartTime + "',"
                + "EndSchedule='" + EndTime + "',"
                + "Status='" + CurrentStatus + "',"
                + "EventType='" + getTypeStr(Type) + "'";
        System.out.println("Insert query is " + insertQuery);
        return DBConnectionManager.persist(insertQuery);
    }

    /**
     * Get value
     *
     * @param type
     * @return
     */
    @Override
    public String getTypeStr(EventType type) {
        if (null != type) {
            switch (type) {
                case BIRTHDAY:
                    return "BIRTHDAY";
                case CORPORATE:
                    return "CORPORATE";
                case CORPORATE_TEAMOUTING:
                    return "COPORATE_TEAMOUTING";
                case INVALID:
                    return "INVALID";
            }
        }
        return "INVALID";
    }

    /**
     * Return the type from string
     *
     * @param typestr
     * @return
     */
    public EventType getTypeFromStr(String typestr) {
        if (null != typestr) {
            switch (typestr) {
                case "BIRTHDAY":
                    return EventType.BIRTHDAY;
                case "CORPORATE":
                    return EventType.CORPORATE;
                case "CORPORATE_TEAMOUTING":
                    return EventType.CORPORATE_TEAMOUTING;
                default:
                    return EventType.INVALID;
            }
        }
        return EventType.INVALID;
    }

    /**
     *
     * @param stat
     * @return
     */
    public String getStatusStr(Status stat) {
        if (null != stat) {
            switch (stat) {
                case DONE:
                    return "DONE";
                case INPROGRESS:
                    return "INPROGRESS";
                case PAID:
                    return "PAID";
                case STARTED:
                    return "STARTED";
                default:
                    return "INVALID";
            }
        }
        return "INVALID";
    }

    /**
     *
     * @param statstr
     * @return
     */
    public Status getStatus(String statstr) {
        if (null != statstr) {
            switch (statstr) {
                case "DONE":
                    return Status.DONE;
                case "INPROGRESS":
                    return Status.INPROGRESS;
                case "PAID":
                    return Status.PAID;
                case "STARTED":
                    return Status.STARTED;
                default:
                    return Status.INVALID;
            }
        }
        return Status.INVALID;
    }
}
