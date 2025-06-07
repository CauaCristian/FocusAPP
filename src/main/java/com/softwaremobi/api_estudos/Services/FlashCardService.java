package com.softwaremobi.api_estudos.Services;

import com.softwaremobi.api_estudos.DTO.FlashCardRegisterDTO;
import com.softwaremobi.api_estudos.DTO.ResponseDTO;
import com.softwaremobi.api_estudos.Mappers.FlashCardMapper;
import com.softwaremobi.api_estudos.Models.FlashCardModel;
import com.softwaremobi.api_estudos.Models.UserModel;
import com.softwaremobi.api_estudos.Repositories.FlashCardRepository;
import com.softwaremobi.api_estudos.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FlashCardService {
    @Autowired
    private FlashCardRepository flashCardRepository;
    @Autowired
    private FlashCardMapper flashCardMapper;
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity register(FlashCardRegisterDTO flashCardRegisterDTO,String idUser) {
        UserModel user = userRepository.findById(idUser).orElse(null);
        FlashCardModel  flashCardModel = flashCardMapper.toModel(flashCardRegisterDTO);
        flashCardRepository.save(flashCardModel);
        user.addFlashCard(flashCardModel);
        userRepository.save(user);
        ResponseDTO responseDTO = new ResponseDTO(false,"FlashCard adicionado com sucesso!!!",user.getFlashCardModels());
        return ResponseEntity.ok(responseDTO);
    }
    public ResponseEntity update(FlashCardModel flashCardModel) {
        flashCardRepository.save(flashCardModel);
        ResponseDTO responseDTO = new ResponseDTO(false,"FlashCard editado com sucesso!!!",flashCardModel);
        return ResponseEntity.ok(responseDTO);
    }
}
