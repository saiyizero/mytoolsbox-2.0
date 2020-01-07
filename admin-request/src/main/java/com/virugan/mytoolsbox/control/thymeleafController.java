package com.virugan.mytoolsbox.control;

import com.virugan.mytoolsbox.dao.publicDao;
import com.virugan.mytoolsbox.entry.myAccountAnalys;
import com.virugan.mytoolsbox.service.accountServ;
import com.virugan.mytoolsbox.service.fileBatchServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class thymeleafController {
    @Autowired
    accountServ accountserv;
    @Autowired
    publicDao publicdao;

    @RequestMapping(value="/mappingToAnalysis" )
    public String mappingToAnalysis(Model model){

        myAccountAnalys myAccountAnalys = accountserv.mappingToAnalysis();
        model.addAttribute("analysData",myAccountAnalys);
        String tranDate = myAccountAnalys.getTranDate();
        String[] split = tranDate.split("-");
        model.addAttribute("showMonth",split[1]);

        return "account-analysis";
    }

    @RequestMapping(value="/batchHandleHtml" )
    public String batchHandleHtml(Model model){
        String pathName = publicdao.getPathByName("scan-batch-folder");
        model.addAttribute("staPath",pathName);
        model.addAttribute("endPath",publicdao.getPathByName("move-batch-folder"));
        model.addAttribute("filpath",pathName);
        return "batch-handle";
    }
}
