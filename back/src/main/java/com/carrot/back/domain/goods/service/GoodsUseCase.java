package com.carrot.back.domain.goods.service;

import com.carrot.back.api.goods.request.GoodsCreateRequest;
import com.carrot.back.api.goods.response.GoodsCreated;
import com.carrot.back.api.goods.response.GoodsResponse;

import java.util.List;

public interface GoodsUseCase {
    List<GoodsResponse> findAll();

    GoodsResponse findById(Long id);

    GoodsCreated create(GoodsCreateRequest createRequest);
}
