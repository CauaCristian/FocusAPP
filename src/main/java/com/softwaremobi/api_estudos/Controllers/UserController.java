package com.softwaremobi.api_estudos.Controllers;

import com.softwaremobi.api_estudos.DTO.ResponseDTO;
import com.softwaremobi.api_estudos.Models.FlashCardModel;
import com.softwaremobi.api_estudos.Models.TaskModel;
import com.softwaremobi.api_estudos.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/getAllTasksByIdUser/{idUser}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<ArrayList<TaskModel>>> getAllTasksByIdUser(@PathVariable String idUser){
        return userService.getAllTasksByIdUser(idUser);
    }
    @GetMapping(value = "/getAllFlashCardsByIdUser/{idUser}")
    public ResponseEntity<ResponseDTO<ArrayList<FlashCardModel>>> getAllFlashCardsByIdUser(@PathVariable String idUser){
        return userService.getAllFlashCardsByIdUser(idUser);
    }
}
