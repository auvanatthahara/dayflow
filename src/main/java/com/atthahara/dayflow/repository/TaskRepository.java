package com.atthahara.dayflow.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atthahara.dayflow.model.TaskModel;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, UUID> {

}
