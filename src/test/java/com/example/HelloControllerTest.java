package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // トップページ表示テスト（資料のサンプル）
    @Test
    public void トップページ表示() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(status().is2xxSuccessful())
               .andExpect(content().string(containsString("Hello World")));
    }

    // ★課題6で指示されているテスト（ハローページ表示テスト）
    @Test
    public void ハローページ表示() throws Exception {
        mockMvc.perform(get("/hello"))
               .andExpect(status().is2xxSuccessful())
               .andExpect(content().string(containsString("Hello, Spring Boot!")));
    }
}