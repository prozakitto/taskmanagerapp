package com.fintonic.taskmanager.domain.task.usecase;

import com.fintonic.taskmanager.domain.task.entity.Task;

public interface CreateTaskUseCase {

  void create(Task task);
}
