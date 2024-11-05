package com.carrot.back.domain.likes.entity;

import com.carrot.back.core.entity.BaseEntity;
import com.carrot.back.domain.goods.entity.Goods;
import com.carrot.back.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Table(name = "likes")
public class Likes extends BaseEntity {
    @Id
    @GeneratedValue
    public Long id;

    @OneToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @ManyToOne
    private User user;
}


//    @JoinColumn(name = "user_id")
