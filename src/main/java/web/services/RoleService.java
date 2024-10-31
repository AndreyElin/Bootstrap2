package web.services;

import web.models.Role;

import java.util.List;

public interface RoleService {

    Role getById(long id);

    void saveRole(Role role);

    List<Role> getRoles();

}
