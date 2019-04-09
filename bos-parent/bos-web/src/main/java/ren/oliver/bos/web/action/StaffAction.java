package ren.oliver.bos.web.action;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ren.oliver.bos.domain.Staff;
import ren.oliver.bos.service.StaffService;
import ren.oliver.bos.utils.PageBean;

import java.io.IOException;

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {

    private int page;
    private int rows;
    private String ids;

    @Autowired
    StaffService staffService;

    public String add() {

        staffService.save(model);
        return LIST;
    }

    public String pageQuery() throws IOException {

        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(rows);
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
        pageBean.setDetachedCriteria(detachedCriteria);

        staffService.pageQuery(pageBean);

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"currentPage","detachedCriteria","pageSize"});
        String json = JSONObject.fromObject(pageBean, jsonConfig).toString();
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(json);

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

    public int getPage() {

        return page;
    }

    public void setPage(int page) {

        this.page = page;
    }

    public int getRows() {

        return rows;
    }

    public void setRows(int rows) {

        this.rows = rows;
    }

    public String getIds() {

        return ids;
    }

    public void setIds(String ids) {

        this.ids = ids;
    }
}
