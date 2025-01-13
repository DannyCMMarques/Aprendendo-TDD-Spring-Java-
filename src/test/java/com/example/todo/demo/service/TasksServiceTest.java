package com.example.todo.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.todo.demo.Exceptions.RegistrarDuplicationException;
import com.example.todo.demo.Model.Tasks;
import com.example.todo.demo.Repository.TasksRepository;
import com.example.todo.demo.Service.TasksService;

@ExtendWith(MockitoExtension.class)
public class TasksServiceTest {

    @InjectMocks
    TasksService service;

    @Mock
    TasksRepository repository;

    Tasks task;

    @BeforeEach
    public void setUp() {
        task = new Tasks("Ir ao mercado", LocalDate.of(2025, 1, 20), "incomplete");
    };

    @Test
    void deveCriarTasksSucesso() {

        when(repository.save(any(Tasks.class))).thenReturn(task);

        Tasks taskCriada = service.criarTasks(task);

        verify(repository, times(1)).save(any(Tasks.class));
        assertEquals(task, taskCriada);
    }

    @Test
    void deveCriarTasksErro() {

        when(repository.findById(task.getId())).thenThrow(new RegistrarDuplicationException());

        assertThrows(RegistrarDuplicationException.class, () -> {
            service.criarTasks(task);
        });

        verify(repository, times(1)).findById(task.getId());
    }
}
