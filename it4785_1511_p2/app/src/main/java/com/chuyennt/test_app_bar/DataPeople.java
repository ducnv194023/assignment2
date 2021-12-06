package com.chuyennt.test_app_bar;

import io.bloco.faker.Faker;

public class DataPeople {
    Faker faker;
    boolean favorite;

    public DataPeople(Faker faker) {
        this.faker = faker;
        this.favorite = false;
    }
}
