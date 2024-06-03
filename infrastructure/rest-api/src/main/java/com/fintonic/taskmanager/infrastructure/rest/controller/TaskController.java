package com.fintonic.taskmanager.infrastructure.rest.controller;

import java.util.List;

import com.fintonic.taskmanager.domain.task.usecase.CreateTaskUseCase;
import com.fintonic.taskmanager.domain.task.usecase.GetAllTaskUseCase;
import com.fintonic.taskmanager.infrastructure.rest.dto.TaskDTO;
import com.fintonic.taskmanager.infrastructure.rest.mapper.TaskDTOMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskController {

  private final GetAllTaskUseCase getAllUseCase;

  private final CreateTaskUseCase createUseCase;

  private final TaskDTOMapper taskDTOMapper;

  @Operation(summary = "Get all tasks")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "List of tasks",
          content = {@Content(mediaType = "application/json",
              schema = @Schema(implementation = TaskDTO.class))}),
      @ApiResponse(responseCode = "500", description = "Internal server error",
          content = @Content)})
  @GetMapping("v1/tasks")
  public ResponseEntity<List<TaskDTO>> getAllTasks() {
    return ResponseEntity.ok(taskDTOMapper.toTaskDTOList(getAllUseCase.getAll()));
  }

  @PostMapping("v1/tasks")
  @Operation(summary = "Get all tasks")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Task created"),
      @ApiResponse(responseCode = "500", description = "Internal server error",
          content = @Content)})
  public ResponseEntity<List<TaskDTO>> createTask(@RequestBody TaskDTO taskDTO) {
    createUseCase.create(taskDTOMapper.toTask(taskDTO));
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
