package com.fintonic.taskmanager.domain.task.repository;

import java.util.List;

import com.fintonic.taskmanager.domain.task.entity.Task;

public interface TaskRepository {

  public List<Task> getAll();

  public void save(Task task);
}
