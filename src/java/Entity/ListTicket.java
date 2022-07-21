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
public class ListTicket {
    private int ID; 
    private String firstname;
    private String lastname;
    private int IDUser;
    private String days;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public ListTicket(String firstname, String lastname, String days) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.days = days;
    }

    

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public int getID() {
        return ID;
    }

    public int getIDUser() {
        return IDUser;
    }

    public String getDays() {
        return days;
    }

    public ListTicket(int ID, int IDUser, String days) {
        this.ID = ID;
        this.IDUser = IDUser;
        this.days = days;
    }
    
    
}
