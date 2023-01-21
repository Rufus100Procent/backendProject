package se.JensenYH.Java.SaltMerch.backendProject.controller;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

public class PlaceHoldersForTest {

    protected static final int PRODUCT_ID = 0;
    protected static final int PRODUCT_ID1 = 1;
    protected static final int PRODUCT_ID2 = 2;
    protected static final int PRODUCT_ID3 = 3;
    protected static final int PRODUCT_ID4 = 4;
    protected static final int PRODUCT_ID5 = 5;


    protected  static final String NAME = "T shirt";
    protected  static final String NAME1 = "T shirt";
    protected  static final String NAME2 = "T shirt";
    protected  static final String NAME3 = "T shirt";
    protected  static final String NAME4 = "T shirt";
    protected  static final String NAME5 = "T shirt";


    protected static List<String> products;

    @BeforeAll
    public static void beforeAll(){

        products = new ArrayList<>();
        products.add(NAME);
        products.add(NAME1);
        products.add(NAME2);
        products.add(NAME3);
        products.add(NAME4);
        products.add(NAME5);

    }
}
