package org.dhl.bookstore.model.service;

import org.dhl.bookstore.common.pojo.BSResult;
import org.dhl.bookstore.model.entity.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAllRoles();

    BSResult updateUserRoleRelationship(Integer userId, int[] roleIds);

    Role findById(int roleId);

    BSResult deleteById(int roleId);

    BSResult addRole(Role role);

    BSResult updateRole(Role role);

    BSResult updateRolesPrivilege(int[] ids, int roleId);
}

