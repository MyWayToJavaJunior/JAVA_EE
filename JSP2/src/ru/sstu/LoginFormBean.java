package ru.sstu;

import java.io.Serializable;

/**
 * Created by Shvarts on 12.12.16.
 */
public class LoginFormBean implements Serializable{

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //FIXME encoding
}
