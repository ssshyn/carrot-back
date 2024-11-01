package com.carrot.back.domain.user.repository;

import com.carrot.back.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDataProvider {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    public Optional<User> create(User user) {
        return Optional.of(userRepository.save(user));
    }

    public Optional<User> update(User user) {
        return Optional.of(userRepository.save(user));
    }
}
