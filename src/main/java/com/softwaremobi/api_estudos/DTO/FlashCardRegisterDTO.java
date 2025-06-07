package com.softwaremobi.api_estudos.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FlashCardRegisterDTO {
    @NotBlank
    private String question;
    @NotBlank
    private String response;
}
