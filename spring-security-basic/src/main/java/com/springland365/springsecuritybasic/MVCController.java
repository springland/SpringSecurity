package com.springland365.springsecuritybasic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MVCController {

    @RequestMapping("/read")
    public String readPage()
    {
        return "read.html";
    }

    @RequestMapping("/write")
    public String writePage()
    {
        return "write.html";
    }

    @RequestMapping("/manager")
    public String managerPage()
    {
        return "manager.html";
    }

}
