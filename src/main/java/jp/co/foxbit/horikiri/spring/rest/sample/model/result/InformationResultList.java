package jp.co.foxbit.horikiri.spring.rest.sample.model.result;

import java.util.ArrayList;
import java.util.List;

public class InformationResultList {

    private List<InformationResult> informationResult;

    public InformationResultList() {

        informationResult = new ArrayList<>();
    }

    public List<InformationResult> getInformationResult() {
        return informationResult;
    }

    public void setInformationResult(List<InformationResult> informationResult) {

        this.informationResult = informationResult;
    }
}
