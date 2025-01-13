package com.example.todo.demo.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.todo.demo.Model.Tasks;
import com.example.todo.demo.Service.TasksService;

@SpringBootTest
@AutoConfigureMockMvc
public class TasksControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TasksService service;

    private Tasks task;

    @BeforeEach
    public void setUp() {
        task = new Tasks("Ir ao mercado", LocalDate.of(2025, 1, 20), "incomplete");
    }

    @Test
    public void criarTaskscomSucesso() throws Exception {
        String tasksJson = """
                {
                    "nameTask": "Ir ao mercado",
                    "dateTask": "2025-01-20",
                    "status": "incomplete"
                }
                """;

        task.setId(1L);

        // Simule o comportamento do Service
        when(service.criarTasks(any(Tasks.class))).thenReturn(task);

        // Realize a requisição POST
        mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(tasksJson))
                .andExpect(status().isCreated())
                .andExpect(header().exists("location"));

        // Verifique se o método criarTasks foi chamado
        verify(service, times(1)).criarTasks(any(Tasks.class));
    }
}
