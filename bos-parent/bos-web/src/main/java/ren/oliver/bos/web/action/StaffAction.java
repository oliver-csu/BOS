package ren.oliver.bos.web.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ren.oliver.bos.domain.Staff;
import ren.oliver.bos.service.StaffService;

import java.util.List;

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
    private String ids;

    @Autowired
    StaffService staffService;

    public String add() {

        staffService.save(model);
        return LIST;
    }

    public String pageQuery() {

        staffService.pageQuery(pageBean);
        java2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize","decidedZones"});
        return NONE;
    }

    @RequiresPermissions("staff-edit")
    public String edit() {

        staffService.update(model);
        return LIST;
    }

    public String deleteBatch(){

        Subject subject = SecurityUtils.getSubject();
        subject.checkPermission("staff-delete");
        staffService.deleteBatch(ids);
        return LIST;
    }

    public String listajax(){

        List<Staff> list = staffService.findListNotDelete();
        this.java2Json(list, new String[]{"decidedZones"});
        return NONE;
    }

    public String getIds() {

        return ids;
    }

    public void setIds(String ids) {

        this.ids = ids;
    }
}
