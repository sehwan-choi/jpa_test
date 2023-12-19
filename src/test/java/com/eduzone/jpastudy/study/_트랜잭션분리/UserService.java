package com.eduzone.jpastudy.study._트랜잭션분리;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserLogicService logicService;
    private final UserTempService tempService;

    public void doService() {
        Long userId = logicService.service();
        try {
            tempService.service();
        } catch (Exception e) {
            logicService.serviceRollback(userId);
        }
    }

}
