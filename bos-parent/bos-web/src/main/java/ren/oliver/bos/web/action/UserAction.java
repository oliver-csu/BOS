package ren.oliver.bos.web.action;

import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ren.oliver.bos.domain.User;
import ren.oliver.bos.service.UserService;
import ren.oliver.bos.utils.BOSUtils;

import java.io.IOException;

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
}
