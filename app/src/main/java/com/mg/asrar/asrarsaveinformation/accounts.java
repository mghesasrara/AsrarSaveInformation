package com.mg.asrar.asrarsaveinformation;

/**
 * Created by user on 10/26/2016.
 */
public class accounts {
    private String email;
    private String password;


    public accounts(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public accounts() {
    }

    @Override
    public String toString() {
        return "accounts{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
