package com.example.articlemanagementsystem.Controller;

import com.example.articlemanagementsystem.ApiResponse.ApiResponse;
import com.example.articlemanagementsystem.Model.ModelManagementSystem;
import com.example.articlemanagementsystem.Service.ServiceManagementSystem;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/ManagementSystem")
@RequiredArgsConstructor

//فايدة هذا الكلاس استجابه لservic
public class ControllerManagementSystem {

    // جسر يربطني مع  servic عشان استفيد من اللوجك اللي كتبته
    private final ServiceManagementSystem servic;


   @GetMapping("/get")
    public ResponseEntity get(){

        ArrayList<ModelManagementSystem> object=servic.getArrayServic();
       return ResponseEntity.status(200).body(object);
    }


   @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid ModelManagementSystem model , Errors errors){

       if(errors.hasErrors()){
           String message=errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(message);
       }
       servic.addArrayServic(model);

       return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateArticles(@PathVariable String id, @Valid @RequestBody ModelManagementSystem model, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdated = servic.upddateArrayServic(id, model);
        if (isUpdated){
            return ResponseEntity.status(200).body("Updated");
        }else {
            return  ResponseEntity.status(400).body("Id not Found");
        }


    }



    @DeleteMapping("/Delete/{id}")
    public  ResponseEntity deleteArticles(@PathVariable String id){

        boolean isDeleted = servic.deleteArrayServic(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("Delete");
        }else {
            return ResponseEntity.status(400).body("Sorry not Found");
        }
    }

    @PutMapping("/publish/{id}")
    public ResponseEntity publishNewsArticle(@PathVariable String id) {
        boolean isPublished = servic.publishNewsArticle(id);
        if (isPublished) {
            return ResponseEntity.status(200).body("Article published successfully!");
        } else {
            return ResponseEntity.status(400).body("Article with the given ID not found.");
        }
    }

    @GetMapping("/published")
    public ResponseEntity getAllPublishedArticles() {
        ArrayList<ModelManagementSystem> publishedArticles = servic.getPublishedArticles();
        return ResponseEntity.status(200).body(publishedArticles);
    }


    @GetMapping("/category/{category}")
    public ResponseEntity getArticlesByCategory(@PathVariable String category) {
        ArrayList<ModelManagementSystem> articlesByCategory = servic.getArticlesByCategory(category);
        return ResponseEntity.status(200).body(articlesByCategory);
    }


}
