package com.carrot.back.domain.likes.repository;

import com.carrot.back.domain.likes.entity.Likes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LikesDataProvider {
    private final LikesRepository likesRepository;

    public List<Likes> findAll() {
        return likesRepository.findAll();
    }

    public Optional<Likes> findById(Long id) {
        return likesRepository.findById(id);
    }

    public void create(Likes likes) {
        likesRepository.save(likes);
    }

    public void delete(Likes likes) {
        likesRepository.delete(likes);
    }

    public Optional<Likes> findByUserIdAndGoodsId(Long userId, Long goodsId) {
        return likesRepository.findByUserIdAndGoodsId(userId, goodsId);
    }

    public List<Likes> findByUserId(Long userId) {
        return likesRepository.findByUserId(userId);
    }
}
