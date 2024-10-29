package com.carrot.back.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AutoCloseable.class)
public abstract class BaseEntity implements Serializable {
    @Column(nullable = false, updatable = false)
    @CreatedDate
    public LocalDateTime createdAt;

    @Column
    @CreatedBy
    public String createdBy;

    @Column
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @Column
    @LastModifiedBy
    public String modifiedBy;
}
