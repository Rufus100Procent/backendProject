package se.JensenYH.Java.SaltMerch.backendProject.Model;

public class VariantWImages {
    private final int id;
    private final String colorName;
    private final String imagesCsv;

    public VariantWImages(int id, String colorName, String imagesCsv) {
        this.id = id;
        this.colorName = colorName;
        this.imagesCsv = imagesCsv;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public int getId() {
        return id;
    }
    public String getColorName() {
        return colorName;
    }

    public String getImagesCsv() {
        return imagesCsv;
    }
    //</editor-fold>


}
