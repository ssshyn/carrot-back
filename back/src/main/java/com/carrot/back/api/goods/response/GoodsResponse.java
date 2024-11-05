package com.carrot.back.api.goods.response;

import com.carrot.back.domain.goods.enumeration.TradeStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Schema(description = "상품 response")
public class GoodsResponse {
    @Schema(description = "id")
    private Long id;
    @Schema(description = "title")
    private String title;
    @Schema(description = "description")
    private String description;
    @Schema(description = "price")
    private BigDecimal price;
    @Schema(description = "TradeStatus")
    private TradeStatus tradeStatus;
    @Schema(description = "TradeStatus Value")
    private String tradeStatusValue;
    @Schema(description = "찜")
    private boolean likes;
}
