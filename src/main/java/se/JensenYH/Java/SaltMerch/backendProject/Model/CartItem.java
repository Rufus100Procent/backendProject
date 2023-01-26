package se.JensenYH.Java.SaltMerch.backendProject.Model;
public class CartItem {

    private int productId;

    private String title;

    private String color;

    private String size;

    private String previewImage;

    private int quantity;


    public CartItem() {
    }
    public CartItem(int productId, String title, String color, String size, String previewImage) {
        this.productId = productId;
        this.title = title;
        this.color = color;
        this.size = size;
        this.previewImage = previewImage;
    }
    public CartItem(int productId, String title, String color, String size, String previewImage, int quantity) {
        this.productId = productId;
        this.title = title;
        this.color = color;
        this.size = size;
        this.previewImage = previewImage;
        this.quantity = quantity;
    }


    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public int getProductId() {
        return productId;
    }

    public String getTitle() {
        return title;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public int getQuantity() {
        return quantity;
    }

    //</editor-fold>
}

