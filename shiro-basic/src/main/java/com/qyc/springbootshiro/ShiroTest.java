package com.qyc.springbootshiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/** shiro  认证
 * @author qianyongchao
 * @date 2018/5/10
 */
public class ShiroTest {
    @Test
    public void test() {
        //用户
        SimpleAccountRealm realm = new SimpleAccountRealm();
        realm.addAccount("aa","123456");

        //1 创建defaultSecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("aa", "123456");
        subject.login(token);

        System.out.println(subject.isAuthenticated());

    }

}
