package com.carrot.back.api.user;

import com.carrot.back.api.user.request.UserCreateRequest;
import com.carrot.back.api.user.response.UserCreated;
import com.carrot.back.domain.user.repository.UserRepository;
import com.carrot.back.domain.user.service.UserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "회원 api")
public class UserController {
    private final UserUseCase userUseCase;
    private final UserRepository userRepository;

    @Operation(summary = "회원 등록")
    @PostMapping
    public ResponseEntity<UserCreated> create(@RequestBody UserCreateRequest userCreateRequest) {
        return ResponseEntity.ok(userUseCase.create(userCreateRequest));
    }
}
