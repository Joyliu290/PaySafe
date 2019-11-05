package project.qhacks.com.qhacksfirebaseauth;

import java.util.ArrayList;
import java.util.List;

public class UserAttributes {
    String userID;
    String password;
    List<String> payee;
    String balance;

    public UserAttributes(){

    }

    public UserAttributes(String userID, String password, List<String> payee, String balance) {
        this.userID = userID;
        this.password = password;
        this.payee = payee;
        this.balance = balance;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getPayee() {
        return payee;
    }

    public void setPayee(ArrayList<String> payee) {
        this.payee = payee;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
