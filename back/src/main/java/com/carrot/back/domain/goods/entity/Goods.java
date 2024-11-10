package com.carrot.back.domain.goods.entity;

import com.carrot.back.core.entity.BaseEntity;
import com.carrot.back.domain.goods.enumeration.TradeStatus;
import com.carrot.back.domain.likes.entity.Likes;
import com.carrot.back.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@DynamicUpdate
@Table(name = "goods")
public class Goods extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TradeStatus tradeStatus;

    @OneToOne
    private User buyer;

    @OneToMany(mappedBy = "goods")
    private List<Likes> likes = new ArrayList<>();
}
