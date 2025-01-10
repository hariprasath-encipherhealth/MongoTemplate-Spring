package com.mongoTemplate.mongoDb.Service;

import com.mongoTemplate.mongoDb.DTO.CityGroup;
import com.mongoTemplate.mongoDb.Document.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAggregation {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<User> getUserByAge()
    {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("age").gte(20)),
                Aggregation.project("name","age","isActive")
        );

        AggregationResults<User> results = mongoTemplate.aggregate(aggregation,"user", User.class);
        List<User> answer = results.getMappedResults();

        return answer;
    }


    public List<CityGroup> getUserCityGroupCount()
    {
        Aggregation aggregation = Aggregation.newAggregation(  // Exclude null city values
                Aggregation.group("city").count().as("countOfCity")
        );

        AggregationResults<CityGroup> ageGroups = mongoTemplate.aggregate(aggregation,"user", CityGroup.class);
        System.out.println(ageGroups.getRawResults());
        List<CityGroup> answer = ageGroups.getMappedResults();
        System.out.println(answer);

        return answer;
    }

}
