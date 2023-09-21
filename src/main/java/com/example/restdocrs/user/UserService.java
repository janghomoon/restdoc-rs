package com.example.restdocrs.user;

import com.example.restdocrs.user.dto.request.UserInfoRequest;
import com.example.restdocrs.user.dto.response.UserInfoData;
import com.example.restdocrs.user.dto.response.UserInfoResponse;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    public UserInfoResponse getUserInfoList(UserInfoRequest request) {

        return UserInfoResponse.of(List.of(
                UserInfoData.of(request.getUserId(), request.getUserName(), LocalDateTime.now())
                , UserInfoData.of(request.getUserId()+ "1", request.getUserName()+ "2", LocalDateTime.now().minusHours(1))
                ));
    }

}
