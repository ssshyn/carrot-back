package com.carrot.back.domain.user.service;

import com.carrot.back.api.user.request.UserCreateRequest;
import com.carrot.back.api.user.request.UserUpdateRequest;
import com.carrot.back.api.user.response.UserCreated;

public interface UserUseCase {
    UserCreated create(UserCreateRequest userCreateRequest);

    UserCreated update(UserUpdateRequest userUpdateRequest);
}
