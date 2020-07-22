package cn.hxzy.util;

import cn.hxzy.entity.Role;
import cn.hxzy.entity.User;

import java.sql.Connection;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        Connection connection = DataSource.getConnection();

//        增
//        User user = new User("张三","ahmadabad","qweqwe123",3,"3");
//        DBUtil.insert(connection,user);

        //改
//        User user=new User();
//        user.setId(115);
//        user.setLoginName("adada");
//        user.setLoginPassword("111111");
//        user.setName("张珊");
//         DBUtil.update(connection, User.class);
//        System.out.println(update);
//        DBUtil.insert(connection,update);

        //查
//        List<Role> users=DBUtil.select(connection,"",new Object[]{},Role.class);
//        for (Role user : users) {
//            System.out.println(user);
//        }
//        DataSource.closeConnection(connection);

        //删
//        int delete = DBUtil.delete(connection, 114, User.class);
//        System.out.println(delete);
//        DataSource.closeConnection(connection);


    }
}
