package com.fintonic.taskmanager.infrastructure.mongo.task.repository;

import com.fintonic.taskmanager.infrastructure.mongo.task.document.TaskDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskMongoRepository extends MongoRepository<TaskDocument, String> {

}
