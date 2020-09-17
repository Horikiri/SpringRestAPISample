package jp.co.foxbit.horikiri.spring.rest.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.foxbit.horikiri.spring.rest.sample.model.form.InformationForm;
import jp.co.foxbit.horikiri.spring.rest.sample.service.InformationService;

@Controller
public class InformationController {

//  @Autowired
//  InformationService informationService;
    private final InformationService informationService;

    public InformationController(InformationService informationService) {

        this.informationService = informationService;
    }

    // cURLサンプル：curl -v  http://localhost:8080/information/fetch/all
    @RequestMapping(value = "/information/fetch/all", method = RequestMethod.GET)
    public String fetchAllInformation(Model model) {

        model.addAttribute("informationResultList", informationService.fetchAllInformationByRest());

        return "information/fetch_all_information";
    }

    // cURLサンプル：curl -v  http://localhost:8080/information/fetch/a@foxbit.co.jp
    @RequestMapping(value = "/information/fetch/{userID}", method = RequestMethod.GET)
    public String fetchInformation(@PathVariable String userID, Model model) {

        model.addAttribute("informationResult", informationService.fetchInformationByRest(userID));

        return "information/fetch_information";
    }

    @RequestMapping(value = "/information/create/form", method = RequestMethod.GET)
    public String createInformation(Model model) {

        model.addAttribute("informationForm", new InformationForm());

        return "information/create_information";
    }

    @RequestMapping(value = "/information/create", method = RequestMethod.POST)
    public String createInformation(@ModelAttribute InformationForm informationForm, Model model) {

        informationService.createInformationByRest(informationForm);

        return "redirect:/information/fetch/all";
    }

    @RequestMapping(value = "/information/update/form/{userID}", method = RequestMethod.GET)
    public String updateInformation(@PathVariable String userID, Model model) {

        model.addAttribute("informationForm", new InformationForm(informationService.fetchInformationByRest(userID)));

        return "information/update_information";
    }

    @RequestMapping(value = "/information/update", method = RequestMethod.PUT)
    public String updateInformationRest(@ModelAttribute InformationForm informationForm, Model model) {

        informationService.updateInformationByRest(informationForm);

        return "redirect:/information/fetch/all";
    }

    @RequestMapping(value = "/information/delete/form/{userID}", method = RequestMethod.GET)
    public String deleteInformation(@PathVariable String userID, Model model) {

        model.addAttribute("informationForm", new InformationForm(informationService.fetchInformationByRest(userID)));

        return "information/delete_information";
    }

    @RequestMapping(value = "/information/delete/{userID}", method = RequestMethod.DELETE)
    public String deleteInformation(@PathVariable String userID) {

        informationService.deleteInformationByRest(userID);

        return "redirect:/information/fetch/all";
    }
}