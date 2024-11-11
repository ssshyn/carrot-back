package com.carrot.back.api.goods;

import com.carrot.back.api.goods.request.GoodsCreateRequest;
import com.carrot.back.api.goods.request.GoodsStatusRequest;
import com.carrot.back.api.goods.response.GoodsCreated;
import com.carrot.back.api.goods.response.GoodsResponse;
import com.carrot.back.domain.goods.service.GoodsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
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

    @Operation(summary = "상품 수정")
    @PutMapping("/{id}")
    public ResponseEntity<GoodsResponse> update(@PathVariable(name = "id") Long id,
                                                @RequestBody GoodsCreateRequest createRequest) throws BadRequestException {
        return ResponseEntity.ok(goodsUseCase.update(id, createRequest));
    }

    @Operation(summary = "거래 상태 변경")
    @PutMapping("/status")
    public ResponseEntity<GoodsResponse> updateStatus(@RequestBody GoodsStatusRequest goodsStatusRequest) throws Exception {
        return ResponseEntity.ok(goodsUseCase.updateStatus(goodsStatusRequest));
    }

    @Operation(summary = "찜하기")
    @PutMapping("/like")
    public ResponseEntity<Long> like(@RequestParam(name = "goodsId") Long goodsId) throws BadRequestException {
        return ResponseEntity.ok(goodsUseCase.like(goodsId));
    }

    @Operation(summary = "찜 목록")
    @GetMapping("/like")
    public ResponseEntity<List<GoodsResponse>> getLikeList() {
        return ResponseEntity.ok(goodsUseCase.getLikeList());
    }
}
