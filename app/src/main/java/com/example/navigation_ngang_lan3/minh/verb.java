package com.example.navigation_ngang_lan3.minh;

public class verb {

    private String Verb;
    private String Past;
    private String Pii;

    public verb(String verb, String past, String pii) {
        Verb = verb;
        Past = past;
        Pii = pii;
    }


    public String getVerb() {
        return Verb;
    }

    public void setVerb(String verb) {
        Verb = verb;
    }

    public String getPast() {
        return Past;
    }

    public void setPast(String past) {
        Past = past;
    }

    public String getPii() {
        return Pii;
    }

    public void setPii(String pii) {
        Pii = pii;
    }




}

