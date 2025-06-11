package com.softwaremobi.api_estudos.DTO;

import com.softwaremobi.api_estudos.Models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponseLoginDTO {
    private Boolean error;
    private String message;
    private String Token;
    private UserModel data;
}
