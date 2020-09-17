package jp.co.foxbit.horikiri.spring.rest.sample.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jp.co.foxbit.horikiri.spring.rest.sample.model.form.InformationForm;
import jp.co.foxbit.horikiri.spring.rest.sample.model.result.InformationResult;

@Service
public class InformationService {

    //  @Autowired
    private final RestTemplate restTemplate;

    private static final String URL_FETCH = "http://localhost:8080/information/api/fetch/%s";
    private static final String URL_FETCH_ALL = "http://localhost:8080/information/api/fetch/all";
    private static final String URL_CREATE = "http://localhost:8080/information/api/create";
    private static final String URL_UPDATE = "http://localhost:8080/information/api/update";
    private static final String URL_DELETE = "http://localhost:8080/information/api/delete/{userID}";

    public InformationService(RestTemplateBuilder restTemplateBuilder) {
 
        restTemplate = restTemplateBuilder.build();
    }

    public List<InformationResult> fetchAllInformationByRest() {

        return Arrays.asList(restTemplate.getForObject(URL_FETCH_ALL, InformationResult[].class));
    }

    public InformationResult fetchInformationByRest(String userID) {

        return restTemplate.getForObject(String.format(URL_FETCH, userID), InformationResult.class);
    }

    public void createInformationByRest(InformationForm informationForm) {


        informationForm.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        informationForm.setModifiedAt(informationForm.getCreatedAt());
        informationForm.setValidUser(true);

        restTemplate.postForObject(URL_CREATE, informationForm, InformationResult.class);
    }

    public void updateInformationByRest(InformationForm informationForm) {

        var informationResult = restTemplate.getForObject(String.format(URL_FETCH, informationForm.getUserID()), InformationResult.class);

        informationForm.setCreatedAt(informationResult.getCreatedAt());
        informationForm.setModifiedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        restTemplate.put(URL_UPDATE, informationForm);
    }

    public void deleteInformationByRest(String userID) {

        restTemplate.delete(URL_DELETE, userID);
    }
}