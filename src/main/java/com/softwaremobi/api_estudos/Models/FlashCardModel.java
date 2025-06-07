package com.softwaremobi.api_estudos.Models;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FlashCards")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class FlashCardModel {
    @Id
    private String id;
    @NotBlank
    private String question;
    @NotBlank
    private String response;
}
