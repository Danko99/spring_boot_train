package com.example.spring_boot_train.controller;

import com.example.spring_boot_train.model.Book;
import com.example.spring_boot_train.model.LoginProcessor;
import com.example.spring_boot_train.model.LoginSession;
import com.example.spring_boot_train.model.Shelve;
import com.example.spring_boot_train.service.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MyController {

    private final LoginSession loginSession;
    //    private final LoginProcessor loginProcessor;
    private final Shelve shelve;
    private final LoginCountService loginCountService;

    public MyController(LoginSession loginSession, Shelve shelve, LoginCountService loginCountService) {
        this.loginSession = loginSession;
        this.shelve = shelve;
        this.loginCountService = loginCountService;
    }

    //@GetMapping("/first")
    @RequestMapping("/first")
    public String firstEndpoint() {
        return "index.html";
    }


    @GetMapping("/books")
    public List<Book> getData() {
        System.out.println(loginSession.getName());
        return shelve.getBookList();
    }

    @GetMapping("/counter")
    public Integer getCount() {
        return loginCountService.getCounter();
    }


    @PostMapping("/book")
    public String addBook(@RequestBody Book book) {
        shelve.addToShelve(book);
        return "OK";
    }

    @GetMapping("/login")
    @ResponseBody
    public LoginProcessor login(@RequestParam String login, @RequestParam String password) {


//        boolean result = loginProcessor.login();
//        if(result){
//            loginSession.setName(String.valueOf(hashCode()));
//        }
//        System.out.println(loginSession.getName());
//
//        loginCountService.count();

        LoginProcessor loginProcessor = new LoginProcessor();
        loginProcessor.setLogin(login);
        loginProcessor.setPassword(password);
        return loginProcessor;
    }


    @RequestMapping("/home/{color}")
    public void pathVariable(@PathVariable String color) {
        System.out.println(color);
    }
}
