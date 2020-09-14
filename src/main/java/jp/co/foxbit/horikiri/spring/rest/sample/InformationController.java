package jp.co.foxbit.horikiri.spring.rest.sample;

import java.util.Arrays;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import jp.co.foxbit.horikiri.spring.rest.sample.model.result.InformationResult;

@Controller
public class InformationController {

//    @Autowired
    private final RestTemplate restTemplate;

    private static final String URL_TOP = "http://localhost:8080/information/api/fetch/top";
    private static final String URL_ALL = "http://localhost:8080/information/api/fetch/all";

    public InformationController(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.build();
    }
    
    @RequestMapping(value = "/information/fetch/top", method = RequestMethod.GET)
    public String fetchTopInformation(Model model) {

        model.addAttribute("informationResult", restTemplate.getForObject(URL_TOP, InformationResult.class));
        return "information/fetch_top_information";
    }

    @RequestMapping(value = "/information/fetch/all", method = RequestMethod.GET)
    public String fetchAllInformation(Model model) {

        var test1 = Arrays.asList(restTemplate.getForObject(URL_ALL, InformationResult[].class));
        model.addAttribute("informationResultList", test1);
        return "information/fetch_all_information";
    }
}
