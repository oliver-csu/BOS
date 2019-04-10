package ren.oliver.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ren.oliver.bos.domain.Staff;
import ren.oliver.bos.service.StaffService;

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
        java2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize"});
        return NONE;
    }

    public String edit() {

        staffService.update(model);
        return LIST;
    }

    public String deleteBatch(){

        staffService.deleteBatch(ids);
        return LIST;
    }

    public String getIds() {

        return ids;
    }

    public void setIds(String ids) {

        this.ids = ids;
    }
}
