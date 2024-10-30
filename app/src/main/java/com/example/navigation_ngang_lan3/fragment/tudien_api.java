package com.example.navigation_ngang_lan3.fragment;

import java.util.List;

public class tudien_api {
    //public List<tudien_api> listTudien;
    private String english;

    private String vietnamese;

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getVietnamese() {
        return vietnamese;
    }

    public void setVietnamese(String vietnamese) {
        this.vietnamese = vietnamese;
    }

    public tudien_api(String english, String vietnamese) {
        this.english = english;
        this.vietnamese = vietnamese;
    }
}
