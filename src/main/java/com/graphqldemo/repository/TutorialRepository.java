package com.graphqldemo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphqldemo.entity.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Serializable> {

}
