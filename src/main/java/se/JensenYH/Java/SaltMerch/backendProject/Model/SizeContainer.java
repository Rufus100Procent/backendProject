package se.JensenYH.Java.SaltMerch.backendProject.Model;

public class SizeContainer {
    private final String size;
    private final int stock;

    public SizeContainer(String size, int stock) {
        this.size = size;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "SizeContainer{" +
                "size='" + size + '\'' +
                ", stock=" + stock +
                '}';
    }
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public String getSize() {
        return size;
    }

    public int getStock() {
        return stock;
    }

    //</editor-fold>
}