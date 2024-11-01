package com.carrot.back.api.goods;

import com.carrot.back.api.goods.request.GoodsCreateRequest;
import com.carrot.back.api.goods.response.GoodsCreated;
import com.carrot.back.api.goods.response.GoodsResponse;
import com.carrot.back.domain.goods.service.GoodsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
@RestController
@RequiredArgsConstructor
@RequestMapping("/goods")
@Tag(name = "상품 api")
public class GoodsController {
    private final GoodsUseCase goodsUseCase;

    @Operation(summary = "상품 목록 조회")
    @GetMapping
    public ResponseEntity<List<GoodsResponse>> findAll() {
        return ResponseEntity.ok(goodsUseCase.findAll());
    }

    @Operation(summary = "상품 상세 조회")
    @GetMapping("/{id}")
    public ResponseEntity<GoodsResponse> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(goodsUseCase.findById(id));
    }

    @Operation(summary = "상품 등록")
    @PostMapping
    public ResponseEntity<GoodsCreated> create(@RequestBody GoodsCreateRequest createRequest) {
        return ResponseEntity.ok(goodsUseCase.create(createRequest));
    }
}
