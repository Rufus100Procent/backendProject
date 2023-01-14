package se.JensenYH.Java.SaltMerch.backendProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {

    @JsonProperty
    public int id;
    @JsonProperty
    public String catagory;
    @JsonProperty
    public String title;
    @JsonProperty
    public String description;
    @JsonProperty
    public String previewImage;
    @JsonProperty
    public List<ColorVariant> colorVariants;

    public Product() {
        colorVariants = new ArrayList<>();
    }

    public Product(int id, String catagory, String title, String description, String previewImage) {
        this.id = id;
        this.catagory = catagory;
        this.title = title;
        this.description = description;
        this.previewImage = previewImage;
        colorVariants = new ArrayList<>();
    }

    public Product(int id, String catagory, String title, String description, List<ColorVariant> colorVariants) {
        this.id = id;
        this.catagory = catagory;
        this.title = title;
        this.description = description;
        this.colorVariants = colorVariants;
    }
// todo: needs fields: int id, String category, String title, String description, String previewImage, and List of ColorVariant colorVariants

    // todo: all fields should be public and annotated with @JsonProperty

    // todo: needs 3 constructors:
    //  1. empty constructor: this one only initializes colorVariants to new ArrayList<>()
    //  2. constructor with id, category, title, description, and previewImage: this one initializes colorVariants to new ArrayList<>()
    //  3. constructor with id, category, title, description, colorVariants
}

