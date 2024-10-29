package com.carrot.back.domain.user.service;

import com.carrot.back.api.user.request.UserCreateRequest;
import com.carrot.back.api.user.response.UserCreated;
import com.carrot.back.domain.user.entity.User;
import com.carrot.back.domain.user.repository.UserDataProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserUseCase{
    private final PasswordEncoder passwordEncoder;
    private final UserDataProvider userDataProvider;

    @Override
    public UserCreated create(UserCreateRequest userCreateRequest) {
        User user = User.builder()
                .userId(userCreateRequest.getUserId())
                .password(passwordEncoder.encode(userCreateRequest.getPassword()))
                .userName(userCreateRequest.getUserName())
                .userAddress(userCreateRequest.getUserAddress())
                .build();

        return UserMapper.toUserCreated(userDataProvider.create(user));
    }
}
