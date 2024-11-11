package com.carrot.back.api.user.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "회원 등록 요청 model")
public class UserCreateRequest {
    @Schema(description = "id")
    private String userId;
    @Schema(description = "비밀번호")
    private String password;
    @Schema(description = "성명")
    private String userName;
    @Schema(description = "닉네임")
    private String nickname;
    @Schema(description = "주소")
    private String userAddress;
}
