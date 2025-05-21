package com.example.projectv.AdaptersandModela;

public class CategoryModel {
    String category_id;
    String name;
    String image;
    String Issubcategories;
    String subcategoriesArray;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIssubcategories() {
        return Issubcategories;
    }

    public void setIssubcategories(String issubcategories) {
        Issubcategories = issubcategories;
    }

    public String getSubcategoriesArray() {
        return subcategoriesArray;
    }

    public void setSubcategoriesArray(String subcategoriesArray) {
        this.subcategoriesArray = subcategoriesArray;
    }
}
