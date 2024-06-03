package com.fintonic.taskmanager.application.task.usecase.impl;

import static org.mockito.Mockito.verify;

import java.util.Date;
import java.util.List;

import com.fintonic.taskmanager.domain.task.entity.Task;
import com.fintonic.taskmanager.domain.task.repository.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateTaskUseCaseImplTest {

  @Mock
  private TaskRepository taskRepository;

  @InjectMocks
  private CreateTaskUseCaseImpl createTaskUseCase;

  @Test
  @DisplayName("Create a task should invoke the repository save method")
  public void createTask() {
    // Given
    Task task = new Task("Hire employee", "Hire a new employee for the company", new Date(), List.of());
    // When
    createTaskUseCase.create(task);
    // Then
    verify(taskRepository).save(task);
  }
}
