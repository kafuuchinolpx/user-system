package cn.hxzy.service;

import cn.hxzy.dao.RoleDao;
import cn.hxzy.entity.Role;
import cn.hxzy.entity.vo.PageObj;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class RoleService {
    RoleDao roleDao = new RoleDao();

    public void add(Role role) throws Exception {
        role.setCreateTime(new Date());
        roleDao.add(role);
    }

    public void update(Role role) throws Exception {
        role.setUpdateTime(new Date());
        roleDao.update(role);
    }

    public void deleteById(int id) throws Exception {
        roleDao.delete(id);
    }

    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    public Role findById(Integer id) throws Exception {
        return roleDao.findById(id);
    }


    public Role findByIdWithResource(int id) throws Exception {
        return roleDao.findByIdWithResource(id);
    }

    public void authorize(String resourceId, String roleId) throws SQLException {
        if (resourceId != null && resourceId != "" && roleId != null && roleId != "") {
            long count = roleDao.countByRoleIdAndResourceId(Integer.parseInt(roleId), Integer.parseInt(resourceId));
            if (count > 0) {
                roleDao.deleteByRoleIdAndResourceId(Integer.parseInt(roleId), Integer.parseInt(resourceId));
            } else {
                roleDao.addByRoleIdAndResourceId(Integer.parseInt(roleId), Integer.parseInt(resourceId));
            }
        }
    }
}
