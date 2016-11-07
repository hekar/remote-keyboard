package com.hekar.remote;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mobile")
public class MobileController {

    @GetMapping("/main")
    @ResponseBody
    public ModelAndView index() {
        return new ModelAndView("mobile/main");
    }

    @GetMapping("/keys")
    @ResponseBody
    public ModelAndView keys() {
        return new ModelAndView("mobile/keys");
    }


}
