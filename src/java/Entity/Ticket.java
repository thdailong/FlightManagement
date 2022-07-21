/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Ticket {
    private int ID;
    private String IDFlight;
    private String FirstName;
    private String LastName;
    private String CCCD;
    private int IDListTicket;
    private String DOB;

    public Ticket(int ID, String IDFlight, String FirstName, String LastName, String CCCD, int IDListTicket, String DOB) {
        this.ID = ID;
        this.IDFlight = IDFlight;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.CCCD = CCCD;
        this.IDListTicket = IDListTicket;
        this.DOB = DOB;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setIDFlight(String IDFlight) {
        this.IDFlight = IDFlight;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public void setIDListTicket(int IDListTicket) {
        this.IDListTicket = IDListTicket;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getIDFlight() {
        return IDFlight;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getCCCD() {
        return CCCD;
    }

    public int getIDListTicket() {
        return IDListTicket;
    }

    public String getDOB() {
        return DOB;
    }
    
    public String getDay() {
        try {
            Date date =new SimpleDateFormat("yyyy-MM-dd").parse(this.DOB);  
            int x = date.getDate();
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
            Date date =new SimpleDateFormat("yyyy-MM-dd").parse(this.DOB);  
            int x = date.getMonth() + 1;
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
            Date date =new SimpleDateFormat("yyyy-MM-dd").parse(this.DOB);  
            int x = date.getYear() + 1900;
            String res = "";
            res+=x;
            return res;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }
    
    
}
