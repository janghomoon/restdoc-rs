package com.example.restdocrs.user.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@AutoConfigureMockMvc // -> webAppContextSetup(webApplicationContext)
@AutoConfigureRestDocs // -> apply(documentationConfiguration(restDocumentation))
@SpringBootTest // @WebMvcTest(NaverOrderController.class) 사용하여도 무관
class UserControllerTest {


}