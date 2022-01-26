package app.controller;

import app.entity.User;
import app.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public User getById (@PathVariable("id") User user) {
        return service.getUser(user.getId());
    }

    @GetMapping
    public Iterable<User> getAll() {
        return service.getAll();
    }

    @PostMapping
    public String addUser(@RequestBody Collection<User> users) {
        service.addUser(users);
        return "Added";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.deleteByID(id);
        return "Deleted";
    }
}
