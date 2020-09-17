package jp.co.foxbit.horikiri.spring.rest.sample.model.result;

import jp.co.foxbit.horikiri.spring.rest.sample.model.db.InformationModel;
import jp.co.foxbit.horikiri.spring.rest.sample.model.form.InformationForm;

public class InformationResult {

    private String userID;

    private String firstName;

    private String lastName;

    private String createdAt;

    private String modifiedAt;

    private boolean validUser;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public boolean getValidUser() {
        return validUser;
    }

    public void setValidUser(boolean validUser) {
        this.validUser = validUser;
    }

    public InformationResult() {

    }

    public InformationResult(InformationModel informationModel) {

        this.userID = informationModel.getUserID();
        this.firstName = informationModel.getFirstName();
        this.lastName = informationModel.getLastName();
        this.createdAt = informationModel.getCreatedAt();
        this.modifiedAt = informationModel.getModifiedAt();
        this.validUser = informationModel.getValidUser(); 
    }

    public InformationResult(InformationForm informationForm) {

        this.userID = informationForm.getUserID();
        this.firstName = informationForm.getFirstName();
        this.lastName = informationForm.getLastName();
        this.createdAt = informationForm.getCreatedAt();
        this.modifiedAt = informationForm.getModifiedAt();
        this.validUser = informationForm.getValidUser(); 
    }
}