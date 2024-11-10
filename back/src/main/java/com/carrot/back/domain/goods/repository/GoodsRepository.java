package com.carrot.back.domain.goods.repository;

import com.carrot.back.domain.goods.entity.Goods;
import com.carrot.back.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {
    public List<Goods> findByBuyer(User user);
}
