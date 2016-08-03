package com.soupsnakes.api;

import com.soupsnakes.model.User;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-02T00:21:26.013Z")

@Api(value = "users", description = "the users API")
public interface UsersApi {

    @ApiOperation(value = "", notes = "Creates a new user.", response = User.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "user response", response = User.class),
        @ApiResponse(code = 200, message = "unexpected error", response = User.class) })
    @RequestMapping(value = "/users",
        produces = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<User> addUser(@ApiParam(value = "User to add" ,required=true ) @RequestBody User user);


    @ApiOperation(value = "", notes = "deletes a single user based on the ID supplied", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "user deleted", response = Void.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Void.class) })
    @RequestMapping(value = "/users/{id}",
        produces = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteUser(@ApiParam(value = "ID of user to delete",required=true ) @PathVariable("id") String id);


    @ApiOperation(value = "", notes = "Returns a user by id", response = User.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "user response", response = User.class),
        @ApiResponse(code = 200, message = "unexpected error", response = User.class) })
    @RequestMapping(value = "/users/{id}",
        produces = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<User> findUserById(@ApiParam(value = "ID of user to fetch",required=true ) @PathVariable("id") String id);


    @ApiOperation(value = "", notes = "Returns all Soup Snake users", response = User.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "user response", response = User.class),
        @ApiResponse(code = 200, message = "unexpected error", response = User.class) })
    @RequestMapping(value = "/users",
        produces = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<User>> findUsers();

}
