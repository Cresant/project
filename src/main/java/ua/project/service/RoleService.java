package ua.project.service;

import ua.project.model.user.Role;

import java.util.Set;

public interface RoleService {

    public Role getRoleByName(String name);

    public Role getRoleById(Integer id);

    public Set<Role> getAllRoles();
}
