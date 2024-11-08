package web.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    void create(User user);

    void delete(long id);

    void update(User user);

    User getUserByEmail(String email);

}
