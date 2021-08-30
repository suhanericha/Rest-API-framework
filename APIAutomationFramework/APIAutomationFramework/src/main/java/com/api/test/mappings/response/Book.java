package com.api.test.mappings.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter

public class Book {

    private String isbn;
    private String title;
    private String subTitle;
    private String author;
    private Date publish_date;
    private String publisher;
    private int pages;
    private String description;
    private String website;
}
