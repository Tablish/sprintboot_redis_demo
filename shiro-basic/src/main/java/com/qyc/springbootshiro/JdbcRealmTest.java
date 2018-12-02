package com.qyc.springbootshiro;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author qianyongchao
 * @date 2018/5/10
 */
public class JdbcRealmTest {

    //创建jdbcRealm数据源
    DruidDataSource dataSource = new DruidDataSource();

    {
        dataSource.setUrl("jdbc:mysql://localhost:3306/qyc?characterEncoding=utf8&useSSL=true");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
    }

    @Test
    public void test() {
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setPermissionsLookupEnabled(true);

        String sql = "select password from test_user where user_name= ?";
        String sql2 = "select role_name from test_user_role where user_name = ?";

        //jdbcRealm.setAuthenticationQuery(sql2);
        jdbcRealm.setUserRolesQuery(sql2);
        //创建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("xiaoming","654321");

        subject.login(token);

        /*subject.checkRole("admin");

        subject.checkRoles("admin","user");

        subject.checkPermission("user:select");*/
        subject.checkRole("user");
    }

}
