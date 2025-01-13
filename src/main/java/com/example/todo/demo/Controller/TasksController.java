package com.example.todo.demo.Controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.demo.Model.Tasks;
import com.example.todo.demo.Service.TasksService;

@RestController
@RequestMapping("tasks")
public class TasksController implements GenericController {

    @Autowired
    private TasksService service;

    @PostMapping
    public ResponseEntity<Tasks> salvarTasks(@RequestBody Tasks tasks) {

        Tasks novaTask = service.criarTasks(tasks);
        URI location = gerarHeaderLocation(novaTask.getId());

        return ResponseEntity.created(location).build();
    }

}
