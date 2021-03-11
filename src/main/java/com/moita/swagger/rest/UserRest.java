package com.moita.swagger.rest;

import com.moita.swagger.rest.domain.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api")
public class UserRest {

    private static final Map<Integer, User> users = new ConcurrentHashMap<>();
    private static final AtomicInteger idGenerator = new AtomicInteger(3);

    static {
        users.put(1, new User(1, "Rapha"));
        users.put(2, new User(2, "Mari"));
    }

    @GetMapping("/")
    @ApiOperation(
            value = "Return all registered users",
            notes = "Users from Swagger example",
            response = User.class)
    public Collection<User> users()
    {
        return users.values();
    }

    @GetMapping("/{userId}")
    @ApiOperation(
            value = "Return a registered user bu its id",
            notes = "User from Swagger example",
            response = User.class)
    public User users(@PathVariable Integer userId)
    {
        return users.get(userId);
    }

    @PostMapping("/")
    @ApiOperation(
            value = "Add a new user",
            notes = "Users to Swagger example",
            response = User.class)
    public User addUser(@RequestBody User user)
    {
        user.setId(idGenerator.getAndIncrement());
        users.put(user.getId(), user);
        return user;
    }
}
