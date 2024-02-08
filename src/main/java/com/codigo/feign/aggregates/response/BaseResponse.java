package com.codigo.feign.aggregates.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;


@Getter
@Setter
public class BaseResponse {
    private Integer code;
    private String messege;
    private boolean status;
    private Optional data;
}
