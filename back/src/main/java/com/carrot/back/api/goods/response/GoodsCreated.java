package com.carrot.back.api.goods.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Schema(description = "상품 등록 response")
public class GoodsCreated {
    @Schema(description = "id")
    private Long id;
}
