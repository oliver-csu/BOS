package ren.oliver.bos.web.interceptor;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import ren.oliver.bos.domain.User;
import ren.oliver.bos.utils.BOSUtils;

public class LoginInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {

        User user = BOSUtils.getLoginUser();
        if(user == null){
            return "login";
        }
        return invocation.invoke();
    }
}
