package se.JensenYH.Java.SaltMerch.backendProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContextTest {

    private int port;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getBaseUrl()
    {
        return "http://localhost:" + port + "/api/v1/";
    }

}