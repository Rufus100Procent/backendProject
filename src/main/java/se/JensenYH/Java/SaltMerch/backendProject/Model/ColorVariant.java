package se.JensenYH.Java.SaltMerch.backendProject.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ColorVariant {
    private String colorName;
    private List<String> images;
    private  List<SizeContainer> sizes;

    public ColorVariant() {
        images = new ArrayList<>();

    }

    public ColorVariant(String colorName, List<String> images, List<SizeContainer> sizes) {
        this.colorName = colorName;
        this.images = images;
        this.sizes = sizes;
    }

    public void setImagesFromCSV(String csv) throws Exception {
        images = new ArrayList<>(Arrays.asList(csv.split(",")));
    }

    //prefere to use getters and setters
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

