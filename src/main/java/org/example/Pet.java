package org.example;

import java.util.List;

public class Pet {


    public Pet(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public Pet(int id, String name, Category category, List<String> photoUrls, List<Tags> tags, String status) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Pet() {
    }


    private int id;

    private String name;

    private Category category;

    private List<String> photoUrls;

    private List<Tags> tags;

    private String status;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setCategory(Category category){
        this.category = category;
    }
    public Category getCategory(){
        return this.category;
    }
    public void setPhotoUrls(List<String> photoUrls){
        this.photoUrls = photoUrls;
    }
    public List<String> getPhotoUrls(){
        return this.photoUrls;
    }
    public void setTags(List<Tags> tags){
        this.tags = tags;
    }
    public List<Tags> getTags(){
        return this.tags;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category.toString() +
                ", photoUrls=" + photoUrls.toString() +
                ", tags=" + tags.toString() +
                ", status='" + status.toString() + '\'' +
                '}';
    }
}
