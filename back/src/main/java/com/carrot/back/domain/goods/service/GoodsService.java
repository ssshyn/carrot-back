package com.carrot.back.domain.goods.service;

import com.carrot.back.api.goods.request.GoodsCreateRequest;
import com.carrot.back.api.goods.request.GoodsStatusRequest;
import com.carrot.back.api.goods.response.GoodsCreated;
import com.carrot.back.api.goods.response.GoodsResponse;
import com.carrot.back.core.util.SessionUtil;
import com.carrot.back.domain.goods.entity.Goods;
import com.carrot.back.domain.goods.enumeration.TradeStatus;
import com.carrot.back.domain.goods.repository.GoodsDataProvider;
import com.carrot.back.domain.likes.entity.Likes;
import com.carrot.back.domain.likes.repository.LikesDataProvider;
import com.carrot.back.domain.user.entity.User;
import com.carrot.back.domain.user.repository.UserDataProvider;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class GoodsService implements GoodsUseCase{
    private final GoodsDataProvider goodsDataProvider;
    private final LikesDataProvider likesDataProvider;
    private final UserDataProvider userDataProvider;

    @Override
    public List<GoodsResponse> findAll() {
        List<Goods> goodsList = goodsDataProvider.findAll();
        goodsList.forEach(
                goods -> {
//                    likesDataProvider.
                }
        );
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
    public GoodsResponse updateStatus(GoodsStatusRequest goodsStatusRequest) throws Exception {
        Goods goods = goodsDataProvider.findById(goodsStatusRequest.getId()).orElseThrow(EntityNotFoundException::new);

        goods.setTradeStatus(goodsStatusRequest.getTradeStatus());

        if(goods.getTradeStatus().equals(TradeStatus.CONFIRM)) {
            //구매자 정보 조회
            User buyer = userDataProvider.findByUserId(StringUtils.trimAllWhitespace(goodsStatusRequest.getBuyerId()))
                    .orElseThrow(EntityNotFoundException::new);
            goods.setBuyer(buyer);
        }

        if(goods.getTradeStatus().equals(TradeStatus.COMPLETED)) {
            if(goods.getBuyer() == null) {
                throw new Exception("구매자가 있어야 구매 확정이 가능합니다.");
            }
        }

        return GoodsMapper.toGoodsResponse(goodsDataProvider.update(goods));
    }

    @Override
    public Long like(Long id) throws BadRequestException {
        String userId = SessionUtil.getSessionId();
        User user = userDataProvider.findByUserId(userId).orElseThrow(() -> new UsernameNotFoundException("로그인 해주세요"));
        Goods goods = goodsDataProvider.findById(id).orElseThrow(EntityNotFoundException::new);

        if(Objects.equals(goods.getCreatedBy(), userId)) {
            throw new BadRequestException("작성자는 찜할 수 없어용");
        }

        Optional<Likes> likesOptional = likesDataProvider.findByUserIdAndGoodsId(user.getId(), goods.getId());

        if (likesOptional.isPresent()) {
            likesDataProvider.delete(likesOptional.get());
        } else {
            likesDataProvider.create(Likes.builder()
                            .goods(goods)
                            .user(user)
                    .build());
        }

        return goods.getId();
    }

    @Override
    public List<GoodsResponse> getLikeList() {
        String userId = SessionUtil.getSessionId();
        User user = userDataProvider.findByUserId(userId).orElseThrow(() -> new UsernameNotFoundException("로그인 해주세요"));

        List<Likes> likesList = likesDataProvider.findByUserId(user.getId());
        return likesList.stream().map(x -> GoodsMapper.toGoodsResponse(x.getGoods())).toList();
    }

    @Override
    public List<GoodsResponse> buyHistory() {
        String userId = SessionUtil.getSessionId();
        User user = userDataProvider.findByUserId(userId).orElseThrow(() -> new UsernameNotFoundException("로그인 해주세요"));

        List<Goods> buyHistoryList = goodsDataProvider.findByBuyHistory(user);
        return buyHistoryList.stream().map(GoodsMapper::toGoodsResponse).toList();
    }

    @Override
    public List<GoodsResponse> saleHistory() {
        String userId = SessionUtil.getSessionId();
        User user = userDataProvider.findByUserId(userId).orElseThrow(() -> new UsernameNotFoundException("로그인 해주세요."));

        List<Goods> saleHistoryList = goodsDataProvider.findBySaleHistory(user);
        return saleHistoryList.stream().map(GoodsMapper::toGoodsResponse).toList();
    }
}
