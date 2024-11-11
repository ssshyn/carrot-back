package com.carrot.back.domain.likes.repository;

import com.carrot.back.domain.likes.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findByUserIdAndGoodsId(Long userId, Long goodsId);
    List<Likes> findByUserId(Long userId);
}
