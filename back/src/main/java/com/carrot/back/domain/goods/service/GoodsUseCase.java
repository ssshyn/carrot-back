package com.carrot.back.domain.goods.service;

import com.carrot.back.api.goods.request.GoodsCreateRequest;
import com.carrot.back.api.goods.request.GoodsStatusRequest;
import com.carrot.back.api.goods.response.GoodsCreated;
import com.carrot.back.api.goods.response.GoodsResponse;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface GoodsUseCase {
    List<GoodsResponse> findAll();

    GoodsResponse findById(Long id);

    GoodsCreated create(GoodsCreateRequest createRequest);

    GoodsResponse update(Long id, GoodsCreateRequest createRequest) throws BadRequestException;

    GoodsResponse updateStatus(GoodsStatusRequest goodsStatusRequest) throws Exception;

    Long like(Long id) throws BadRequestException;

    List<GoodsResponse> getLikeList();

    List<GoodsResponse> buyHistory();

    List<GoodsResponse> saleHistory();
}
