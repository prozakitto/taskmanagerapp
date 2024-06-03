package com.fintonic.taskmanager.infrastructure.rest.mapper;

import java.util.List;

import com.fintonic.taskmanager.domain.task.entity.Task;
import com.fintonic.taskmanager.infrastructure.rest.dto.TaskDTO;
import org.mapstruct.Mapper;

@Mapper
public interface TaskDTOMapper {

  Task toTask(TaskDTO taskDTO);

  List<TaskDTO> toTaskDTOList(List<Task> tasks);
}
