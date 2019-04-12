package ren.oliver.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ren.oliver.bos.domain.DecidedZone;
import ren.oliver.bos.service.DecidedZoneService;

@Controller
@Scope("prototype")
public class DecidedZoneAction extends BaseAction<DecidedZone> {

    private String[] subareaid;

    @Autowired
    DecidedZoneService decidedZoneService;

    public String pageQuery() {

        decidedZoneService.pageQuery(pageBean);
        java2Json(pageBean, new String[]{"currentPage", "pageSize", "detachedCriteria", "subAreas", "decidedZones"});
        return NONE;
    }

    public String add(){

        decidedZoneService.save(model, subareaid);
        return LIST;
    }

    public void setSubareaid(String[] subareaid) {

        this.subareaid = subareaid;
    }
}
