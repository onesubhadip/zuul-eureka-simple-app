package org.onesubhadip.tasklistapi.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.onesubhadip.tasklistapi.dto.TaskCreationRequest;
import org.onesubhadip.tasklistapi.dto.TaskCreationResponse;
import org.onesubhadip.tasklistapi.entity.TaskEntity;
import org.onesubhadip.tasklistapi.repository.TaskRepository;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class WhenTryToCreateNewTask {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void shouldCreateAndReturnNewTask() {
        Long taskId = 1L;
        TaskCreationRequest input = TaskCreationRequest.builder().title("test").description("test desc").build();
        BDDMockito.given(taskRepository.saveAndFlush(Mockito.any())).willAnswer((invocation) -> {
            TaskEntity arg = invocation.getArgument(0);
            arg.setTaskId(taskId);
            return arg;
        });

        TaskCreationResponse result = taskService.createNewTask(input);

        assertThat(result).isNotNull();
        assertThat(result.getTaskId()).isEqualTo(taskId);
    }

}
