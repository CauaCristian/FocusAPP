package com.softwaremobi.api_estudos.Services;

import com.softwaremobi.api_estudos.DTO.ResponseDTO;
import com.softwaremobi.api_estudos.DTO.TaskRegisterDTO;
import com.softwaremobi.api_estudos.Mappers.TaskMapper;
import com.softwaremobi.api_estudos.Models.TaskModel;
import com.softwaremobi.api_estudos.Models.UserModel;
import com.softwaremobi.api_estudos.Repositories.TaskRepository;
import com.softwaremobi.api_estudos.Repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TaskService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskMapper taskMapper;

    public ResponseEntity register(TaskRegisterDTO taskRegisterDTO,String idUser){
        UserModel userModel = userRepository.findById(idUser).orElse(null);
        TaskModel taskModel = taskMapper.toModel(taskRegisterDTO);
        taskRepository.save(taskModel);
        userModel.addTask(taskModel);
        userRepository.save(userModel);
        ResponseDTO responseDTO = new ResponseDTO(false,"Task adicionada com sucesso!!!",userModel.getTaskModels());
        return ResponseEntity.ok(responseDTO);
    }
    public ResponseEntity update(TaskModel taskModel){
        taskRepository.save(taskModel);
        ResponseDTO responseDTO = new ResponseDTO(false,"Task editada com sucesso!!!",taskModel);
        return ResponseEntity.ok(responseDTO);
    }
}
