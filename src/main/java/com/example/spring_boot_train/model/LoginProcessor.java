package com.example.spring_boot_train.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

//@Component
//@RequestScope
public class LoginProcessor {
    private String login;
    private String password;

    public LoginProcessor(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public LoginProcessor() {
    }

    public boolean login() {
        return "danko99".equals(login) && "daneel99".equals(password);
    }

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
}
