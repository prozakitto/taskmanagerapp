package com.fintonic.taskmanager.application.task.usecase.impl;

import com.fintonic.taskmanager.domain.task.entity.Task;
import com.fintonic.taskmanager.domain.task.repository.TaskRepository;
import com.fintonic.taskmanager.domain.task.usecase.CreateTaskUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

  private final TaskRepository taskRepository;

  @Override
  public void create(Task task) {
    taskRepository.save(task);
  }
}
