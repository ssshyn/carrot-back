package com.carrot.back.api.goods.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "상품 등록 요청 model")
public class GoodsCreateRequest {
    @Schema(description = "상품명")
    private String title;
    @Schema(description = "내용")
    private String description;
    @Schema(description = "비용")
    private BigDecimal price;
}
