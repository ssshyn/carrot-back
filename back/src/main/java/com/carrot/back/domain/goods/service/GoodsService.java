package com.carrot.back.domain.goods.service;

import com.carrot.back.api.goods.request.GoodsCreateRequest;
import com.carrot.back.api.goods.request.GoodsStatusRequest;
import com.carrot.back.api.goods.response.GoodsCreated;
import com.carrot.back.api.goods.response.GoodsResponse;
import com.carrot.back.domain.goods.entity.Goods;
import com.carrot.back.domain.goods.enumeration.TradeStatus;
import com.carrot.back.domain.goods.repository.GoodsDataProvider;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.server.NotAcceptableStatusException;

import java.util.List;
import java.util.Objects;
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

    @Override
    public GoodsResponse update(Long id, GoodsCreateRequest createRequest) throws BadRequestException {
        Goods goods = goodsDataProvider.findById(id).orElseThrow(EntityNotFoundException::new);

        if(!Objects.equals(goods.getTradeStatus(), TradeStatus.BEFORE)) {
            throw new BadRequestException("거래 확정된 상품은 변경 불가능합니다.");
        }

        goods.setTitle(createRequest.getTitle());
        goods.setDescription(createRequest.getDescription());
        goods.setPrice(createRequest.getPrice());

        return GoodsMapper.toGoodsResponse(goodsDataProvider.update(goods));
    }

    @Override
    public GoodsResponse updateStatus(GoodsStatusRequest goodsStatusRequest) {
        Goods goods = goodsDataProvider.findById(goodsStatusRequest.getId()).orElseThrow(EntityNotFoundException::new);

        goods.setTradeStatus(goodsStatusRequest.getTradeStatus());

        return GoodsMapper.toGoodsResponse(goodsDataProvider.update(goods));
    }
}
