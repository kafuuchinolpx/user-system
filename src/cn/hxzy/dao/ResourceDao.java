package cn.hxzy.dao;

import cn.hxzy.entity.Resource;
import cn.hxzy.util.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResourceDao extends BaseDao<Resource>{


    public long countAll() throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select count(*) from resource");
        ResultSet resultSet = statement.executeQuery();
        long count = 0;
        if (resultSet.next()) {
            count = resultSet.getLong(1);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return count;
    }


    public Resource findById(Integer id) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from resource where id =?");
        statement.setObject(1, id);
        ResultSet resultSet = statement.executeQuery();
        Resource resource = null;
        if (resultSet.next()) {
            resource = new Resource(resultSet.getString("name"), resultSet.getString("url"), resultSet.getInt("pid"));
            resource.setId(resultSet.getInt("id"));
            resource.setCreateTime(resultSet.getTimestamp("create_time"));
            resource.setUpdateTime(resultSet.getTimestamp("update_time"));
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return resource;
    }

    public List<Resource> findAll() throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from resource");
        ResultSet resultSet = statement.executeQuery();
        List<Resource> list = new ArrayList<>();
        while (resultSet.next()) {
            Resource resource = new Resource(resultSet.getString("name"), resultSet.getString("url"), resultSet.getInt("pid"));
            resource.setId(resultSet.getInt("id"));
            resource.setCreateTime(resultSet.getTimestamp("create_time"));
            resource.setUpdateTime(resultSet.getTimestamp("update_time"));
            list.add(resource);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }

    public List<Resource> findByPid(int i) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from resource where pid =" + i);
        ResultSet resultSet = statement.executeQuery();
        List<Resource> list = new ArrayList<>();
        while (resultSet.next()) {
            Resource resource = new Resource(resultSet.getString("name"), resultSet.getString("url"), resultSet.getInt("pid"));
            resource.setId(resultSet.getInt("id"));
            resource.setCreateTime(resultSet.getTimestamp("create_time"));
            resource.setUpdateTime(resultSet.getTimestamp("update_time"));
            list.add(resource);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }

    public List<Resource> findByRoleIdNotHave(int id) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM `resource` WHERE id NOT IN(SELECT r.id FROM `resource` r LEFT JOIN `role_resource` rr ON  rr.`resource_id`=r.id WHERE rr.`role_id` = ?) order by order_number");
        statement.setObject(1, id);
        ResultSet resultSet = statement.executeQuery();
        List<Resource> list = new ArrayList<>();
        while (resultSet.next()) {
            Resource resource = new Resource(resultSet.getString("name"), resultSet.getString("url"), resultSet.getInt("pid"),resultSet.getInt("order_number"));
            resource.setId(resultSet.getInt("id"));
            resource.setCreateTime(resultSet.getTimestamp("create_time"));
            resource.setUpdateTime(resultSet.getTimestamp("update_time"));
            list.add(resource);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }
}
