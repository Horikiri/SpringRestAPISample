package jp.co.foxbit.horikiri.spring.rest.sample.service.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.foxbit.horikiri.spring.rest.sample.model.db.InformationModel;
import jp.co.foxbit.horikiri.spring.rest.sample.model.form.InformationForm;
import jp.co.foxbit.horikiri.spring.rest.sample.model.result.InformationResult;

@Service
public class InformationRestService {

    private Map<String, InformationModel> informationModels = new HashMap<String, InformationModel>();

    public InformationRestService() {

        informationModels.put("a@foxbit.co.jp", new InformationModel("a@foxbit.co.jp", "AA", "A",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), true));
        informationModels.put("b@foxbit.co.jp", new InformationModel("b@foxbit.co.jp", "BB", "B",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), true));
        informationModels.put("c@foxbit.co.jp", new InformationModel("c@foxbit.co.jp", "CC", "C",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), true));
    }

    public List<InformationResult> fetchAllInformation() {

        return informationModels.entrySet().stream()
                .map(i -> new InformationResult(i.getValue()))
                .collect(Collectors.toList());
    }

    public InformationResult fetchInformation(String userID) {

        return new InformationResult(informationModels.get(userID));
    }

    public InformationResult createInformation(InformationForm informationForm) {

        informationModels.put(informationForm.getUserID(), new InformationModel(informationForm));

        return new InformationResult(informationForm);
    }

    public InformationResult updateInformation(InformationForm informationForm) {

        return new InformationResult(informationModels.replace(informationForm.getUserID(), new InformationModel(informationForm)));
    }

    public void deleteInformation(String userID) {

        informationModels.remove(userID);
    }
}