package com.ft.acitivityservice.repository;

import com.ft.acitivityservice.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepo extends JpaRepository<Activity, Long> {

    List<Activity> findByUserId(Long userId);
}
