package com.example.mypj.database.repository;

import com.example.mypj.database.entity.Contents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentsRepository extends JpaRepository<Contents, Long> {
    public List<Contents> findAll();
}
