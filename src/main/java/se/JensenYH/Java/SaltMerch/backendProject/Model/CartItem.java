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


    //prefere to use getters and setters
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //</editor-fold>
}

