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
@Schema(description = "로그인 요청 model")
public class LoginRequest {
    @Schema(description = "아이디")
    private String id;
    @Schema(description = "비밀번호")
    private String password;
}
