package org.dhl.bookstore.model.service;

import org.dhl.bookstore.common.pojo.BSResult;
import org.dhl.bookstore.common.pojo.ZTreeNode;
import org.dhl.bookstore.model.entity.Privilege;

import java.util.List;

public interface IPrivilegeService {


    List<ZTreeNode> getZTreeNodes();

    BSResult findById(int privId);

    BSResult updatePrivilege(Privilege privilege);

    BSResult addPrivilege(Privilege privilege);

    BSResult deleteById(int privId);

    List<ZTreeNode> getRolePrivileges(int roleId);
}
