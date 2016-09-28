package com.hekar.remote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/move/mouse")
public class MouseController {

    @Autowired
    private MouseService mouseService;

    @GetMapping("{x}/{y}")
    @ResponseBody
    public String moveMouse(@PathVariable("x") String x, @PathVariable("y") String y) {
        return this.mouseService.move(Integer.parseInt(x), Integer.parseInt(y));
    }


    @GetMapping("scroll/{x}/{y}")
    @ResponseBody
    public String wheelMouse(@PathVariable("x") String x, @PathVariable("y") String y) {
        return this.mouseService.scroll(Integer.parseInt(y));
    }

    @GetMapping("click")
    @ResponseBody
    public String clickMouse() {
        return this.mouseService.click();
    }

}
