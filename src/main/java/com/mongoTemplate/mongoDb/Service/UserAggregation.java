package com.mongoTemplate.mongoDb.Service;

import com.mongoTemplate.mongoDb.DTO.CityGroup;
import com.mongoTemplate.mongoDb.DTO.ProjectionClass;
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

        //this is used to create a new aggregation pipeline which accepts list of aggregation operations and
        //executes them in th order which is provided
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("age").gte(20)),
                Aggregation.project("name","age","isActive")
        );

        //this takes the aggregation output and maps with the given field
        AggregationResults<User> results = mongoTemplate.aggregate(aggregation,"user", User.class);
        List<User> answer = results.getMappedResults();

        return answer;
    }


    public List<CityGroup> getUserCityGroupCount()
    {
        //this is used to create a new aggregation pipeline which accepts list of aggregation operations and
        //executes them in th order which is provided
        Aggregation aggregation = Aggregation.newAggregation(  // Exclude null city values
                Aggregation.group("city").count().as("countOfCity")
        );


        //this takes the aggregation output and maps with the given field
        AggregationResults<CityGroup> ageGroups = mongoTemplate.aggregate(aggregation,"user", CityGroup.class);
        System.out.println(ageGroups.getRawResults());
        List<CityGroup> answer = ageGroups.getMappedResults();
        System.out.println(answer);

        return answer;
    }

    public List<ProjectionClass> findAndRenameFields()
    {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("city").is("Washington")),

                //this is used to rename the default projection names of the field and change it to a new one
                //the and() retrieves the default name and as assigns a new name
                Aggregation.project().and("name").as("userName")
                        .and("age").as("ageOfUser")
                        .and("email").as("userMail")
                        .and("isActive").as("Alive")
        );

        AggregationResults<ProjectionClass> aggregationResults = mongoTemplate.aggregate(aggregation,"user", ProjectionClass.class);
        List<ProjectionClass> answer = aggregationResults.getMappedResults();

        return answer;
    }
}
