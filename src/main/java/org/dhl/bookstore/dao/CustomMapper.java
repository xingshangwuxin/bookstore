package org.dhl.bookstore.model.dao.custom;

import org.dhl.bookstore.model.entity.Privilege;
import org.dhl.bookstore.model.entity.custom.OrderCustom;
import org.dhl.bookstore.model.entity.Role;
import org.dhl.bookstore.model.entity.User;

import java.util.List;

/**
 * 自定义mapper
 */

public interface CustomMapper {
            //通过user找订单
    List<OrderCustom> findOrdersByUserId(int userId);
            //通过商店名找订单
    List<OrderCustom> findOrdersByStoreId(int storeId);
            //通过user找角色定位
    List<Role> findRolesByUserId(int userId);
                //通过角色定位找他的权限
    List<Privilege> findPrivilegesByRoleId(int roleId);
                //通过角色定位找商家和管理员，这样才能有后台，角色定位为1的没有后台显示
    List<User> findBusinesses(int roleId);
}
