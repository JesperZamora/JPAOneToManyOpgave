package com.example.jpaonetomanyopgave.service.Impl.apiEnum;

public enum ApiData {
    URL_REGION("https://api.dataforsyningen.dk/regioner"),
    URL_KOMMUNE("https://api.dataforsyningen.dk/kommuner");

    private String url;
    ApiData(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }
}
