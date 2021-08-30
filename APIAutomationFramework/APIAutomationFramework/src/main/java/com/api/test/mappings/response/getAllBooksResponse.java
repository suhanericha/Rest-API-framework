package com.api.test.mappings.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter


public class getAllBooksResponse {

    private List<Book> books;

}
