package com.example.ResapoSpring.ResponseBase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
public class ResponseBase {
    private Integer codigo;
    private String msm;
    private boolean estado;
    private Optional data;
}
