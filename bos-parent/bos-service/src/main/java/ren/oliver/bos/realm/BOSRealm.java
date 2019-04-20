package ren.oliver.bos.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import ren.oliver.bos.dao.UserDao;
import ren.oliver.bos.domain.User;

public class BOSRealm extends AuthorizingRealm {

    @Autowired
    UserDao userDao;

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken passwordToken = (UsernamePasswordToken)authenticationToken;
        // 获得页面输入的用户名
        String username = passwordToken.getUsername();
        // 根据用户名查询数据库中的密码
        User user = userDao.findUserByUsername(username);
        if(user == null){
            // 页面输入的用户名不存在
            return null;
        }
        // 简单认证信息对象
        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
        // 框架负责比对数据库中的密码和页面输入的密码是否一致
        return info;
    }

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }
}
