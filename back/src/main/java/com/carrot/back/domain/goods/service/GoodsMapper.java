package com.carrot.back.domain.goods.service;

import com.carrot.back.api.goods.response.GoodsCreated;
import com.carrot.back.api.goods.response.GoodsResponse;
import com.carrot.back.domain.goods.entity.Goods;
import com.carrot.back.domain.goods.enumeration.TradeStatus;

import java.util.Optional;

public class GoodsMapper {

    public static GoodsResponse toGoodsResponse(Goods goods) {
        return GoodsResponse.builder()
                .id(goods.getId())
                .title(goods.getTitle())
                .description(goods.getDescription())
                .price(goods.getPrice())
                .tradeStatus(goods.getTradeStatus())
                .tradeStatusValue(goods.getTradeStatus().getDescription())
                .build();
    }

    public static GoodsCreated toGoodsCreated(Optional<Goods> goods) {
        return goods.map(value -> GoodsCreated.builder()
                .id(value.getId())
                .build()).orElse(null);
    }
}
