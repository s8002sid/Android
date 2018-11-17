package com.example.siddjain.listviewsample;

public class FamilyDetail {
    private String fID;
    private String fFamilyID;
    private String fName;
    private String fBirthDate;
    private String fAnniversaryDate;
    private String fEducation;
    private String fBloodGroup;
    private String fMobileNumber;
    private String fOutside;
    private String fGender;
    private FamilyMaster fFamilyMaster;
    public FamilyDetail(String id, String familyID, String name, String birthDate, String anniversaryDate,
                        String education, String bloodGroup, String mobileNumber, String outside, String gender,
                        FamilyMaster familyMaster)
    {
        this.fID = id;
        this.fFamilyID = familyID;
        this.fName = name;
        this.fBirthDate = birthDate;
        this.fAnniversaryDate = anniversaryDate;
        this.fEducation = education;
        this.fBloodGroup = bloodGroup;
        this.fMobileNumber = mobileNumber;
        this.fOutside = outside;
        this.fGender = gender;
        this.fFamilyMaster = familyMaster;
    }
    public String getID(){return fID;}
    public String getFamilyID() {return fFamilyID;}
    public String getName() {return fName;}
    public String getBirthDate() {return fBirthDate;}
    public String getAnniversary() {return fAnniversaryDate;}
    public String getEducation() {return fEducation;}
    public String getBloodGroup() {return fBloodGroup;}
    public String getMobileNumber() {return fMobileNumber;}
    public String getIsMemberOutside() {return fOutside;}
    public String getGender() {return fGender;}
    public FamilyMaster getFamilyMaster() {return fFamilyMaster;}
}
