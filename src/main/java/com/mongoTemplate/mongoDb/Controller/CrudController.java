package com.mongoTemplate.mongoDb.Controller;

import com.mongoTemplate.mongoDb.Document.User;
import com.mongoTemplate.mongoDb.Service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/crud")
public class CrudController {

    @Autowired
    CrudService crudService;
    @GetMapping("/find")
    public List<User> find()
    {
        return crudService.getUsers();
    }

    @GetMapping("/findBy")
    public List<User> findBy()
    {
        return crudService.findUserBy();
    }

    @PostMapping("/insert")
    public void insert(@RequestBody User user)
    {
        crudService.insertUser(user);
    }

}
