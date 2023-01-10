package se.JensenYH.Java.SaltMerch.backendProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class ColorVariant {
    //prefare to use getters and setters rather than @JsonProperty


    // todo: needs fields: String colorName, List of String images, List of SizeContainer sizes
    @JsonProperty
    public String colorName;
    @JsonProperty
    public List<String> images;
    @JsonProperty
    public List<SizeContainer> sizes;
    // todo: all fields should be public and annotated with @JsonProperty
    
    // todo: needs 2 constructors:
    //  1. empty constructor: this one needs to initialize images and sizes as new ArrayList<>()

    public ColorVariant() {
        sizes = new ArrayList<>();
        images = new ArrayList<>();
    }

    //  2. constructor with colorName, sizes, and images
    public ColorVariant(String colorName, List<String> images, List<SizeContainer> sizes) {
        this.colorName = colorName;
        this.images = images;
        this.sizes = sizes;
    }

    // NOTE: you can leave this method as it is; it's used in ProductRepository.java
    public void setImagesFromCSV(String csv) throws Exception
    {
        images = new ArrayList<>(Arrays.asList(csv.split(",")));
    }

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<SizeContainer> getSizes() {
        return sizes;
    }

    public void setSizes(List<SizeContainer> sizes) {
        this.sizes = sizes;
    }

    //</editor-fold>
}
