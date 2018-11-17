package com.example.siddjain.listviewsample;

public class FamilyMaster {
    private String fId;
    private String fName;
    private String fAddress;
    private String fPhoneNumber;
    private String fBusiness;
    private String fBusinessAddress;
    private String fBusinessPhoneNumber;
    private String fNativePlace;
    private String fEmail;
    private String fSpecialQualification;
    private String fPatrikaSubscription;
    private String fSpiritualAchievements;
    private String fAppDownloaded;
    private String fReligiousSituation;
    private String fEconomicSituation;
    private String fSamayik;
    private String fGuruDarshan;
    private String fNumberOfTerapanthCard;
    private String fDedicatedReligiousPersonDescription;
    public FamilyMaster(String id, String name, String address, String phoneNumber, String business, String businessAddress, String businessPhoneNumber,
                        String nativePlace, String email, String specialQualification, String patrikaSubscription, String spiritualAchievements,
                        String appDownloaded, String religiousSituation, String economicSituation, String samayik, String guruDarshan, String numberOfTerapanthCard,
                        String dedicatedRelPerDesc) {
        this.fId = id;
        this.fName = name;
        this.fAddress = address;
        this.fPhoneNumber = phoneNumber;
        this.fBusiness = business;
        this.fBusinessAddress = businessAddress;
        this.fBusinessPhoneNumber = businessPhoneNumber;
        this.fNativePlace = nativePlace;
        this.fEmail = email;
        this.fSpecialQualification = specialQualification;
        this.fPatrikaSubscription = patrikaSubscription;
        this.fSpiritualAchievements = spiritualAchievements;
        this.fAppDownloaded = appDownloaded;
        this.fReligiousSituation = religiousSituation;
        this.fEconomicSituation = economicSituation;
        this.fSamayik = samayik;
        this.fGuruDarshan = guruDarshan;
        this.fNumberOfTerapanthCard = numberOfTerapanthCard;
        this.fDedicatedReligiousPersonDescription = dedicatedRelPerDesc;
    }
    public String getID() {return this.fId;}
    public String getName() {return this.fName;}
    public String getAddress() {return this.fAddress;}
    public String getPhoneNumber() {return this.fPhoneNumber;}
    public String getBusiness() {return this.fBusiness;}
    public String getBusinessAddress() {return this.fBusinessAddress;}
    public String getBusinessPhoneNumber() {return this.fBusinessPhoneNumber;}
    public String getNativePlace() {return this.fNativePlace;}
    public String getEmail() {return this.fEmail;}
    public String getSpecialQualification() {return this.fSpecialQualification;}
    public String getPatrikaSubscription() {return this.fPatrikaSubscription;}
    public String getSpiritualAchievements() {return this.fSpiritualAchievements;}
    public String getAppDownloadedCount() {return this.fAppDownloaded;}
    public String getReligiousSituation() {return this.fReligiousSituation;}
    public String getEconomicSituation() {return this.fEconomicSituation;}
    public String getSamayik() {return this.fSamayik;}
    public String getGuruDarshan() {return this.fGuruDarshan;}
    public String getTerapanthCardCount() {return this.fNumberOfTerapanthCard;}
    public String getDedicatedReligiousPersonDescription() {return this.fDedicatedReligiousPersonDescription;}
}
