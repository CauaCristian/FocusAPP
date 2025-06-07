package com.softwaremobi.api_estudos.Services;

import com.softwaremobi.api_estudos.DTO.ResponseDTO;
import com.softwaremobi.api_estudos.Models.UserModel;
import com.softwaremobi.api_estudos.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity getAllTasksByIdUser(String idUser){
        UserModel userModel = userRepository.findById(idUser).orElse(null);
        ResponseDTO response = new ResponseDTO(false,"Lista de Tasks retornada com sucesso!!!",userModel.getTaskModels());
        return ResponseEntity.ok(response);
    }
    public ResponseEntity getAllFlashCardsByIdUser(String idUser){
        UserModel userModel = userRepository.findById(idUser).orElse(null);
        ResponseDTO response = new ResponseDTO(false,"Lista de FlashCards retornada com sucesso!!!",userModel.getFlashCardModels());
        return ResponseEntity.ok(response);
    }
}
