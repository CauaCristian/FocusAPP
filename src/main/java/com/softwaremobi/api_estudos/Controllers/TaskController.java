package com.softwaremobi.api_estudos.Controllers;

import com.softwaremobi.api_estudos.DTO.ResponseDTO;
import com.softwaremobi.api_estudos.DTO.TaskRegisterDTO;
import com.softwaremobi.api_estudos.Models.TaskModel;
import com.softwaremobi.api_estudos.Services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping(value = "/register/{idUser}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<ArrayList<TaskModel>>> register(@RequestBody @Valid TaskRegisterDTO taskRegisterDTO, @PathVariable String idUser){
        return taskService.register(taskRegisterDTO,idUser);
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<TaskModel>> update(@RequestBody @Valid TaskModel taskModel){
        return taskService.update(taskModel);
    }

}
