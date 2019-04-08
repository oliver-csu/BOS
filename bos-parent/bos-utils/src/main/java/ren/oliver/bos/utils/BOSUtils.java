package ren.oliver.bos.utils;

import org.apache.struts2.ServletActionContext;
import ren.oliver.bos.domain.User;

import javax.servlet.http.HttpSession;

public class BOSUtils {

    public static HttpSession getSession(){

        return ServletActionContext.getRequest().getSession();
    }

    public static User getLoginUser(){

        return (User) getSession().getAttribute("loginUser");
    }
}
