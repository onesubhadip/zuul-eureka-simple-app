package org.onesubhadip.tasklistapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor(staticName = "of")
public class TaskCreationResponse {

    private Long taskId;

}
