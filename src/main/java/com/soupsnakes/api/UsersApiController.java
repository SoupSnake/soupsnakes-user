package com.soupsnakes.api;

import com.soupsnakes.model.User;
import com.soupsnakes.repositories.UserRepository;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-02T00:21:26.013Z")

@Controller
public class UsersApiController implements UsersApi {

    @Autowired
    private UserRepository repository;

    public ResponseEntity<User> addUser(@ApiParam(value = "User to add" ,required=true ) @RequestBody User user) {
        repository.insert(user);
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteUser(@ApiParam(value = "ID of user to delete",required=true ) @PathVariable("id") String id) {
        repository.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<User> findUserById(@ApiParam(value = "ID of user to fetch",required=true ) @PathVariable("id") String id) {
        return new ResponseEntity<User>(repository.findOne(id), HttpStatus.OK);
    }

    public ResponseEntity<List<User>> findUsers() {
        return new ResponseEntity<List<User>>(repository.findAll(), HttpStatus.OK);
    }

}
