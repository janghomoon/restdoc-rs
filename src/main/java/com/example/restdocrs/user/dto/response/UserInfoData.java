package com.example.restdocrs.user.dto.response;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoData {
    private String userId;
    private String userName;
    private LocalDateTime createDate;

    private UserInfoData(String userId, String userName, LocalDateTime createDate) {
        this.userId = userId;
        this.userName = userName;
        this.createDate = createDate;
    }

    public static UserInfoData of(String userId, String userName, LocalDateTime createDate) {
        return new UserInfoData(userId, userName, createDate);


    }

}
