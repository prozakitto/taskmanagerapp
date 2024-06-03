package com.fintonic.taskmanager.infrastructure.mongo.task.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.Date;
import java.util.List;

import com.fintonic.taskmanager.domain.task.entity.Task;
import com.fintonic.taskmanager.infrastructure.mongo.task.document.TaskDocument;
import com.fintonic.taskmanager.infrastructure.mongo.task.mapper.TaskEntityMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TaskRepositoryImplTest {

  @Mock
  private TaskMongoRepository taskMongoRepository;

  @Mock
  private TaskEntityMapper taskEntityMapper;

  @InjectMocks
  private TaskRepositoryImpl taskRepositoryImpl;

  @Test
  @DisplayName("Get all tasks should invoke the repository getAll method")
  public void getAllTasks() {
    // Given
    Task task = new Task("Hire employee", "Hire a new employee for the company", new Date(), List.of());
    TaskDocument taskDocument = new TaskDocument("Hire employee", "Hire a new employee for the company", new Date(), List.of());

    BDDMockito.given(taskMongoRepository.findAll()).willReturn(List.of(taskDocument));
    BDDMockito.given(taskEntityMapper.asTaskList(List.of(taskDocument))).willReturn(List.of(task));

    // When
    List<Task> result = taskRepositoryImpl.getAll();
    // Then
    assertEquals(List.of(task), result);
    verify(taskMongoRepository).findAll();
    verify(taskEntityMapper).asTaskList(List.of(taskDocument));

  }

  @Test
  @DisplayName("Save task should invoke the repository save method")
  public void saveTask() {
    // Given
    Task task = new Task("Hire employee", "Hire a new employee for the company", new Date(), List.of());
    TaskDocument taskDocument = new TaskDocument("Hire employee", "Hire a new employee for the company", new Date(), List.of());
    BDDMockito.given(taskEntityMapper.toDocument(task)).willReturn(taskDocument);
    BDDMockito.given(taskMongoRepository.save(taskDocument)).willReturn(taskDocument);

    // When
    taskRepositoryImpl.save(task);

    // Then
    verify(taskEntityMapper).toDocument(task);
    verify(taskMongoRepository).save(taskDocument);
  }
}
