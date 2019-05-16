package org.onesubhadip.tasklistapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.*;

import org.mockito.BDDMockito;
import org.onesubhadip.tasklistapi.dto.TaskCreationRequest;
import org.onesubhadip.tasklistapi.dto.TaskCreationResponse;
import org.onesubhadip.tasklistapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskListController.class)
public class WhenInvokeAddNewTaskApi {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private TaskService taskService;

    @Test
    public void shouldReturnHttp201statusAlongWithTaskIdInResponse() throws Exception {
        // Arrange
        TaskCreationResponse newTask = TaskCreationResponse.of(1L);
        TaskCreationRequest requestObject = TaskCreationRequest.builder().title("test").description("test desc").build();
        given(taskService.createNewTask(any())).willReturn(newTask);

        // Act
        mvc.perform(post("/task")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(requestObject)))
                .andDo(print())

        // Assert
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.taskId").value(newTask.getTaskId()));

        then(taskService).should(times(1)).createNewTask(any());
    }

}
