package com.carrot.back.domain.goods.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TradeStatus {
    BEFORE(10, "거래전"),
    CONFIRM(20, "거래확정"),
    COMPLETED(30, "거래완료");

    final Integer stepCode;
    final String description;
}
