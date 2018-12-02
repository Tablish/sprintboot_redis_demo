package RealmSelf;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义realm
 * @author qianyongchao
 * @date 2018/5/11
 */
public class CustomRealm extends AuthorizingRealm {

    HashMap<String, String> map = new HashMap<String,String>();
    {
        // fcea920f7412b5da7be0cf42b8c93759
        map.put("Mark","d40fdd323f5322ff34a41f026f35cf20");
        super.setName("customRealm");
    }

    /*
    * 授权
    * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //UsernamePasswordToken token = new UsernamePasswordToken("Mark","123);
        String userName = (String) principalCollection.getPrimaryPrincipal();
        //从数据库或者缓存中获取角色数据
        Set<String> roles = getRolesByUserName(userName);
        Set<String> permission = getPermissionsByUserName(userName);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permission);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    //模拟数据库
    private Set<String> getPermissionsByUserName(String userName) {
        HashSet<String> set = new HashSet<String>();
        set.add("user:update");
        set.add("use:select");
        return set;
    }

    private Set<String> getRolesByUserName(String userName) {
        HashSet<String> set = new HashSet<String>();
        set.add("admin");
        set.add("user");
        return set;
    }

    /*
    * 认证
    * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //1 从主体传来的认证信息，获得用户名
        String userName = (String) authenticationToken.getPrincipal();

        //DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //2 通过用户名到数据库中获取凭证
        String password = getPasswordByUsername(userName);

        if(password == null) {
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo
                ("Mark",password,"customRealm");
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("Mark"));
        return authenticationInfo;
    }

    private String getPasswordByUsername(String userName) {
        return map.get(userName);
    }

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("1234567","Mark");
        System.out.println(md5Hash);
    }
}
