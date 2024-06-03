package com.fintonic.taskmanager.application.task.usecase.impl;

import java.util.List;

import com.fintonic.taskmanager.domain.task.entity.Task;
import com.fintonic.taskmanager.domain.task.repository.TaskRepository;
import com.fintonic.taskmanager.domain.task.usecase.GetAllTaskUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAllTaskUseCaseImpl implements GetAllTaskUseCase {

  private final TaskRepository taskRepository;

  @Override
  public List<Task> getAll() {
    return taskRepository.getAll();
  }
}
