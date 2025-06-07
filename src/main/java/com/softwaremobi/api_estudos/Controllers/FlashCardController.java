package com.softwaremobi.api_estudos.Controllers;

import com.softwaremobi.api_estudos.DTO.FlashCardRegisterDTO;
import com.softwaremobi.api_estudos.DTO.UserRegisterDTO;
import com.softwaremobi.api_estudos.Models.FlashCardModel;
import com.softwaremobi.api_estudos.Services.FlashCardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flashcard")
public class FlashCardController {
    @Autowired
    private FlashCardService flashCardService;

    @PostMapping(value = "/register/{idUser}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody @Valid FlashCardRegisterDTO flashCardRegisterDTO, @PathVariable String idUser){
        return flashCardService.register(flashCardRegisterDTO,idUser);
    }
    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody @Valid FlashCardModel flashCardModel){
        return flashCardService.update(flashCardModel);
    }
}
