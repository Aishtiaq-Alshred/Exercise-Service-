package com.example.articlemanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.time.LocalDate;


@AllArgsConstructor
@Data
public class ModelManagementSystem {

    @NotEmpty(message = "your id is Empty!")
    private String id;

    @NotEmpty(message = "your title is Empty!")
    @Size(max = 100,message = "Maximum length of 100 characters!")
    private String title;

    @NotEmpty(message = "your author is Empty!")
    @Size(min=5,max = 20,message = "Must be more than 4 characters and Maximum 20 characters! ")
   private String author;

    @NotEmpty(message = "your content is Empty!")
    @Pattern(regexp = "politics|sports|technology")
    private String content;

    @NotEmpty(message = "your image Url is Empty!")
    private String imageUrl;


    private boolean isPublished=false;

   @JsonFormat(pattern ="dd-MM-yyyy" )
    private LocalDate publishDate;

   private String category;
}


