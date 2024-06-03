package com.fintonic.taskmanager.infrastructure.mongo.task.mapper;

import java.util.List;

import com.fintonic.taskmanager.domain.task.entity.Task;
import com.fintonic.taskmanager.infrastructure.mongo.task.document.TaskDocument;
import org.mapstruct.Mapper;

@Mapper
public interface TaskEntityMapper {

  Task toEntity(TaskDocument document);

  TaskDocument toDocument(Task entity);

  List<Task> asTaskList(List<TaskDocument> documents);
}
