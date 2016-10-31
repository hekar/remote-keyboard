package com.hekar.remote

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/move/mouse")
class MouseController {

    @Autowired
    lateinit var mouseService: MouseService

    @GetMapping("{x}/{y}")
    @ResponseBody
    fun moveMouse(@PathVariable("x") x: String, @PathVariable("y") y: String): String {
        return this.mouseService.move(Integer.parseInt(x), Integer.parseInt(y))
    }


    @GetMapping("scroll/{x}/{y}")
    @ResponseBody
    fun wheelMouse(@PathVariable("x") x: String, @PathVariable("y") y: String): String {
        return this.mouseService.scroll(Integer.parseInt(y))
    }

    @GetMapping("click")
    @ResponseBody
    fun clickMouse(): String {
        return this.mouseService.click()
    }

}
