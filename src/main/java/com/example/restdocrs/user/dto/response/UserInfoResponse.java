package com.example.restdocrs.user.dto.response;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserInfoResponse {
    private List<UserInfoData> data;

    private UserInfoResponse(List<UserInfoData> data) {
        this.data = data;
    }

    public static UserInfoResponse of(List<UserInfoData> data) {
        return new UserInfoResponse(data);
    }
}
