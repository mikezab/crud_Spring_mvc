package my.groupid.controller;


import jdk.management.resource.internal.inst.InitInstrumentation;
import my.groupid.models.SevenEleven;
import my.groupid.models.SevenElevenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.crypto.dsig.Manifest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * Created by JPMC-B2-PC010 on 29/06/2017.
 */
@Controller
public class SEController {

    private SevenElevenRepository sevenElevenRepository;

    @Autowired
    public SEController(SevenElevenRepository sevenElevenRepository) {
        this.sevenElevenRepository = sevenElevenRepository;
    }

    @RequestMapping(value = "/seveneleven", method = RequestMethod.GET)
    public String loadSE() {
        return "seveneleven/index";
    } //loadhtml target

    //Welcomes the new registered member
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveSevenElevenInput(@ModelAttribute @Valid SevenEleven seveneleven,
                                             ModelAndView modelAndView,
                                             HttpServletResponse response,
                                             BindingResult bindingResult) {
        sevenElevenRepository.save(seveneleven);
        modelAndView.setViewName("seveneleven/thankyou"); //fin html
        modelAndView.addObject("users", sevenElevenRepository.findOne(seveneleven.getId()));
        return modelAndView;
    }

    //Displays All registered members
    @RequestMapping(value = "/premium", method = RequestMethod.GET)
    public ModelAndView saveSevenElevenInput(ModelAndView modelAndView) {
        modelAndView.setViewName("seveneleven/goldmembers"); //fin html
        modelAndView.addObject("users", sevenElevenRepository.findAll());
        return modelAndView;
    }

    //views the current record of the user
    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public ModelAndView saveSevenElevenInput(SevenEleven seveneleven, ModelAndView modelAndView, @PathVariable Long id) {
        modelAndView.setViewName("seveneleven/view");
        modelAndView.addObject("users", sevenElevenRepository.findOne(id));
        return modelAndView;
    }

    //deletes user's record
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String saveSevenElevenInput(SevenEleven seveneleven, ModelAndView modelAndView, @PathVariable Long id,
                                             BindingResult result) {
        sevenElevenRepository.delete(id);
        return "redirect:/premium";
    }

    //updates user record
    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String saveSevenElevenInput(ModelAndView modelAndView,SevenEleven seveneleven, @PathVariable Long id,
                                       @RequestParam String name,
                                       @RequestParam String email,
                                       @RequestParam String month,
                                       @RequestParam String day,
                                       @RequestParam String year,
                                       @RequestParam Boolean box,
                                       BindingResult result) {
        seveneleven = sevenElevenRepository.findOne(id);
            seveneleven.setName(name);
            seveneleven.setEmail(email);
            seveneleven.setMonth(month);
            seveneleven.setDay(day);
            seveneleven.setYear(year);
            seveneleven.setBox(box);

        sevenElevenRepository.save(seveneleven);

        return "redirect:/view";
    }
}

