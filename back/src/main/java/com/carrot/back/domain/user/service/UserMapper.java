package com.carrot.back.domain.user.service;

import com.carrot.back.api.user.response.UserCreated;
import com.carrot.back.domain.user.entity.User;

import java.util.Optional;

public class UserMapper {
    public static UserCreated toUserCreated(Optional<User> user) {
        return user.map(value -> UserCreated.builder()
                .userId(value.getUserId())
                .build()).orElse(null);
    }
}
