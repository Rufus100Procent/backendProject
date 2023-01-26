package se.JensenYH.Java.SaltMerch.backendProject.Model;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class ProductTest {


    private Product actualProduct;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testConstructor() {
        actualProduct = new Product();
        actualProduct.setCategory("Category");
        ArrayList<ColorVariant> colorVariantList = new ArrayList<>();
        actualProduct.setColorVariants(colorVariantList);
        actualProduct.setDescription("The characteristics of someone or something");
        actualProduct.setId(1);
        actualProduct.setPreviewImage("Preview Image");
        actualProduct.setTitle("Dr");
        assertEquals("Category", actualProduct.getCategory());
        assertSame(colorVariantList, actualProduct.getColorVariants());
        assertEquals("The characteristics of someone or something", actualProduct.getDescription());
        assertEquals(1, actualProduct.getId());
        assertEquals("Preview Image", actualProduct.getPreviewImage());
        assertEquals("Dr", actualProduct.getTitle());
    }

    @Test
    void testConstructor2() {
        actualProduct = new Product(1, "Category", "Dr", "The characteristics of someone or something",
                "Preview Image");
        actualProduct.setCategory("Category");
        ArrayList<ColorVariant> colorVariantList = new ArrayList<>();
        actualProduct.setColorVariants(colorVariantList);
        actualProduct.setDescription("The characteristics of someone or something");
        actualProduct.setId(1);
        actualProduct.setPreviewImage("Preview Image");
        actualProduct.setTitle("Dr");
        assertEquals("Category", actualProduct.getCategory());
        assertSame(colorVariantList, actualProduct.getColorVariants());
        assertEquals("The characteristics of someone or something", actualProduct.getDescription());
        assertEquals(1, actualProduct.getId());
        assertEquals("Preview Image", actualProduct.getPreviewImage());
        assertEquals("Dr", actualProduct.getTitle());
    }

    @Test
    void testConstructor3() {
        ArrayList<ColorVariant> colorVariantList = new ArrayList<>();
        Product actualProduct = new Product(1, "Category", "Dr", "The characteristics of someone or something",
                colorVariantList);
        actualProduct.setCategory("Category");
        ArrayList<ColorVariant> colorVariantList1 = new ArrayList<>();
        actualProduct.setColorVariants(colorVariantList1);
        actualProduct.setDescription("The characteristics of someone or something");
        actualProduct.setId(1);
        actualProduct.setPreviewImage("Preview Image");
        actualProduct.setTitle("Dr");
        assertEquals("Category", actualProduct.getCategory());
        List<ColorVariant> colorVariants = actualProduct.getColorVariants();
        assertSame(colorVariantList1, colorVariants);
        assertEquals(colorVariantList, colorVariants);
        assertEquals("The characteristics of someone or something", actualProduct.getDescription());
        assertEquals(1, actualProduct.getId());
        assertEquals("Preview Image", actualProduct.getPreviewImage());
        assertEquals("Dr", actualProduct.getTitle());
    }
}