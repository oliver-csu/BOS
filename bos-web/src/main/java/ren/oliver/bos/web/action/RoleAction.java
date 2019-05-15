package ren.oliver.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ren.oliver.bos.domain.Role;
import ren.oliver.bos.service.RoleService;

import java.util.List;

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

    /**
     * 分页查询
     */
    public String pageQuery(){

        roleService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"functions","users"});
        return NONE;
    }

    /**
     * 查询所有的角色数据，返回json
     */
    public String listajax(){

        List<Role> list = roleService.findAll();
        this.java2Json(list, new String[]{"functions","users"});
        return NONE;
    }

    public String getFunctionIds() {

        return functionIds;
    }

    public void setFunctionIds(String functionIds) {

        this.functionIds = functionIds;
    }
}
