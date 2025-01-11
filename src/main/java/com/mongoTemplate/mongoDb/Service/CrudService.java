package com.mongoTemplate.mongoDb.Service;

import com.mongoTemplate.mongoDb.Document.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudService {

    @Autowired
    private MongoTemplate mongoTemplate;


    public List<User> getUsers()
    {
        System.out.println("inside impl");
        Query query = new Query();
        query.addCriteria(Criteria.where("age").lte(30));
        List<User> users = mongoTemplate.findAll(User.class);

        return users;
    }


    public void setUser(User user)
    {
        mongoTemplate.insert(user);
    }

    public List<User> findUserBy()
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gte(25));
        query.addCriteria(Criteria.where("isActive").is(true));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }


    public void insertUser(User user) {
        mongoTemplate.insert(user);
    }

}
