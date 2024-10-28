package com.carrot.back.api.user.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Schema(description = "회원 등록 response")
public class UserCreated {
    @Schema(description = "userId")
    private String userId;
}
