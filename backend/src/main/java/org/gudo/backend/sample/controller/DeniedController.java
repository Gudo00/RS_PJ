package org.gudo.backend.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accessDenied")
public class DeniedController {

    @RequestMapping("")
    public String denied(){
        return "accessDenied";
    }
}

