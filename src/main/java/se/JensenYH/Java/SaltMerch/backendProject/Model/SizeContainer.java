package se.JensenYH.Java.SaltMerch.backendProject.Model;

public class SizeContainer {
    private String size;
    private int stock;

    public SizeContainer() {
    }

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
