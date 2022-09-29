package com.example.spring_boot_train.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Shelve {
    private List<Book> bookList;

    public Shelve() {
       this.bookList = new ArrayList<>();
    }

    public void addToShelve(Book book){
        bookList.add(book);
    }

    public List<Book> getBookList(){
        return bookList;
    }
}
