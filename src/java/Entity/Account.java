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
public class Account {
    private int ID;
    private String username;
    private String password;
    private String FirstName;
    private String LastName;
    private int role;

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

 

    public Account() {
    }

    public Account(int ID, String username, String password, String FirstName, String LastName,int role) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.role = role;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    @Override
    public String toString() {
        return "Account{" + "ID=" + ID + ", username=" + username + ", password=" + password + ", FirstName=" + FirstName + ", LastName=" + LastName + '}';
    }
    
}
