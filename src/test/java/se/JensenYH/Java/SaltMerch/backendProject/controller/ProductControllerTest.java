package se.JensenYH.Java.SaltMerch.backendProject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import se.JensenYH.Java.SaltMerch.backendProject.Model.ColorVariant;
import se.JensenYH.Java.SaltMerch.backendProject.Model.Product;
import se.JensenYH.Java.SaltMerch.backendProject.service.ProductService;

class ProductControllerTest {

    @Autowired
    ProductService productService;

    @Autowired
    ProductController productController;

    ArrayList<Product> productList;

    @BeforeEach
    void satup(){
        productService = mock(ProductService.class);
    }
    //working
    @Test
    void testGetAllProducts3() {
        productList = new ArrayList<>();
        when(productService.selectAll()).thenReturn(productList);
        List<Product> actualAllProducts = (new ProductController(productService)).getAllProducts();
        assertSame(productList, actualAllProducts);
        assertTrue(actualAllProducts.isEmpty());
        verify(productService).selectAll();
    }

    //working
    @Test
    void testSellectSpesificCatagory3() {
        when(productService.specificitiesCategory((String) any())).thenReturn("Specificities Category");
        assertEquals("Specificities Category", (new ProductController(productService)).sellectSpesificCatagory("Var"));
        verify(productService).specificitiesCategory((String) any());
    }

    //working
    @Test
    void testCreateNewProduct4() {
        when(productService.createProducts((Product) any(), (String) any()))
                .thenReturn(new Product(1, "Catagory", "Dr", "The characteristics of someone or something", "Preview Image"));
        productController = new ProductController(productService);
        ResponseEntity<Product> actualCreateNewProductResult = productController.createNewProduct(
                new Product(1, "Catagory", "Dr", "The characteristics of someone or something", "Preview Image"), "Catagory");
        assertTrue(actualCreateNewProductResult.hasBody());
        assertTrue(actualCreateNewProductResult.getHeaders().isEmpty());
        assertEquals(200, actualCreateNewProductResult.getStatusCodeValue());
        verify(productService).createProducts((Product) any(), (String) any());
    }

    //working
    @Test
    void testSpecificSizeOfVariant4() {
        when(productService.updateProductMeta(anyInt(), (Product) any())).thenReturn(1);
        productController = new ProductController(productService);
        ResponseEntity<Integer> actualSpecificSizeOfVariantResult = productController.updateById(1,
                new Product(1, "Catagory", "Dr", "The characteristics of someone or something", "Preview Image"));
        assertEquals(1, actualSpecificSizeOfVariantResult.getBody().intValue());
        assertEquals(200, actualSpecificSizeOfVariantResult.getStatusCodeValue());
        assertTrue(actualSpecificSizeOfVariantResult.getHeaders().isEmpty());
        verify(productService).updateProductMeta(anyInt(), (Product) any());
    }

    //working
    @Test
    void testCreateNewVariantForSpecificProduct4() {
        when(productService.addvarient(anyInt(), (ColorVariant) any())).thenReturn(new ColorVariant());
        productController = new ProductController(productService);
        ResponseEntity<ColorVariant> actualCreateNewVariantForSpecificProductResult = productController
                .createNewVariantForSpecificProduct(1, new ColorVariant());
        assertTrue(actualCreateNewVariantForSpecificProductResult.hasBody());
        assertTrue(actualCreateNewVariantForSpecificProductResult.getHeaders().isEmpty());
        assertEquals(200, actualCreateNewVariantForSpecificProductResult.getStatusCodeValue());
        verify(productService).addvarient(anyInt(), (ColorVariant) any());
    }

    //working
    @Test
    void testRestock3() {
        when(productService.restockSize(anyInt(), (String) any(), (String) any(), anyInt())).thenReturn(3);
        ResponseEntity<Integer> actualRestockResult = (new ProductController(productService)).Restock(1, "Size", "Color",
                1);
        assertEquals(3, actualRestockResult.getBody().intValue());
        assertEquals(200, actualRestockResult.getStatusCodeValue());
        assertTrue(actualRestockResult.getHeaders().isEmpty());
        verify(productService).restockSize(anyInt(), (String) any(), (String) any(), anyInt());
    }

