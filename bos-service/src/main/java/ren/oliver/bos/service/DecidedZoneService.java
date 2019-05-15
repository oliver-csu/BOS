package ren.oliver.bos.service;

import ren.oliver.bos.domain.DecidedZone;
import ren.oliver.bos.sao.Customer;
import ren.oliver.bos.utils.PageBean;

import java.util.List;

public interface DecidedZoneService {

    void pageQuery(PageBean pageBean);

    void save(DecidedZone model, String[] subareaid);

    List<Customer> findListNotAssociation();

    List<Customer> findListHasAssociation(String decidedZoneId);

    void assignCustomersToDecidedZone(String decidedZoneId, List<Integer> customerIds);
}
