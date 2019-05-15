package ren.oliver.bos.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import ren.oliver.bos.dao.FunctionDao;
import ren.oliver.bos.dao.UserDao;
import ren.oliver.bos.domain.Function;
import ren.oliver.bos.domain.User;

import java.util.List;

public class BOSRealm extends AuthorizingRealm {

    @Autowired
    UserDao userDao;

    @Autowired
    FunctionDao functionDao;

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

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前登录用户对象
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //User user2 = (User) principals.getPrimaryPrincipal();
        // 根据当前登录用户查询数据库，获取实际对应的权限
        List<Function> list = null;
        if(user.getUsername().equals("admin")){
            DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Function.class);
            //超级管理员内置用户，查询所有权限数据
            list = functionDao.findByCriteria(detachedCriteria);
        }else{
            list = functionDao.findFunctionListByUserId(user.getId());
        }

        for (Function function : list) {
            info.addStringPermission(function.getCode());
        }
        return info;
    }
}
