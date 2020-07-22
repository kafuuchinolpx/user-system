package cn.hxzy.dao;

import cn.hxzy.entity.Role;
import cn.hxzy.entity.User;
import cn.hxzy.util.DBUtil;
import cn.hxzy.util.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao<User>{
    public long countAll() throws Exception {
        Connection connection = DataSource.getConnection();
        long statement = DBUtil.count(connection, "", new Object[]{}, User.class);
        return statement;
    }


    public List<User> findAll(int page, int size) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name from user u left join role r on u.role_id=r.id limit ?,?");
        statement.setObject(1, (page - 1) * size);
        statement.setObject(2, size);
        ResultSet resultSet = statement.executeQuery();
        List<User> list = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User(resultSet.getString("name"), resultSet.getString("login_name"), resultSet.getString("login_password"), resultSet.getInt("role_id"), resultSet.getString("role_name"));
            user.setId(resultSet.getInt("id"));
            user.setCreateTime(resultSet.getTimestamp("create_time"));
            user.setUpdateTime(resultSet.getTimestamp("update_time"));
            list.add(user);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }

    public User findById(Integer id) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name  from user u left join role r on u.role_id=r.id where u.id =?");
        statement.setObject(1, id);
        ResultSet resultSet = statement.executeQuery();
        User user = null;
        if (resultSet.next()) {
            user = new User(resultSet.getString("name"), resultSet.getString("login_name"), resultSet.getString("login_password"), resultSet.getInt("role_id"), resultSet.getString("role_name"));
            user.setId(resultSet.getInt("id"));
            user.setCreateTime(resultSet.getTimestamp("create_time"));
            user.setUpdateTime(resultSet.getTimestamp("update_time"));
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return user;
    }


    public User findByLoginName(String loginName) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name from user u left join role r on r.id=u.role_id where login_name =?");
        statement.setObject(1, loginName);
        ResultSet resultSet = statement.executeQuery();
        User user = null;
        if (resultSet.next()) {
            user = new User(resultSet.getString("name"), resultSet.getString("login_name"), resultSet.getString("login_password"), resultSet.getInt("role_id"), resultSet.getString("role_name"));
            user.setId(resultSet.getInt("id"));
            user.setCreateTime(resultSet.getTimestamp("create_time"));
            user.setUpdateTime(resultSet.getTimestamp("update_time"));
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return user;
    }

    public List<User> findByNameLike(Integer page, Integer size, String name) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name from user u left join role r on r.id=u.role_id where  u.name like ? limit ?,?");
        statement.setObject(1, "%" + name + "%");
        statement.setObject(2, (page - 1) * size);
        statement.setObject(3, size);
        ResultSet resultSet = statement.executeQuery();
        List<User> list = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User(resultSet.getString("name"), resultSet.getString("login_name"), resultSet.getString("login_password"), resultSet.getInt("role_id"), resultSet.getString("role_name"));
            user.setId(resultSet.getInt("id"));
            user.setCreateTime(resultSet.getTimestamp("create_time"));
            user.setUpdateTime(resultSet.getTimestamp("update_time"));
            list.add(user);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }

    public long countByNameLike(String name) throws Exception {
        Connection connection = DataSource.getConnection();
        long count1 = DBUtil.count(connection, "where name like ?", new Object[]{name}, User.class);
        return count1;
    }


    public int countByRoleId(int roleId) throws Exception {
        Connection connection = DataSource.getConnection();
        long count = DBUtil.count(connection, "where role_id = ?", new Object[]{roleId}, Role.class);
        DataSource.closeConnection(connection);
        return (int) count;
    }
}
