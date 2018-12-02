package RealmSelf;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author qianyongchao
 * @date 2018/5/11
 */
public class MyshiroTest {
    @Test
    public void test() {
        CustomRealm customRealm = new CustomRealm();

        //1 构建securityManagment环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);

        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //MD5加密
        matcher.setHashAlgorithmName("md5");
        //加密次数
        matcher.setHashIterations(1);
        customRealm.setCredentialsMatcher(matcher);

        //2 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        //
        UsernamePasswordToken token = new UsernamePasswordToken("Mark", "1234567","Mark");
        subject.login(token);

    }

}
