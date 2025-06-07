package com.softwaremobi.api_estudos.Mappers;

import com.softwaremobi.api_estudos.DTO.UserRegisterDTO;
import com.softwaremobi.api_estudos.Models.UserModel;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserModel toModel(UserRegisterDTO dto){
        UserModel userModel = new UserModel();
        userModel.setUsername(dto.getUsername());
        userModel.setPassword(dto.getPassword());
        return userModel;
    };
    public UserRegisterDTO toDTO(UserModel model){
        UserRegisterDTO userDTO = new UserRegisterDTO();
        userDTO.setUsername(model.getUsername());
        userDTO.setPassword(model.getPassword());
        return userDTO;
    };
}
