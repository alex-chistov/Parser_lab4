package org.example;

public class Main {

    public static void main(String[] args) {

        String usersApiUrl = "https://fake-json-api.mock.beeceptor.com/users";
        DataParser.fetchData(usersApiUrl, "User");

        String companiesApiUrl = "https://fake-json-api.mock.beeceptor.com/companies";
        DataParser.fetchData(companiesApiUrl, "Company");
    }
}
