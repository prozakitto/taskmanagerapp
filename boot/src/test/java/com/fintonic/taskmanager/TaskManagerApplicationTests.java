package com.fintonic.taskmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import com.fintonic.taskmanager.infrastructure.rest.dto.LabelDTO;
import com.fintonic.taskmanager.infrastructure.rest.dto.TaskDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskManagerApplicationTests {

  private static final String BASE_PATH = "/v1/tasks";

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  @DisplayName("Create task should be OK and return 201")
  void createTaskShouldBeOK() {
    TaskDTO taskDTO = new TaskDTO("Hire employee", "Hire a new employee for the company", new Date(), List.of(new LabelDTO("Pending")));
    RequestEntity<TaskDTO> requestEntity = RequestEntity.post(BASE_PATH).body(taskDTO);
    ResponseEntity<Void> response = this.restTemplate.exchange(BASE_PATH, HttpMethod.POST, requestEntity, Void.class);
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
  }

  @Test
  @DisplayName("Get task list should be OK and return 200")
  void getTaskShouldBeOK() {
    TaskDTO taskDTO = new TaskDTO("Hire employee", "Hire a new employee for the company", new Date(), List.of(new LabelDTO("Pending")));
    RequestEntity<TaskDTO> requestEntity = RequestEntity.post(BASE_PATH).body(taskDTO);
    ResponseEntity<List<TaskDTO>> response =
        this.restTemplate.exchange(BASE_PATH, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<>() {
        });
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertTrue(response.getBody().stream().filter(task -> task.title().equals("Hire employee")).findFirst().isPresent());
  }


}
