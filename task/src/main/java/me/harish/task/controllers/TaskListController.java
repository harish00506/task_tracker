package me.harish.task.controllers;

import jakarta.persistence.GeneratedValue;
import me.harish.task.domain.dto.TaskDto;
import me.harish.task.domain.dto.TaskListDto;
import me.harish.task.mappers.TaskListMapper;
import me.harish.task.services.TaskListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/task-lists")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }


    @GetMapping
    public List<TaskListDto> listTaskLists(){
       return taskListService.listTaskLists()
                .stream()
                .map(taskListMapper::toDto )
                .toList();
    }

}
//1:29:08
//TODO :1:29:08
