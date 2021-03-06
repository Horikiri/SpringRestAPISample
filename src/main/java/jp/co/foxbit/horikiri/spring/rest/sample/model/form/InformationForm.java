package jp.co.foxbit.horikiri.spring.rest.sample.model.form;

import jp.co.foxbit.horikiri.spring.rest.sample.model.result.InformationResult;

public class InformationForm {

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

    public InformationForm() {
        
    }

    public InformationForm(String userID, String firstName, String lastName, String createdAt, String modifiedAt,
            boolean validUser) {

        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.validUser = validUser; 
    }

    public InformationForm(InformationResult informationResult) {

        this.userID = informationResult.getUserID();
        this.firstName = informationResult.getFirstName();
        this.lastName = informationResult.getLastName();
        this.createdAt = informationResult.getCreatedAt();
        this.modifiedAt = informationResult.getModifiedAt();
        this.validUser = informationResult.getValidUser(); 
    }
}