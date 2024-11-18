package com.carrot.back.api.user;

import com.carrot.back.api.goods.response.GoodsResponse;
import com.carrot.back.api.user.request.UserCreateRequest;
import com.carrot.back.api.user.request.UserUpdateRequest;
import com.carrot.back.api.user.response.UserCreated;
import com.carrot.back.domain.goods.service.GoodsUseCase;
import com.carrot.back.domain.user.service.UserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "회원 api")
public class UserController {
    private final UserUseCase userUseCase;
    private final GoodsUseCase goodsUseCase;

    @Operation(summary = "회원 등록")
    @PostMapping
    public ResponseEntity<UserCreated> create(@RequestBody UserCreateRequest userCreateRequest) {
        return ResponseEntity.ok(userUseCase.create(userCreateRequest));
    }

    @SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
    @Operation(summary = "회원 구매 이력 조회")
    @GetMapping("/buy/history")
    public ResponseEntity<List<GoodsResponse>> buyHistory() {
        return ResponseEntity.ok(goodsUseCase.buyHistory());
    }

    @SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
    @Operation(summary = "회원 판매 이력 조회")
    @GetMapping("/sale/history")
    public ResponseEntity<List<GoodsResponse>> saleHistory() { return ResponseEntity.ok(goodsUseCase.saleHistory()); }

    @SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
    @Operation(summary = "회원 정보 수정")
    @PutMapping("/update")
    public ResponseEntity<UserCreated> update(@RequestBody UserUpdateRequest userUpdateRequest) {
        return ResponseEntity.ok(userUseCase.update(userUpdateRequest));
    }
}
