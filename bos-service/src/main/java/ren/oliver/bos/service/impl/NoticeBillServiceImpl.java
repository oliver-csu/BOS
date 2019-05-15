package ren.oliver.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ren.oliver.bos.dao.DecidedZoneDao;
import ren.oliver.bos.dao.NoticeBillDao;
import ren.oliver.bos.dao.WorkBillDao;
import ren.oliver.bos.domain.DecidedZone;
import ren.oliver.bos.domain.NoticeBill;
import ren.oliver.bos.domain.Staff;
import ren.oliver.bos.domain.User;
import ren.oliver.bos.domain.WorkBill;
import ren.oliver.bos.sao.Customer;
import ren.oliver.bos.sao.CustomerService;
import ren.oliver.bos.service.NoticeBillService;
import ren.oliver.bos.utils.BOSUtils;

import java.sql.Timestamp;

@Service
@Transactional
public class NoticeBillServiceImpl implements NoticeBillService {

    @Autowired
    CustomerService customerService;

    @Autowired
    NoticeBillDao noticeBillDao;

    @Autowired
    DecidedZoneDao decidedZoneDao;

    @Autowired
    WorkBillDao workBillDao;

    @Override
    public Customer findCustomerByTelephone(String telephone) {

        return customerService.findCustomerByTelephone(telephone);
    }

    @Override
    public void save(NoticeBill noticeBill) {

        User user = BOSUtils.getLoginUser();
        noticeBill.setUser(user);
        noticeBillDao.save(noticeBill);

        String pickAddress = noticeBill.getPickAddress();
        String decidedZoneIdByAddress = customerService.findDecidedZoneIdByAddress(pickAddress);

        if (decidedZoneIdByAddress != null) {

            DecidedZone decidedZone = decidedZoneDao.findById(decidedZoneIdByAddress);
            Staff staff = decidedZone.getStaff();
            noticeBill.setStaff(staff);
            noticeBill.setOrderType(NoticeBill.ORDERTYPE_AUTO);

            WorkBill workBill = new WorkBill();
            workBill.setAttachBillTimes(0);
            workBill.setBuildTime(new Timestamp(System.currentTimeMillis()));
            workBill.setNoticeBill(noticeBill);
            workBill.setPickstate(WorkBill.PICKSTATE_NO);
            workBill.setRemark(noticeBill.getRemark());
            workBill.setStaff(staff);
            workBill.setType(WorkBill.TYPE_1);
            workBillDao.save(workBill);
        } else {

            noticeBill.setOrderType(NoticeBill.ORDERTYPE_MANUL);
        }
    }
}
