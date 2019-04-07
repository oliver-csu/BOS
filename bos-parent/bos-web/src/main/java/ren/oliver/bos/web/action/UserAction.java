package ren.oliver.bos.web.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ren.oliver.bos.domain.User;
import ren.oliver.bos.service.UserService;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

    private String checkcode;

    @Autowired
    UserService userService;

    public void setCheckcode(String checkcode) {

        this.checkcode = checkcode;
    }

    public String login(){

        String validatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
        if(StringUtils.isNotBlank(checkcode) && checkcode.equals(validatecode)){

            User user = userService.login(model);
            if(user != null) {
                ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
                return HOME;
            } else {
                this.addActionError("用户名或者密码错误！");
                return LOGIN;
            }
        } else {
            this.addActionError("输入的验证码错误！");
            return LOGIN;
        }
    }

    public String logout(){

        ServletActionContext.getRequest().getSession().invalidate();
        return LOGIN;
    }
}