    //working
    @Test
    void testDeleteProduct3() {
        when(productService.deleteProduct(anyInt())).thenReturn(1);
        ResponseEntity<Object> actualDeleteProductResult = (new ProductController(productService)).deleteProductById(1);
        assertNull(actualDeleteProductResult.getBody());
        assertEquals(200, actualDeleteProductResult.getStatusCodeValue());
        assertTrue(actualDeleteProductResult.getHeaders().isEmpty());
        verify(productService).deleteProduct(anyInt());
    }

    //working
    @Test
    void testDeleteProduct4() {
        when(productService.deleteProduct(anyInt())).thenReturn(-1837112987);
        ResponseEntity<Object> actualDeleteProductResult = (new ProductController(productService)).deleteProductById(1);
        assertNull(actualDeleteProductResult.getBody());
        assertEquals(500, actualDeleteProductResult.getStatusCodeValue());
        assertTrue(actualDeleteProductResult.getHeaders().isEmpty());
        verify(productService).deleteProduct(anyInt());
    }
    //working
    @Test
    void testDeleteVariantOfProduct3() {
        when(productService.deleteVariant(anyInt(), (String) any())).thenReturn(1);
        ResponseEntity<String> actualDeleteVariantOfProductResult = (new ProductController(productService))
                .deleteVariantOfProduct(1, "Color");
        assertNull(actualDeleteVariantOfProductResult.getBody());
        assertEquals(200, actualDeleteVariantOfProductResult.getStatusCodeValue());
        assertTrue(actualDeleteVariantOfProductResult.getHeaders().isEmpty());
        verify(productService).deleteVariant(anyInt(), (String) any());
    }
    //working
    @Test
    void testDeleteVariantOfProduct4() {
        when(productService.deleteVariant(anyInt(), (String) any())).thenReturn(-2);
        ResponseEntity<String> actualDeleteVariantOfProductResult = (new ProductController(productService))
                .deleteVariantOfProduct(1, "Color");
        assertEquals("cant delete what doesnt exist", actualDeleteVariantOfProductResult.getBody());
        assertEquals(400, actualDeleteVariantOfProductResult.getStatusCodeValue());
        assertTrue(actualDeleteVariantOfProductResult.getHeaders().isEmpty());
        verify(productService).deleteVariant(anyInt(), (String) any());
    }
    //working
    @Test
    void testDeleteVariantOfProduct5() {
        when(productService.deleteVariant(anyInt(), (String) any())).thenReturn(-1);
        ResponseEntity<String> actualDeleteVariantOfProductResult = (new ProductController(productService))
                .deleteVariantOfProduct(1, "Color");
        assertEquals("cant delete what doesnt exist", actualDeleteVariantOfProductResult.getBody());
        assertEquals(400, actualDeleteVariantOfProductResult.getStatusCodeValue());
        assertTrue(actualDeleteVariantOfProductResult.getHeaders().isEmpty());
        verify(productService).deleteVariant(anyInt(), (String) any());
    }
    //working
    @Test
    void testDeleteVariantOfProduct6() {
        when(productService.deleteVariant(anyInt(), (String) any())).thenReturn(0);
        ResponseEntity<String> actualDeleteVariantOfProductResult = (new ProductController(productService))
                .deleteVariantOfProduct(1, "Color");
        assertEquals("doesnt exist", actualDeleteVariantOfProductResult.getBody());
        assertEquals(400, actualDeleteVariantOfProductResult.getStatusCodeValue());
        assertTrue(actualDeleteVariantOfProductResult.getHeaders().isEmpty());
        verify(productService).deleteVariant(anyInt(), (String) any());
    }
}

