package com.example.todo.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.demo.Exceptions.RegistrarDuplicationException;
import com.example.todo.demo.Model.Tasks;
import com.example.todo.demo.Repository.TasksRepository;

import jakarta.transaction.Transactional;

@Service
public class TasksService {

    @Autowired
    TasksRepository repository;
    @Autowired
    RegistrarDuplicationException duplicationTask;

    @Transactional
    public Tasks criarTasks(Tasks tasks) {
        if (repository.findById(tasks.getId()).isPresent()) {
            throw new RegistrarDuplicationException("Task já criada");
        }
        return repository.save(tasks);

    }

}
