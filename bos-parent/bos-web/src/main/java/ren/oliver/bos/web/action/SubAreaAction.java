package ren.oliver.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ren.oliver.bos.domain.SubArea;
import ren.oliver.bos.service.SubAreaService;

import java.util.List;

@Controller
@Scope("prototype")
public class SubAreaAction extends BaseAction<SubArea> {

    @Autowired
    SubAreaService subAreaService;

    public String add() {

        subAreaService.save(model);
        return LIST;
    }

    public String listajax() {

        List<SubArea> list = subAreaService.findListNotAssociation();
        this.java2Json(list, new String[]{"decidedzone","region"});
        return NONE;
    }
}
