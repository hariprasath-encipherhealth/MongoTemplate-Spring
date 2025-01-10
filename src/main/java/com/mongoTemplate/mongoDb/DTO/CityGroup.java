package com.mongoTemplate.mongoDb.DTO;

public class CityGroup {

    private String _id;
    private int countOfCity;

    public CityGroup()
    {

    }
    public CityGroup(String _id, int CountOfCity) {
        this._id = _id;
        this.countOfCity = CountOfCity;
    }

    public String getName() {
        return _id;
    }

    public void setName(String city) {
        this._id = city;
    }

    public int getCountOfCity() {
        return countOfCity;
    }

    public void setCountOfCity(int CountOfCity) {
        this.countOfCity = CountOfCity;
    }

    @Override
    public String toString() {
        return "CityGroup{" +
                "_id='" + _id + '\'' +
                ", countOfCity=" + countOfCity +
                '}';
    }
}
