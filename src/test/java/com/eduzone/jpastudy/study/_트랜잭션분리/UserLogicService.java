package com.eduzone.jpastudy.study._트랜잭션분리;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserLogicService {

    private final UserRepository userRepository;

    @Transactional
    public Long service() {
        User name = new User("name", 1, "010-1234-5678");
        return userRepository.save(name).getId();
    }

    @Transactional
    public void serviceRollback(Long userId) {
        userRepository.findById(userId).ifPresent(userRepository::delete);
        ;
    }
}
