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

    private String firstname;
    private String lastname;
    private int IDUser;
    private String days;

    public ListTicket(int IDUser,String firstname, String lastname,  String days) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.IDUser = IDUser;
        this.days = days;
    }

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

    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "ListTicket{" + "firstname=" + firstname + ", lastname=" + lastname + ", IDUser=" + IDUser + ", days=" + days + '}';
    }

}
