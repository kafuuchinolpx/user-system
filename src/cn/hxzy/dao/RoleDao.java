package cn.hxzy.dao;

import cn.hxzy.entity.Resource;
import cn.hxzy.entity.Role;
import cn.hxzy.util.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDao extends BaseDao<Role>{

    public List<Role> findAll() throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from role");
        ResultSet resultSet = statement.executeQuery();
        List<Role> list = new ArrayList<>();
        while (resultSet.next()) {
            Role role = new Role(resultSet.getString("name"), resultSet.getString("remark"));
            role.setId(resultSet.getInt("id"));
            role.setCreateTime(resultSet.getTimestamp("create_time"));
            role.setUpdateTime(resultSet.getTimestamp("update_time"));
            list.add(role);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }



    public Role findByIdWithResource(int id) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT r.*,re.id resource_id ,re.name resource_name , re.url resource_url ,re.pid resource_pid  FROM role r LEFT JOIN `role_resource` rr ON r.`id`=rr.`role_id` LEFT JOIN `resource` re ON rr.`resource_id`=re.`id`  WHERE r.id = ? order by re.order_number");
        statement.setObject(1, id);
        ResultSet resultSet = statement.executeQuery();
        Role role = null;
        List<Resource> resourceList = new ArrayList<>();
        while (resultSet.next()) {
            role = new Role(resultSet.getString("name"), resultSet.getString("remark"));
            role.setId(resultSet.getInt("id"));
            role.setCreateTime(resultSet.getTimestamp("create_time"));
            role.setUpdateTime(resultSet.getTimestamp("update_time"));
            if (resultSet.getString("resource_name") != null) {
                Resource resource = new Resource(resultSet.getString("resource_name"), resultSet.getString("resource_url"), resultSet.getInt("resource_pid"),0);
                resource.setId(resultSet.getInt("resource_id"));
                resourceList.add(resource);
            }
        }
        if (role != null)
            role.setResources(resourceList);
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return role;
    }




    public long countByRoleIdAndResourceId(int roleId, int resourceId) throws SQLException {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select count(0) from role_resource where role_id=? and resource_id =?");
        statement.setObject(1, roleId);
        statement.setObject(2, resourceId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            long aLong = resultSet.getLong(1);
            resultSet.close();
            statement.close();
            DataSource.closeConnection(connection);
            return aLong;
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return 0;
    }

    public void deleteByRoleIdAndResourceId(int roleId, int resourceId) throws SQLException {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("delete from role_resource where role_id=? and resource_id =?");
        statement.setObject(1, roleId);
        statement.setObject(2, resourceId);
        statement.executeUpdate();
        statement.close();
        DataSource.closeConnection(connection);
    }

    public void addByRoleIdAndResourceId(int roleId, int resourceId) throws SQLException {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into role_resource (role_id,resource_id) values (?,?)");
        statement.setObject(1, roleId);
        statement.setObject(2, resourceId);
        statement.executeUpdate();
        statement.close();
        DataSource.closeConnection(connection);
    }
}
