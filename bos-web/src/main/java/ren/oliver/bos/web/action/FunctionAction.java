package ren.oliver.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ren.oliver.bos.domain.Function;
import ren.oliver.bos.service.FunctionService;

import java.util.List;

@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<Function> {

    @Autowired
    FunctionService functionService;

    /**
     * 查询所有权限，返回json数据
     */
    public String listajax(){
        List<Function> list = functionService.findAll();
        this.java2Json(list, new String[]{"parentFunction","roles"});
        return NONE;
    }

    /**
     * 添加权限
     */
    public String add(){

        functionService.save(model);
        return LIST;
    }

    /**
     * 分页查询
     * @return
     */
    public String pageQuery(){

        String page = model.getPage();
        pageBean.setCurrentPage(Integer.parseInt(page));
        functionService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"detachedCriteria", "parentFunction","roles","children"});
        return NONE;
    }

    /**
     * 根据当前登录人查询对应的菜单数据，返回json
     */
    public String findMenu() {

        List<Function> list = functionService.findMenu();
        this.java2Json(list, new String[]{"parentFunction","roles","children"});
        return NONE;
    }

}
