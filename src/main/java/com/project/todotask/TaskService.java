package com.project.todotask;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskModel> GetTasks() {
        return taskRepository.findAll();
    }

    public TaskModel CreateNewTask(TaskModel taskModel) {
        return taskRepository.save(taskModel);
    }

    public TaskModel getTaskById(long id){
        Optional<TaskModel> optionalTaskModel= taskRepository.findById(id);
        TaskModel taskModel=null;
        if(optionalTaskModel.isPresent()){
            taskModel=optionalTaskModel.get();
        }
        else {
            throw new RuntimeException("Task Not Found for Id::"+id);
        }
        return taskModel;
    }

    public void UpdateATask(TaskModel taskModel) {
        taskRepository.save(taskModel);
    }


    public void deleteTaskById(long id) {
        taskRepository.deleteById(id);
    }
}
