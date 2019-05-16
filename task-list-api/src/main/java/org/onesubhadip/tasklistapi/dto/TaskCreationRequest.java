package org.onesubhadip.tasklistapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskCreationRequest {

    private String title;
    private String description;

}
