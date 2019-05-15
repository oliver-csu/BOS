package ren.oliver.bos.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ren.oliver.bos.dao.StaffDao;
import ren.oliver.bos.domain.Staff;
import ren.oliver.bos.service.StaffService;
import ren.oliver.bos.utils.PageBean;

import java.util.List;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffDao staffDao;

    @Override
    public void save(Staff staff) {

        staffDao.save(staff);
    }

    @Override
    public void pageQuery(PageBean pageBean) {

        staffDao.pageQuery(pageBean);
    }

    @Override
    public void deleteBatch(String ids) {

        if (StringUtils.isNotBlank(ids)) {
            String[] staffIds = ids.split(",");
            for (String id : staffIds) {
                staffDao.executeUpdate("staff.delete", id);
            }
        }
    }

    public void update(Staff model) {

        Staff staff = staffDao.findById(model.getId());
        staff.setName(model.getName());
        staff.setTelephone(model.getTelephone());
        staff.setHaspda(model.getHaspda());
        staff.setStandard(model.getStandard());
        staff.setStation(model.getStation());
        staffDao.update(staff);
    }

    @Override
    public List<Staff> findListNotDelete() {

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
        detachedCriteria.add(Restrictions.eq("deltag", "0"));
        return staffDao.findByCriteria(detachedCriteria);
    }
}
