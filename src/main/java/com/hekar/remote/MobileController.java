package com.hekar.remote;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mobile/main")
public class MobileController {

    @GetMapping("/")
    @ResponseBody
    public ModelAndView index() {
        return new ModelAndView("mobile/main");
    }

}
