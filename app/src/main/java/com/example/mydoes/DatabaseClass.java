package com.example.mydoes;

public class DatabaseClass {
    String titleHome;
    String desHome;
    String dateHome;

    public DatabaseClass() {

    }

    public DatabaseClass(String titleHome, String desHome, String dateHome) {
        this.titleHome = titleHome;
        this.desHome = desHome;
        this.dateHome = dateHome;
    }

    public String getTitleHome() {
        return titleHome;
    }

    public void setTitleHome(String titleHome) {
        this.titleHome = titleHome;
    }

    public String getDesHome() {
        return desHome;
    }

    public void setDesHome(String desHome) {
        this.desHome = desHome;
    }

    public String getDateHome() {
        return dateHome;
    }

    public void setDateHome(String dateHome) {
        this.dateHome = dateHome;
    }
}
