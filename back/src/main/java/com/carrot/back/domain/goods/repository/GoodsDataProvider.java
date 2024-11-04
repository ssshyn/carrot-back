package com.carrot.back.domain.goods.repository;

import com.carrot.back.domain.goods.entity.Goods;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GoodsDataProvider {
    private final GoodsRepository goodsRepository;

    public List<Goods> findAll() {
        return goodsRepository.findAll();
    }

    public Optional<Goods> findById(Long id) {
        return goodsRepository.findById(id);
    }

    public Optional<Goods> create(Goods goods) {
        return Optional.of(goodsRepository.save(goods));
    }

    public Goods update(Goods goods) {
        return goodsRepository.save(goods);
    }
}
