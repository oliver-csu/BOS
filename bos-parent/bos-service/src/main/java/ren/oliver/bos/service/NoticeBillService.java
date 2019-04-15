package ren.oliver.bos.service;

import ren.oliver.bos.domain.NoticeBill;
import ren.oliver.bos.sao.Customer;

public interface NoticeBillService {

    Customer findCustomerByTelephone(String telephone);

    void save(NoticeBill noticeBill);
}
