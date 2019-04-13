package ren.oliver.bos.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ren.oliver.bos.domain.Region;
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

    public String pageQuery() {

        DetachedCriteria dc = pageBean.getDetachedCriteria();
        String addresskey = model.getAddresskey();
        if(StringUtils.isNotBlank(addresskey)){
            dc.add(Restrictions.like("addresskey", "%"+addresskey+"%"));
        }
        Region region = model.getRegion();
        if(region != null){
            String province = region.getProvince();
            String city = region.getCity();
            String district = region.getDistrict();
            dc.createAlias("region", "r");
            if(StringUtils.isNotBlank(province)){
                dc.add(Restrictions.like("r.province", "%"+province+"%"));
            }
            if(StringUtils.isNotBlank(city)){
                dc.add(Restrictions.like("r.city", "%"+city+"%"));
            }
            if(StringUtils.isNotBlank(district)){
                dc.add(Restrictions.like("r.district", "%"+district+"%"));
            }
        }
        subAreaService.pageQuery(pageBean);
        java2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize","decidedZone","subAreas"});
        return NONE;
    }

    public String listajax() {

        List<SubArea> list = subAreaService.findListNotAssociation();
        this.java2Json(list, new String[]{"decidedzone","region"});
        return NONE;
    }
}
