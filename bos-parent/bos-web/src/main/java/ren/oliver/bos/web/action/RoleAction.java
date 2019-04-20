package ren.oliver.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ren.oliver.bos.domain.Role;
import ren.oliver.bos.service.RoleService;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

    // 权限的id
    private String functionIds;

    @Autowired
    RoleService roleService;

    /**
     * 添加角色
     */
    public String add(){

        roleService.save(model,functionIds);
        return LIST;
    }



    public String getFunctionIds() {

        return functionIds;
    }

    public void setFunctionIds(String functionIds) {

        this.functionIds = functionIds;
    }
}
