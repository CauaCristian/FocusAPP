package com.softwaremobi.api_estudos.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponseDTO<Type> {
    private Boolean error;
    private String message;
    private Type data;
}
