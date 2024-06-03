package com.fintonic.taskmanager.infrastructure.mongo.task.document;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public record TaskDocument(String title, String description, Date expirationDate, List<LabelDocument> labels) {

}
