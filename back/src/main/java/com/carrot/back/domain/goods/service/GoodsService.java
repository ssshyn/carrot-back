package com.carrot.back.domain.goods.service;

import com.carrot.back.api.goods.request.GoodsCreateRequest;
import com.carrot.back.api.goods.response.GoodsCreated;
import com.carrot.back.api.goods.response.GoodsResponse;
import com.carrot.back.domain.goods.entity.Goods;
import com.carrot.back.domain.goods.enumeration.TradeStatus;
import com.carrot.back.domain.goods.repository.GoodsDataProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class GoodsService implements GoodsUseCase{
    private final GoodsDataProvider goodsDataProvider;

    @Override
    public List<GoodsResponse> findAll() {
        List<Goods> goodsList = goodsDataProvider.findAll();
        return goodsList.stream().map(GoodsMapper::toGoodsResponse).toList();
    }

    @Override
    public GoodsResponse findById(Long id) {
        Optional<Goods> goodsOptional = goodsDataProvider.findById(id);
        return goodsOptional.map(GoodsMapper::toGoodsResponse).orElse(null);
    }

    @Override
    public GoodsCreated create(GoodsCreateRequest createRequest) {
        Goods goods = Goods.builder()
                .title(createRequest.getTitle())
                .description(createRequest.getDescription())
                .price(createRequest.getPrice())
                .tradeStatus(TradeStatus.BEFORE)
                .build();

        return GoodsMapper.toGoodsCreated(goodsDataProvider.create(goods));
    }
}
