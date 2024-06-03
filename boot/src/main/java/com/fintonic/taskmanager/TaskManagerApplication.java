package com.fintonic.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.fintonic.taskmanager.infrastructure.mongo.task.repository")
public class TaskManagerApplication {

  public static void main(final String[] args) {
    SpringApplication.run(TaskManagerApplication.class, args);
  }

}
