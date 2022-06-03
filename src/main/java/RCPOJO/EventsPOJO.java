/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RCPOJO;

/**
 *
 * @author sanda
 */
public class EventsPOJO {
    private String event;
    private String organiser;
    private String venue;
    private String contact;
    private String from;
    private String till;
    private String stime;
    private String etime;
    private String planner;
    private int eventid;

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public EventsPOJO(String event, String organiser, String venue, String contact, String from, String till, String stime, String etime, String planner, int eventid) {
        this.event = event;
        this.organiser = organiser;
        this.venue = venue;
        this.contact = contact;
        this.from = from;
        this.till = till;
        this.stime = stime;
        this.etime = etime;
        this.planner = planner;
        this.eventid = eventid;
    }

    public EventsPOJO(String event, String organiser, String venue, String contact, String from, String till, String stime, String etime, String planner) {
        this.event = event;
        this.organiser = organiser;
        this.venue = venue;
        this.contact = contact;
        this.from = from;
        this.till = till;
        this.stime = stime;
        this.etime = etime;
        this.planner = planner;
    }

    public EventsPOJO(String event, String organiser, String venue, String contact, String from, String till, String stime, String etime) {
        this.event = event;
        this.organiser = organiser;
        this.venue = venue;
        this.contact = contact;
        this.from = from;
        this.till = till;
        this.stime = stime;
        this.etime = etime;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getOrganiser() {
        return organiser;
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTill() {
        return till;
    }

    public void setTill(String till) {
        this.till = till;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getPlanner() {
        return planner;
    }

    public void setPlanner(String planner) {
        this.planner = planner;
    }
    
    
    
    
    
}
