package jp.co.foxbit.horikiri.spring.rest.sample.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.foxbit.horikiri.spring.rest.sample.model.form.InformationForm;
import jp.co.foxbit.horikiri.spring.rest.sample.model.result.InformationResult;
import jp.co.foxbit.horikiri.spring.rest.sample.service.InformationService;

@RestController
public class InformationRestController {

//    @Autowired
//    InformationService informationService;
    private final InformationService informationService;

    public InformationRestController(InformationService informationService) {

        this.informationService = informationService;
    }

    @RequestMapping(value = "/information/api/fetch/all", method = RequestMethod.GET)
    public List<InformationResult> fetchAllInformation() {

        return informationService.fetchAllInformation();
    }

    @RequestMapping(value = "/information/api/fetch/{userID}", method = RequestMethod.GET)
    public InformationResult fetchTopInformation(@PathVariable String userID) {

        return informationService.fetchInformation(userID);
    }

    @RequestMapping(value = "/information/api/create", method = RequestMethod.POST)
    public void createInformation(@RequestBody InformationForm informationForm) {

        informationService.createInformation(informationForm);
    }
}
