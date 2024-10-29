package com.carrot.back.domain.goods.entity;

import com.carrot.back.core.entity.BaseEntity;
import com.carrot.back.domain.goods.enumeration.TradeStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
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
    private TradeStatus tradeStatus;
}
