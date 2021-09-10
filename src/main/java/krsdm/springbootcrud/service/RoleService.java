package krsdm.springbootcrud.service;

import krsdm.springbootcrud.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    void remove(Role role);
    void saveRole(Role role);
    Role getRoleById(Long id);
    Role getByName(String name);

}
