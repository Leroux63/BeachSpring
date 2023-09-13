package com.hb.dl.demo.controllers;

import com.hb.dl.demo.models.Plage;
import com.hb.dl.demo.services.PlageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/plages")
public class PlageController {

    @Autowired
    private PlageService plageService;

    @RequestMapping("/list")
    public ModelAndView getAll(@RequestParam(required = false)String page){
        if(page == null){
            page = "1";
        }
        int pageNumber = Integer.valueOf(page);
        ModelAndView mv = new ModelAndView("plages/list");
        Page<Plage> plages = this.plageService.paginatePlage(2,pageNumber -1);
        mv.addObject("plages",plages);
        mv.addObject("pageNumber",(String) page);
        return mv;
    }

    @RequestMapping("/{plage}")
    public ModelAndView getOne(@PathVariable Plage plage){
        ModelAndView mv = new ModelAndView("plages/detail");
        mv.addObject("plage",plage);
        return mv;
    }

    @RequestMapping(value="/add",method = RequestMethod.GET)
    public ModelAndView add(){
        Plage plage = new Plage();
        ModelAndView mv = new ModelAndView("plages/form");
        mv.addObject("plage",plage);
        return mv;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String formAdd(@Valid Plage plage, BindingResult bindingResult){
        if (plage == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Plage introuvable"
            );
        }
        if (bindingResult.hasErrors()){
            return "plages/form";
        }else{
            this.plageService.save(plage);
            return "redirect:/plages/list";
        }
    }

    @RequestMapping(value = "/delete/{plage}",method = RequestMethod.GET)
    public String removeOne(@PathVariable Plage plage){
        plageService.remove(plage);
        return "redirect:/plages/list";
    }

    @RequestMapping(value = "/edit/{plage}",method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable(required = false) Plage plage){
        if (plage == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Plage inexistante");
        }
        ModelAndView mv = new ModelAndView("plages/form");
        mv.addObject("plage", plage);
        return mv;

    }
    @RequestMapping(value = "/edit/{plage}",method = RequestMethod.POST)
    public String editSubmit(@Valid Plage plage,BindingResult bindingResult){
        if(plage == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Plage inexistante");
        }
        if(bindingResult.hasErrors()){
            return "plages/form";
        }else{
            this.plageService.save(plage);
            return "redirect:/plages/list";
        }
    }
}
