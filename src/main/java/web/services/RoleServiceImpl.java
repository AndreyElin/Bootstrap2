package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import web.dao.RoleRepository;
import web.models.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getByName(String name) throws ChangeSetPersister.NotFoundException {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            throw new ChangeSetPersister.NotFoundException();
        }
        return role;
    }

}
