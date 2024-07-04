package com.example.restdocrs.user.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.restdocrs.user.UserService;
import com.example.restdocrs.user.dto.request.UserInfoRequest;
import com.example.restdocrs.user.dto.response.UserInfoData;
import com.example.restdocrs.user.dto.response.UserInfoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc // -> webAppContextSetup(webApplicationContext)
@AutoConfigureRestDocs // -> apply(documentationConfiguration(restDocumentation))
@WebMvcTest(UserController.class) // @WebMvcTest(NaverOrderController.class) 사용하여도 무관
//@SpringBootTest // @WebMvcTest(NaverOrderController.class) 사용하여도 무관
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

//    [@MockBean
//    private NaverOrderService naverOrderService;
//    @Autowired
//    private ObjectMapper objectMapper;]
    @Test
    @DisplayName("restDocs 문서")
    void getUserInfoList() throws Exception {
        //문서 작성
        Mockito.when(userService.getUserInfoList(any())).thenReturn(getUserInfoResponse());

        mockMvc.perform(post("/user/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getUserInfoRequest()))
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("test"
                                , preprocessRequest(prettyPrint())
                                , preprocessResponse(prettyPrint())
                                , requestFields(
                                        fieldWithPath("userId").type(JsonFieldType.STRING).description("유저 아이디")
                                        , fieldWithPath("userName").type(JsonFieldType.STRING).description("유저 이름")
                                        , fieldWithPath("fromDate").type(JsonFieldType.STRING).description("조회시작 일자 ")
                                        , fieldWithPath("toDate").type(JsonFieldType.STRING).description("조회 end 날짜")
                                )
                                , responseFields(
                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("user data")
                                        , fieldWithPath("data[].userId").type(JsonFieldType.STRING).description("유저아이디")
                                        , fieldWithPath("data[].userName").type(JsonFieldType.STRING).description("유저이름")
                                        , fieldWithPath("data[].createDate").type(JsonFieldType.STRING).description("생서일자")
                                )
                        )
                );
    }
    UserInfoRequest getUserInfoRequest() {
        return UserInfoRequest.of("a", "에이", LocalDateTime.now().minusMinutes(1), LocalDateTime.now());
    }
    UserInfoResponse getUserInfoResponse() {
        return UserInfoResponse.of(List.of(
                UserInfoData.of("a", "ㅇㅔ이", LocalDateTime.now())
                , UserInfoData.of("b", "비", LocalDateTime.now().plusMinutes(1))
                , UserInfoData.of("c", "씨", LocalDateTime.now().plusMinutes(2))
        ));
    }
}