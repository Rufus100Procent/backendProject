package se.JensenYH.Java.SaltMerch.backendProject.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EntityScan
public class Product implements Serializable {
    //prefare to use getters and setters rather than @JsonProperty

    // todo: needs fields: int id, String category, String title, String description, String previewImage, and List of ColorVariant colorVariants
    private List<ColorVariant> colorVariantList;
    @Id
    private int id;
    private String category;
    private String title;
    private String description;
    private String previewImage;

    // todo: all fields should be public and annotated with @JsonProperty
    
    // todo: needs 3 constructors:
    //  1. empty constructor: this one only initializes colorVariants to new ArrayList<>()

    public Product() {
        colorVariantList = new ArrayList<>();
    }

    //  2. constructor with id, category, title, description, and previewImage: this one initializes colorVariants to new ArrayList<>()

    public Product(int id, String category, String title, String description, String previewImage) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.description = description;
        this.previewImage = previewImage;

        colorVariantList = new ArrayList<>();
    }

    //  3. constructor with id, category, title, description, colorVariants


    public Product(List<ColorVariant> colorVariantList, int id, String category, String title, String description) {
        this.colorVariantList = colorVariantList;
        this.id = id;
        this.category = category;
        this.title = title;
        this.description = description;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public List<ColorVariant> getColorVariantList() {
        return colorVariantList;
    }

    public void setColorVariantList(List<ColorVariant> colorVariantList) {
        this.colorVariantList = colorVariantList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }
    //</editor-fold>

}
