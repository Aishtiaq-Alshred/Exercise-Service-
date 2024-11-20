package com.example.articlemanagementsystem.Service;

import com.example.articlemanagementsystem.Model.ModelManagementSystem;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class ServiceManagementSystem {

    //نفس اللي كنت اسويه سابقا في controller لكن مع اختلاف بسيط كله لوجك

    ArrayList<ModelManagementSystem> arrayServic=new ArrayList<>();

    public ArrayList<ModelManagementSystem> getArrayServic(){
        return arrayServic;
    }

    public void addArrayServic(ModelManagementSystem model){
        arrayServic.add(model);

    }



    public boolean upddateArrayServic(String id,ModelManagementSystem model){
        for (int i = 0; i <arrayServic.size() ; i++) {
            if (arrayServic.get(i).getId().equals(id)){
                arrayServic.set(i,model);
                return true;
            }
        }
        return  false;
    }


    public boolean deleteArrayServic(String id){
        for (int i = 0; i <arrayServic.size() ; i++) {
            if (arrayServic.get(i).getId().equals(id)){
                arrayServic.remove(i);
                return  true;
            }
        }
        return  false;
    }


    public boolean publishNewsArticle(String id) {
        for (ModelManagementSystem article : arrayServic) {
            if (article.getId().equals(id) && !article.isPublished()) {
                article.setPublished(true);
                article.setPublishDate(LocalDate.now());
                return true;
            }
        }
        return false;
    }

    public ArrayList<ModelManagementSystem> getPublishedArticles() {
        ArrayList<ModelManagementSystem> publishedArticles = new ArrayList<>();
        for (ModelManagementSystem article : arrayServic) {
            if (article.isPublished()) {
                publishedArticles.add(article);
            }
        }
        return publishedArticles;
    }

    public ArrayList<ModelManagementSystem> getArticlesByCategory(String category) {
        ArrayList<ModelManagementSystem> filteredArticles = new ArrayList<>();
        for (ModelManagementSystem article : arrayServic) {
            if (article.getCategory().equalsIgnoreCase(category)) {
                filteredArticles.add(article);
            }
        }
        return filteredArticles;
    }




}
