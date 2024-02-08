package com.codigo.feign.aggregates.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    private Integer code;
    private String messege;
    private Optional data;



}
