package com.eduzone.jpastudy.study._트랜잭션분리;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserTempService {

    private final UserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void service() {
        User user = userRepository.findById(2L).orElseThrow(() -> new RuntimeException("Exception!!"));
        user.setName("zzzz");
    }
}
