package com.fintonic.taskmanager.infrastructure.mongo.task.repository;

import java.util.List;

import com.fintonic.taskmanager.domain.task.entity.Task;
import com.fintonic.taskmanager.domain.task.repository.TaskRepository;
import com.fintonic.taskmanager.infrastructure.mongo.task.mapper.TaskEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {

  private final TaskMongoRepository taskMongoRepository;

  private final TaskEntityMapper taskEntityMapper;

  @Override
  public List<Task> getAll() {
    return taskEntityMapper.asTaskList(taskMongoRepository.findAll());
  }

  @Override
  public void save(Task task) {
    taskMongoRepository.save(taskEntityMapper.toDocument(task));
  }
}
