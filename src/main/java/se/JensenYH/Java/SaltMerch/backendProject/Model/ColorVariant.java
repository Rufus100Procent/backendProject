package se.JensenYH.Java.SaltMerch.backendProject.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class ColorVariant {

    @JsonProperty
    public String colorName;
    @JsonProperty
    public List<String> images;
    @JsonProperty
    public  List<SizeContainer> size;

    public ColorVariant() {
        images = new ArrayList<>();

    }

    public ColorVariant(String colorName, List<String> images, List<SizeContainer> size) {
        this.colorName = colorName;
        this.images = images;
        this.size = size;
    }
// todo: needs fields: String colorName, List of String images, List of SizeContainer sizes

    // todo: all fields should be public and annotated with @JsonProperty

    // todo: needs 2 constructors:
    //  1. empty constructor: this one needs to initialize images and sizes as new ArrayList<>()
    //  2. constructor with colorName, sizes, and images



    // NOTE: you can leave this method as it is; it's used in ProductRepository.java
    public void setImagesFromCSV(String csv) throws Exception
    {
        images = new ArrayList<>(Arrays.asList(csv.split(",")));
    }
}

