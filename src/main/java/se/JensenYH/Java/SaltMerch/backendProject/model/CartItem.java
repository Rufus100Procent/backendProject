package se.JensenYH.Java.SaltMerch.backendProject.model;

import org.hibernate.annotations.Comment;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@Comment("")
public class CartItem {

    //prefare to use getters and setters rather than @JsonProperty
    // todo: needs fields: int productId, String title, String color, String size, String previewImage, and int quantity

    private int quantity;
    @Id
    private int productId;
    private String title;
    private String color;
    private String size;
    private  String previewImage;


    // todo: all fields should be public and annotated with @JsonProperty
    
    // todo: needs 3 constructors:
    //  1. empty constructor

    public CartItem() {
    }

    //  2. constructor with productId, title, color, size, and previewImage

    public CartItem(int productId, String title, String color, String size, String previewImage) {
        this.productId = productId;
        this.title = title;
        this.color = color;
        this.size = size;
        this.previewImage = previewImage;
    }

    //  3. constructor with productId, title, color, size, previewImage, and quantity

    public CartItem(int quantity, int productId, String title, String color, String size, String previewImage) {
        this.quantity = quantity;
        this.productId = productId;
        this.title = title;
        this.color = color;
        this.size = size;
        this.previewImage = previewImage;
    }



    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

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
    //</editor-fold>
}
