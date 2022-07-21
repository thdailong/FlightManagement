/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author thdai
 */
public class Schedule {
    private int ID;
    private String FromAirport;
    private String ToAirport;
    private String TimeFrom;
    private String TimeTo;

    public Schedule(int ID, String FromAirport, String ToAirport, String TimeFrom, String TimeTo) {
        this.ID = ID;
        this.FromAirport = FromAirport;
        this.ToAirport = ToAirport;
        this.TimeFrom = TimeFrom;
        this.TimeTo = TimeTo;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFromAirport(String FromAirport) {
        this.FromAirport = FromAirport;
    }

    public void setToAirport(String ToAirport) {
        this.ToAirport = ToAirport;
    }

    public void setTimeFrom(String TimeFrom) {
        this.TimeFrom = TimeFrom;
    }

    public void setTimeTo(String TimeTo) {
        this.TimeTo = TimeTo;
    }

    public int getID() {
        return ID;
    }

    public String getFromAirport() {
        return FromAirport;
    }

    public String getToAirport() {
        return ToAirport;
    }

    public String getTimeFrom() {
        return TimeFrom;
    }

    public String getTimeTo() {
        return TimeTo;
    }
    
}
