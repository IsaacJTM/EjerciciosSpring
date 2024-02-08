package com.example.ResapoSpring.Controller;

import com.example.ResapoSpring.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LibroController {

    @Autowired
    private LibroService libroService;


}
