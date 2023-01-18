package se.JensenYH.Java.SaltMerch.backendProject.Model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class SizeContainer {
    @JsonProperty
    public String size;
    @JsonProperty
    public int stock;

    public SizeContainer() {
    }

    public SizeContainer(String size, int stock) {
        this.size = size;
        this.stock = stock;
    }


// todo: needs fields: String size, int stock

    // todo: all fields should be public and annotated with @JsonProperty

    // todo: needs 2 constructors:
    //  1. empty constructor
    //  2. constructor with size and stock
}
