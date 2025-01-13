package com.example.todo.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.demo.Model.Tasks;

public interface TasksRepository extends JpaRepository<Tasks, Long> {

}
