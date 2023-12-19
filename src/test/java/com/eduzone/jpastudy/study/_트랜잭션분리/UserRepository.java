package com.eduzone.jpastudy.study._트랜잭션분리;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
