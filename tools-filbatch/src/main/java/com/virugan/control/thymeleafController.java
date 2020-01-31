package com.virugan.control;

import com.virugan.api.localDataCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class thymeleafController {
    @Autowired
    localDataCache localdatacache;


    @RequestMapping(value="webFlbh/batchHandleHtml" )
    public String batchHandleHtml(Model model){
        String pathName = localdatacache.getPathByName("scan-batch-folder");
        model.addAttribute("staPath",pathName);
        model.addAttribute("endPath",localdatacache.getPathByName("move-batch-folder"));
        model.addAttribute("filpath",pathName);
        return "webFlbh/batch-handle";
    }
}
