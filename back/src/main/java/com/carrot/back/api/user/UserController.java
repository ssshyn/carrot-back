package com.carrot.back.api.user;

import com.carrot.back.api.user.request.UserCreateRequest;
import com.carrot.back.api.user.response.UserCreated;
import com.carrot.back.domain.user.service.UserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/word")
@Tag(name = "회원 api")
public class UserController {
    private final UserUseCase userUseCase;

    @Operation(summary = "회원 등록")
    @PostMapping
    public ResponseEntity<UserCreated> create(@RequestBody UserCreateRequest userCreateRequest) {
        return ResponseEntity.ok(userUseCase.create(userCreateRequest));
    }
}
