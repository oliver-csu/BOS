package ren.oliver.bos.web.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ren.oliver.bos.domain.User;
import ren.oliver.bos.service.UserService;
import ren.oliver.bos.utils.BOSUtils;
import ren.oliver.bos.utils.MD5Utils;

import java.io.IOException;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

    // 验证码
    private String checkcode;

    // 多个角色id
    private String[] roleIds;

    @Autowired
    UserService userService;

    public String login(){

        // 从Session中获取生成的验证码
        String validatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
        if(StringUtils.isNotBlank(checkcode) && checkcode.equals(validatecode)){

            // 使用shiro框架提供的方式进行认证操作

            // 获得当前用户对象,状态为“未认证”
            Subject subject = SecurityUtils.getSubject();
            // 创建用户名密码令牌对象
            AuthenticationToken token = new UsernamePasswordToken(model.getUsername(), MD5Utils.md5(model.getPassword()));
            try{
                subject.login(token);
            }catch(Exception e){
                e.printStackTrace();
                return LOGIN;
            }
            User user = (User) subject.getPrincipal();
            ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
            return HOME;
        } else {
            // 输入的验证码错误,设置提示信息，跳转到登录页面
            this.addActionError("输入的验证码错误！");
            return LOGIN;
        }
    }

    public String logout(){

        ServletActionContext.getRequest().getSession().invalidate();
        return LOGIN;
    }

    public String editPassword() throws IOException {

        String result = "1";
        User user = BOSUtils.getLoginUser();

        try {
            userService.editPassword(user.getId(), model.getPassword());
        } catch (Exception e) {
            result = "0";
            e.printStackTrace();
        }
        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(result);
        return NONE;
    }

    /**
     * 添加用户
     */
    public String add(){

        userService.save(model, roleIds);
        return LIST;
    }

    /**
     * 用户数据分页查询
     */
    public String pageQuery(){

        userService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"detachedCriteria","noticeBills","roles"});
        return NONE;
    }

    public void setCheckcode(String checkcode) {

        this.checkcode = checkcode;
    }

    public String getCheckcode() {

        return this.checkcode;
    }

    public void setRoleIds(String[] roleIds) {

        this.roleIds = roleIds;
    }

    public String[] getRoleIds() {

        return this.roleIds;
    }
}
