package com.fintonic.taskmanager.domain.task.entity;

import java.util.Date;
import java.util.List;

public record Task(String title, String description, Date expirationDate, List<Label> labels) {

}
