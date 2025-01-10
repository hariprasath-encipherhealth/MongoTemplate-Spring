package com.mongoTemplate.mongoDb.Document;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class User {

    @NonNull
    private String name;
    @NonNull
    private int age;
    @NonNull
    private String email;
    @NonNull
    private String city;
    @NonNull
    private boolean isActive;

    public User()
    {

    }
    public User(String name, int age, String email, String city, boolean isActive) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.city = city;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
