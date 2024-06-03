package com.fintonic.taskmanager.infrastructure.rest.dto;

import java.util.Date;
import java.util.List;

public record TaskDTO(String title, String description, Date expirationDate, List<LabelDTO> labels) {

}
