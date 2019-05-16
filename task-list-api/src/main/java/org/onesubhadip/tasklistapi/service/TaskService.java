package org.onesubhadip.tasklistapi.service;

import org.onesubhadip.tasklistapi.dto.TaskCreationRequest;
import org.onesubhadip.tasklistapi.dto.TaskCreationResponse;
import org.onesubhadip.tasklistapi.entity.TaskEntity;
import org.onesubhadip.tasklistapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskCreationResponse createNewTask(TaskCreationRequest request) {
        TaskEntity taskEntity = TaskEntity.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .build();
        taskEntity = taskRepository.saveAndFlush(taskEntity);
        return TaskCreationResponse.of(taskEntity.getTaskId());
    }

}
