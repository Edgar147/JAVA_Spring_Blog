package com.myblog.app.repository;

import com.myblog.app.model.Text;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository extends JpaRepository<Text, Long> {

}
