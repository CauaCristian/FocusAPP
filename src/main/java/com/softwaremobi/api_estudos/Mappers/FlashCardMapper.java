package com.softwaremobi.api_estudos.Mappers;

import com.softwaremobi.api_estudos.DTO.FlashCardRegisterDTO;
import com.softwaremobi.api_estudos.Models.FlashCardModel;
import org.springframework.stereotype.Service;

@Service
public class FlashCardMapper {
    public FlashCardModel toModel(FlashCardRegisterDTO dto){
        FlashCardModel flashCardModel = new FlashCardModel();
        flashCardModel.setResponse(dto.getResponse());
        flashCardModel.setQuestion(dto.getQuestion());
        return flashCardModel;
    };
    public FlashCardRegisterDTO toDTO(FlashCardModel dto){
        FlashCardRegisterDTO flashCardRegisterDTO = new FlashCardRegisterDTO();
        flashCardRegisterDTO.setResponse(dto.getResponse());
        flashCardRegisterDTO.setQuestion(dto.getQuestion());
        return flashCardRegisterDTO;
    };
}
