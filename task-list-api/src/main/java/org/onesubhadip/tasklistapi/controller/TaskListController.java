package org.onesubhadip.tasklistapi.controller;

import org.onesubhadip.tasklistapi.dto.TaskCreationRequest;
import org.onesubhadip.tasklistapi.dto.TaskCreationResponse;
import org.onesubhadip.tasklistapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskListController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/task")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskCreationResponse createNewTask(@RequestBody TaskCreationRequest request) {

        return taskService.createNewTask(request);
    }
}
