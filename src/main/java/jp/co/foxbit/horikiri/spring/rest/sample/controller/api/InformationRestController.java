package jp.co.foxbit.horikiri.spring.rest.sample.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.foxbit.horikiri.spring.rest.sample.model.form.InformationForm;
import jp.co.foxbit.horikiri.spring.rest.sample.model.result.InformationResult;
import jp.co.foxbit.horikiri.spring.rest.sample.service.api.InformationRestService;

@RestController
public class InformationRestController {

//    @Autowired
//    InformationService informationRestService;
    private final InformationRestService informationRestService;

    public InformationRestController(InformationRestService informationRestService) {

        this.informationRestService = informationRestService;
    }

    @RequestMapping(value = "/information/api/fetch/all", method = RequestMethod.GET)
    public List<InformationResult> fetchAllInformation() {

        return informationRestService.fetchAllInformation();
    }

    @RequestMapping(value = "/information/api/fetch/{userID}", method = RequestMethod.GET)
    public InformationResult fetchTopInformation(@PathVariable String userID) {

        return informationRestService.fetchInformation(userID);
    }

    @RequestMapping(value = "/information/api/create", method = RequestMethod.POST)
    public InformationResult createInformation(@RequestBody InformationForm informationForm) {

        return informationRestService.createInformation(informationForm);
    }

    @RequestMapping(value = "/information/api/update", method = RequestMethod.PUT)
    public InformationResult updateInformation(@RequestBody InformationForm informationForm) {

        return informationRestService.createInformation(informationForm);
    }

    @RequestMapping(value = "/information/api/delete/{userID}", method = RequestMethod.DELETE)
    public void deleteInformation(@PathVariable String userID) {

        informationRestService.deleteInformation(userID);
    }
}
