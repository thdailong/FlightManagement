/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Flight {
    private String ID_Days;
    private int IDSchedule;
    private int SeatRemaining;
    private String date;

    public Flight(String ID_Days, int IDSchedule, int SeatRemaining, String date) {
        this.ID_Days = ID_Days;
        this.IDSchedule = IDSchedule;
        this.SeatRemaining = SeatRemaining;
        this.date = date;
    }

    public String getID_Days() {
        return ID_Days;
    }

    public int getIDSchedule() {
        return IDSchedule;
    }

    public int getSeatRemaining() {
        return SeatRemaining;
    }

    public String getDate() {
        return date;
    }

    public void setID_Days(String ID_Days) {
        this.ID_Days = ID_Days;
    }

    public void setIDSchedule(int IDSchedule) {
        this.IDSchedule = IDSchedule;
    }

    public void setSeatRemaining(int SeatRemaining) {
        this.SeatRemaining = SeatRemaining;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    public String getDay() {
        try {
            Date dateTmp =new SimpleDateFormat("yyyy-MM-dd").parse(this.date);  
            int x = dateTmp.getDate();
            String res = "";
            if (x < 10) res = "0";
            res+=x;
            return res;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }
    
    public String getMonth() {
        try {
            Date dateTmp =new SimpleDateFormat("yyyy-MM-dd").parse(this.date);  
            int x = dateTmp.getMonth() + 1;
            String res = "";
            if (x < 10) res = "0";
            res+=x;
            return res;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }
    
    public String getYear() {
        try {
            Date dateTmp =new SimpleDateFormat("yyyy-MM-dd").parse(this.date);  
            int x = dateTmp.getYear() + 1900;
            String res = "";
            if (x < 10) res = "0";
            res+=x;
            return res;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }
}
