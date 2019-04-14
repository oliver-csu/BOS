package ren.oliver.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ren.oliver.bos.domain.DecidedZone;
import ren.oliver.bos.sao.Customer;
import ren.oliver.bos.service.DecidedZoneService;

import java.util.List;

@Controller
@Scope("prototype")
public class DecidedZoneAction extends BaseAction<DecidedZone> {

    private String[] subareaid;
    private List<Integer> customerIds;

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

    public String findListNotAssociation(){

        List<Customer> list = decidedZoneService.findListNotAssociation();
        this.java2Json(list, new String[]{});
        return NONE;
    }

    public String findListHasAssociation(){

        String id = model.getId();
        List<Customer> list = decidedZoneService.findListHasAssociation(id);
        this.java2Json(list, new String[]{});
        return NONE;
    }

    public String assignCustomersToDecidedZone(){

        decidedZoneService.assignCustomersToDecidedZone(model.getId(), customerIds);
        return LIST;
    }

    public void setSubareaid(String[] subareaid) {

        this.subareaid = subareaid;
    }

    public void setCustomerIds(List<Integer> customerIds) {

        this.customerIds = customerIds;
    }
}
