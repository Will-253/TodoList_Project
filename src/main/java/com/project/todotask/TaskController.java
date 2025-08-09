package com.project.todotask;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController{

    private TaskService taskService;

    public  TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String getAllTasks(Model model) {

        List<TaskModel> allTasks = taskService.GetTasks();

        model.addAttribute("allTasks", allTasks);

        return "tasks";
    }

    @GetMapping("/newtaskform")
    public String newtaskform(Model model){
        TaskModel taskModel= new TaskModel();
        model.addAttribute("taskModel",taskModel);

        return "newtask";
    }

    @PostMapping("/saveNewTask")
    public String saveNewTask(@ModelAttribute("taskModel") TaskModel taskModel){
        //Save New Task to Database
        taskService.CreateNewTask(taskModel);
        return "redirect:/tasks";
    }

    @GetMapping("/updatetaskform/{id}")
    public String updatetaskform(@PathVariable(value = "id") long id,Model model){

        //get the task from the service
        TaskModel taskModel=taskService.getTaskById(id);
        //set Task as a model
        model.addAttribute("taskModel",taskModel);

        return "updatetask";
    }
    @PostMapping("/updateMyTask")
    public String updateTask(@ModelAttribute("taskModel") TaskModel taskModel, Model model){

        taskService.UpdateATask(taskModel);

        model.addAttribute("taskModel",taskModel);

        return "redirect:/tasks";
    }

    @GetMapping("/deletetask/{id}")
    public String deletetask(@PathVariable(value = "id")long id){
        //call delete task method
        taskService.deleteTaskById(id);

        return "redirect:/tasks";
    }

    @GetMapping("/viewATask/{id}")
    public String viewtask(@PathVariable(value = "id")long id, Model model){

        TaskModel taskModel=taskService.getTaskById(id);

        model.addAttribute("taskModel",taskModel);

        return "gettask";
    }

    @GetMapping("/viewatask")
    public String viewatask(@PathVariable(value = "id")long id, Model model){

        TaskModel taskModel= taskService.getTaskById(id);

        model.addAttribute("taskModel",taskModel);

        return "redirect:/tasks";
    }

}
