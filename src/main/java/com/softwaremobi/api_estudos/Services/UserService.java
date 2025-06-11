package com.softwaremobi.api_estudos.Services;

import com.softwaremobi.api_estudos.DTO.ResponseDTO;
import com.softwaremobi.api_estudos.Models.FlashCardModel;
import com.softwaremobi.api_estudos.Models.TaskModel;
import com.softwaremobi.api_estudos.Models.UserModel;
import com.softwaremobi.api_estudos.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService  {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<ResponseDTO<ArrayList<TaskModel>>> getAllTasksByIdUser(String idUser){
        UserModel userModel = userRepository.findById(idUser).orElse(null);
        ResponseDTO<ArrayList<TaskModel>> response = new ResponseDTO<ArrayList<TaskModel>>(false,"Lista de Tasks retornada com sucesso!!!",userModel.getTaskModels());
        return ResponseEntity.ok(response);
    }
    public ResponseEntity<ResponseDTO<ArrayList<FlashCardModel>>> getAllFlashCardsByIdUser(String idUser){
        UserModel userModel = userRepository.findById(idUser).orElse(null);
        ResponseDTO<ArrayList<FlashCardModel>> response = new ResponseDTO<ArrayList<FlashCardModel>>(false,"Lista de FlashCards retornada com sucesso!!!",userModel.getFlashCardModels());
        return ResponseEntity.ok(response);
    }

}
