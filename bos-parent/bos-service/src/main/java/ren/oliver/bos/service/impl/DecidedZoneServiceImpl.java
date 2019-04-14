package ren.oliver.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ren.oliver.bos.dao.DecidedZoneDao;
import ren.oliver.bos.dao.SubAreaDao;
import ren.oliver.bos.domain.DecidedZone;
import ren.oliver.bos.domain.SubArea;
import ren.oliver.bos.sao.Customer;
import ren.oliver.bos.sao.CustomerService;
import ren.oliver.bos.service.DecidedZoneService;
import ren.oliver.bos.utils.PageBean;

import java.util.List;

@Service
@Transactional
public class DecidedZoneServiceImpl implements DecidedZoneService {

    @Autowired
    DecidedZoneDao decidedZoneDao;

    @Autowired
    SubAreaDao subAreaDao;

    @Autowired
    CustomerService customerService;

    @Override
    public void pageQuery(PageBean pageBean) {

        decidedZoneDao.pageQuery(pageBean);
    }

    @Override
    public void save(DecidedZone model, String[] subareaids) {

        decidedZoneDao.save(model);
        for (String subareaid : subareaids){
            SubArea subArea = subAreaDao.findById(subareaid);
            subArea.setDecidedZone(model);
        }
    }

    @Override
    public List<Customer> findListNotAssociation() {

        List<Customer> list = customerService.findListNotAssociation();
        return list;
    }

    @Override
    public List<Customer> findListHasAssociation(String decidedZoneId) {

        List<Customer> list = customerService.findListHasAssociation(decidedZoneId);
        return list;
    }

    @Override
    public void assignCustomersToDecidedZone(String decidedZoneId, List<Integer> customerIds) {

        customerService.assignCustomersToDecidedZone(decidedZoneId, customerIds);
    }
}
