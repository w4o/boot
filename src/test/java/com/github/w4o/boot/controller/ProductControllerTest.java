package com.github.w4o.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@DisplayName("测试-商品")
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "user", password = "user")
@Slf4j
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("获取id为1的商品信息（存在）")
    @Test
    void get() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/product/1");
        MvcResult result = mockMvc.perform(req).andReturn();
        int httpStatus = result.getResponse().getStatus();
        String content = result.getResponse().getContentAsString();
        log.info("Response: HttpStatus={},content={}", httpStatus, content);
        Assertions.assertEquals(httpStatus, HttpStatus.OK.value());
    }

    @DisplayName("获取id为3的商品信息（不存在）")
    @Test
    void getNotFound() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/product/3");
        MvcResult result = mockMvc.perform(req).andReturn();
        int httpStatus = result.getResponse().getStatus();
        String content = result.getResponse().getContentAsString();
        log.info("Response: HttpStatus={},content={}", httpStatus, content);
        Assertions.assertEquals(httpStatus, HttpStatus.NOT_FOUND.value());
    }

    @Test
    void put() {
    }

    @Test
    void post() {
    }

    @Test
    void delete() {
    }
}