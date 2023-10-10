package com.kuanghui.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    int Id;
    String bookName;
    int bookCounts;
    String detail;
}
