package com.eduzone.jpastudy.study._9장_값타입._값타입의_필요성._값타입_도입_후;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._9장_값타입._값타입의_필요성._값타입_도입_후")
@Rollback(value = false)
public class TestMain {

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    void test() {
        PhoneProvider provider = new PhoneProvider("SKT", "+82", "14");

        User user = new User("name",1);
        user.setHouseAddress("buchoen", "jungdong-ro","93124");
        user.setCompanyAddress("seoul", "rugo", "41345");
        user.setPhoneService(provider, "010-1234-5678");

        em.persist(provider);
        em.persist(user);

        em.flush();
        em.clear();

        User findUser = em.find(User.class, 1L);

        System.out.println("findUser = " + findUser);
        System.out.println("findUser.getAddress() = " + findUser.getAddress());
        System.out.println("findUser.getCompanyAddress() = " + findUser.getCompanyAddress());
        System.out.println("findUser.getPhoneService().getPhoneNumber() = " + findUser.getPhoneService().getPhoneNumber());
        System.out.println("findUser.getPhoneService().getProvider() = " + findUser.getPhoneService().getProvider());
    }
}
