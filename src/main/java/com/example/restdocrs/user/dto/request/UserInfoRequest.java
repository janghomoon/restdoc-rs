package com.example.restdocrs.user.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class UserInfoRequest {
    @NotEmpty(message = "userId 는 필수 입니다.")
    private String userId;
    @NotEmpty(message = "userName은 필수 입니다.")
    private String userName;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime fromDate;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime toDate;

    private UserInfoRequest(String userId, String userName, LocalDateTime fromDate,
            LocalDateTime toDate) {
        this.userId = userId;
        this.userName = userName;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public static UserInfoRequest of(String userId, String userName, LocalDateTime fromDate,
            LocalDateTime toDate) {
        return new UserInfoRequest(userId, userName, fromDate, toDate);
    }
}
