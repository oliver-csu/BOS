package ren.oliver.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ren.oliver.bos.domain.NoticeBill;
import ren.oliver.bos.sao.Customer;
import ren.oliver.bos.service.NoticeBillService;

@Controller
@Scope("prototype")
public class NoticeBillAction extends BaseAction<NoticeBill> {

    public static final String ADD = "add";

    @Autowired
    NoticeBillService noticeBillService;

    public String findCustomerByTelephone() {

        String telephone = model.getTelephone();
        Customer customer = noticeBillService.findCustomerByTelephone(telephone);
        java2Json(customer, new String[]{});
        return NONE;
    }

    public String add(){

        noticeBillService.save(model);
        return ADD;
    }
}
