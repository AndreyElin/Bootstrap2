package web.services;

import org.springframework.data.crossstore.ChangeSetPersister;
import web.models.Role;

import java.util.List;

public interface RoleService {

    void saveRole(Role role);

    List<Role> getRoles();

    Role getByName(String name) throws ChangeSetPersister.NotFoundException;

}
