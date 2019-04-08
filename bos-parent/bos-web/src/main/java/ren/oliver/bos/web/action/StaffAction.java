package ren.oliver.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ren.oliver.bos.domain.Staff;
import ren.oliver.bos.service.StaffService;

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {

    @Autowired
    StaffService staffService;

    public String add() {

        staffService.save(model);
        return LIST;
    }

}
