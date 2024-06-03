package com.fintonic.taskmanager.domain.task.usecase;

import java.util.List;

import com.fintonic.taskmanager.domain.task.entity.Task;

public interface GetAllTaskUseCase {

  List<Task> getAll();
}
