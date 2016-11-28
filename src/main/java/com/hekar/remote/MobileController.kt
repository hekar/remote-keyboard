package com.hekar.remote

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/mobile")
class MobileController {

    @GetMapping("/main")
    @ResponseBody
    fun index(): ModelAndView {
        return ModelAndView("mobile/main")
    }

    @GetMapping("/keys")
    @ResponseBody
    fun keys(): ModelAndView {
        return ModelAndView("mobile/keys")
    }
}
