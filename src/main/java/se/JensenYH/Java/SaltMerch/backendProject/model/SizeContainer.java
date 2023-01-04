package se.JensenYH.Java.SaltMerch.backendProject.model;

public class SizeContainer {

    //prefare to use getters and setters rather than @JsonProperty

    // todo: needs fields: String size, int stock
    private String size;
    private int stock;
    
    // todo: all fields should be public and annotated with @JsonProperty
    
    // todo: needs 2 constructors:
    //  1. empty constructor

    public SizeContainer() {
    }

    //  2. constructor with size and stock

    public SizeContainer(String size, int stock) {
        this.size = size;
        this.stock = stock;
    }


    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    //</editor-fold>
}
