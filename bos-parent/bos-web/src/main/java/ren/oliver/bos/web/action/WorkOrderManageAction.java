package ren.oliver.bos.web.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ren.oliver.bos.domain.WorkOrderManage;
import ren.oliver.bos.service.WorkOrderManageService;

import java.io.IOException;

@Controller
@Scope("prototype")
public class WorkOrderManageAction extends BaseAction<WorkOrderManage> {

    @Autowired
    WorkOrderManageService workOrderManageService;

    public String add() throws IOException {

        String f = "1";
        try{
            workOrderManageService.save(model);
        }catch(Exception e){
            e.printStackTrace();
            f = "0";
        }
        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(f);

        return NONE;
    }
}
