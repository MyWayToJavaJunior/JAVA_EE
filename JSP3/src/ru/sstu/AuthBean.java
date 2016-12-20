package ru.sstu;

import java.io.Serializable;

/**
 * Created by Shvarts on 14.12.16.
 */
public class AuthBean implements Serializable {

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if(login != null)
            if(!login.isEmpty())
            {
                this.login = login;
                authorized = true;
            }

    }

    private String login;

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    private boolean authorized = false;
}
