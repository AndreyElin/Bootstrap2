package web;

import org.springframework.stereotype.Component;
import web.models.Role;
import web.models.User;
import web.services.RoleService;
import web.services.UserService;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class InitData {

    private final RoleService roleService;
    private final UserService userService;

    public InitData(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void initRolesAndUsers() {
        Role roleUser = new Role("ROLE_USER");
        Role roleAdmin = new Role("ROLE_ADMIN");
        roleService.saveRole(roleUser);
        roleService.saveRole(roleAdmin);
        User user = new User("Ivan", "Ivanov", (byte) 22, "user@mail.ru",  "user", Set.of(roleUser));
        User admin = new User("Petr", "Petrov", (byte) 33, "admin@mail.ru", "admin", Set.of(roleAdmin, roleUser));
        userService.create(user);
        userService.create(admin);
    }
}
