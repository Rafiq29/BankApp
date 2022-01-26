package app.service;

import app.entity.User;
import app.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {

        this.userRepo = userRepo;
    }

    public void addUser(Collection<User> users) {
        userRepo.saveAll(users.stream().map(user -> {
            user.setId(0);
            return user;
        }).collect(Collectors.toList()));
    }

    public void deleteUser(User user) {
        userRepo.delete(user);
    }

    public void deleteByID(int id) {
        userRepo.deleteById(id);}
    public User getUser(int id) {
        Optional<User> optUser = userRepo.findById(id);
        return optUser.orElseGet(User::new);
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        userRepo.findAll().forEach(users::add);
        return users;
    }
}
