package com.myblog.app.repository;

import com.myblog.app.model.Text;
import com.myblog.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public interface TextRepository extends JpaRepository<Text, Long> {
//    @Autowired
//    UserRepository userRepo = null;
//
//    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    String name = auth.getName();
//
//    User posts=userRepo.findByEmail(name);
//    @Query("SELECT u FROM texts u WHERE u.id=6 ")
//    public Long findByUserId(Long id);

}
