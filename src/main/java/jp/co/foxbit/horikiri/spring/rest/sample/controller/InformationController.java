package jp.co.foxbit.horikiri.spring.rest.sample.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import jp.co.foxbit.horikiri.spring.rest.sample.model.form.InformationForm;
import jp.co.foxbit.horikiri.spring.rest.sample.model.result.InformationResult;

@Controller
public class InformationController {

//    @Autowired
    private final RestTemplate restTemplate;

    private static final String URL_FETCH = "http://localhost:8080/information/api/fetch/%s";
    private static final String URL_FETCH_ALL = "http://localhost:8080/information/api/fetch/all";
    private static final String URL_CREATE = "http://localhost:8080/information/api/create";

    public InformationController(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.build();
    }

    @RequestMapping(value = "/information/fetch/all", method = RequestMethod.GET)
    public String fetchAllInformation(Model model) {

        model.addAttribute("informationResultList", Arrays.asList(restTemplate.getForObject(URL_FETCH_ALL, InformationResult[].class)));
        return "information/fetch_all_information";
    }

    @RequestMapping(value = "/information/fetch/{userID}", method = RequestMethod.GET)
    public String fetchTopInformation(@PathVariable String userID, Model model) {

        model.addAttribute("informationResult", restTemplate.getForObject(String.format(URL_FETCH, userID), InformationResult.class));
        return "information/fetch_top_information";
    }

    // cURLÉTÉìÉvÉãÅFcurl -X POST http://localhost:8080/information/create/e@foxbit.co.jp/ee/e
    @RequestMapping(value = "/information/create/{userID}/{firstName}/{lastName}", method = RequestMethod.POST)
    public String createInformation(@PathVariable String userID, @PathVariable String firstName, @PathVariable String lastName, Model model) {

        var informationForm = new InformationForm(userID, firstName, lastName,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), true);

        restTemplate.postForObject(URL_CREATE, informationForm, InformationResult.class);
        model.addAttribute("informationResultList", Arrays.asList(restTemplate.getForObject(URL_FETCH_ALL, InformationResult[].class)));

        return "information/fetch_all_information";
    }
}
