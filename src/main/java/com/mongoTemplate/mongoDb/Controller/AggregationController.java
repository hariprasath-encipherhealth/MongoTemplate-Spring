package com.mongoTemplate.mongoDb.Controller;


import com.mongoTemplate.mongoDb.DTO.CityGroup;
import com.mongoTemplate.mongoDb.DTO.ProjectionClass;
import com.mongoTemplate.mongoDb.Document.User;
import com.mongoTemplate.mongoDb.Service.CrudService;
import com.mongoTemplate.mongoDb.Service.AggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class AggregationController {

    @Autowired
    CrudService mongoservice;

    @Autowired
    AggregationService aggregationService;

    @GetMapping("/get")
    public List<User> get()
    {
        System.out.println("inside get mapping");
        return mongoservice.getUsers();
    }

    @PostMapping("/set")
    public void set(@RequestBody User user)
    {
        mongoservice.setUser(user);
    }

    @GetMapping("/getBy")
    public List<User> findBycon()
    {
        return mongoservice.findUserBy();
    }

    @GetMapping("/getBy/aggregate")
    public List<User> getByAggregate()
    {
        return aggregationService.getUserByAge();
    }

    @GetMapping("/groupBy/aggregate/city")
    public List<CityGroup> groupBy()
    {
        return aggregationService.getUserCityGroupCount();
    }

    @GetMapping("/get/project")
    public List<ProjectionClass> getProject()
    {
        return aggregationService.findAndRenameFields();
    }
}
