package com.fintonic.taskmanager.application.task.usecase.impl;

import static org.mockito.Mockito.verify;

import com.fintonic.taskmanager.domain.task.repository.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetAllTaskUseCaseImplTest {

  @Mock
  private TaskRepository taskRepository;

  @InjectMocks
  private GetAllTaskUseCaseImpl getAllTaskUseCase;

  @Test
  @DisplayName("Get all tasks should invoke the repository getAll method")
  public void getAllTasks() {
    // When
    getAllTaskUseCase.getAll();
    // Then
    verify(taskRepository).getAll();
  }

}
