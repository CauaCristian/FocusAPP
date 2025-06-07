package com.softwaremobi.api_estudos.Mappers;

import com.softwaremobi.api_estudos.DTO.TaskRegisterDTO;
import com.softwaremobi.api_estudos.Models.TaskModel;
import org.springframework.stereotype.Service;

@Service
public class TaskMapper {
    public TaskModel toModel(TaskRegisterDTO dto){
        TaskModel taskModel = new TaskModel();
        taskModel.setTitle(dto.getTitle());
        taskModel.setDescription(dto.getDescription());
        taskModel.setDate(dto.getDate());
        return taskModel;
    };
    public TaskRegisterDTO toDTO(TaskModel model){
        TaskRegisterDTO taskDTO = new TaskRegisterDTO();
        taskDTO.setTitle(model.getTitle());
        taskDTO.setDescription(model.getDescription());
        taskDTO.setDate(model.getDate());
        return taskDTO;
    };
}
