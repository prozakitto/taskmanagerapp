package com.fintonic.taskmanager.infrastructure.mongo.task.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "labels")
public record LabelDocument(String title) {

}
