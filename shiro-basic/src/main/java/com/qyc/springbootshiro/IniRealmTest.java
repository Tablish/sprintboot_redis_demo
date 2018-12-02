package com.qyc.springbootshiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author qianyongchao
 * @date 2018/5/10
 */
public class IniRealmTest {

    @Test
    public void test() {
        IniRealm iniRealm = new IniRealm("classpath:user.ini");

        //构建securitymanager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);


        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Mark","123456");
        subject.login(token);
        //角色
        subject.checkRole("admin");
        //权限

        subject.checkPermission("user:update");

    }

}
