package com.qyc.springbootshiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author qianyongchao
 * @date 2018/5/10
 */
public class ShiroAuthentication {

    @Test
    public void authentication() {
        SimpleAccountRealm realm = new SimpleAccountRealm();
        realm.addAccount("mark","123456","admin");

        //创建defaultSecurityManagement
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);


        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("mark","123456");

        subject.login(token);
        System.out.println(subject.isAuthenticated());

        subject.checkRole("admin");

    }
}
