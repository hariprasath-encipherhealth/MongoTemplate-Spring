package com.mongoTemplate.mongoDb.DTO;

public class ProjectionClass {

    private String userName;
    private String ageOfUser;
    private String userMail;
    private boolean Alive;

    public ProjectionClass(String userName, String ageOfUser, String userMail, boolean alive) {
        this.userName = userName;
        this.ageOfUser = ageOfUser;
        this.userMail = userMail;
        Alive = alive;
    }
    public ProjectionClass()
    {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAgeOfUser() {
        return ageOfUser;
    }

    public void setAgeOfUser(String ageOfUser) {
        this.ageOfUser = ageOfUser;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public boolean isAlive() {
        return Alive;
    }

    public void setAlive(boolean alive) {
        Alive = alive;
    }
}
