package com.example.session.repository;

import com.example.session.entity.SessionLogin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionLoginRepository extends CrudRepository <SessionLogin, Long> {
    SessionLogin findByUSERID (String userId);
}
