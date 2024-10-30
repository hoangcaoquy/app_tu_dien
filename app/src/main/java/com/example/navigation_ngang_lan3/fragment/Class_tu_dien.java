package com.example.navigation_ngang_lan3.fragment;

public class Class_tu_dien {

    private String Tiengviet2;
    private String Tienganh2;

    public Class_tu_dien(String tienganh2, String tiengviet2) {
        Tiengviet2 = tiengviet2;
        Tienganh2 = tienganh2;
    }

    public String getTiengviet2() {
        return Tiengviet2;
    }

    public void setTiengviet2(String tiengviet2) {
        Tiengviet2 = tiengviet2;
    }

    public String getTienganh2() {
        return Tienganh2;
    }

    public void setTienganh2(String tienganh2) {
        Tienganh2 = tienganh2;
    }

    @Override
    public String toString() {
        return "Class_tu_dien{" +
                "Tiengviet2='" + Tiengviet2 + '\'' +
                ", Tienganh2='" + Tienganh2 + '\'' +
                '}';
    }
}
