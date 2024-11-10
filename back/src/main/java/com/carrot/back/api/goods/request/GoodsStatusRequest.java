package com.carrot.back.api.goods.request;

import com.carrot.back.domain.goods.enumeration.TradeStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "거래 상태 변경 요청 model")
public class GoodsStatusRequest {
    @Schema(description = "상품 ID")
    private Long id;
    @Schema(description = "거래 상태")
    private TradeStatus tradeStatus;
    @Schema(description = "구매자 id")
    private String buyerId;
}
