package ren.oliver.bos.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ren.oliver.bos.dao.SubAreaDao;
import ren.oliver.bos.domain.SubArea;
import ren.oliver.bos.service.SubAreaService;
import ren.oliver.bos.utils.PageBean;

import java.util.List;

@Service
@Transactional
public class SubAreaServiceImpl implements SubAreaService {

    @Autowired
    SubAreaDao subAreaDao;

    @Override
    public void save(SubArea subArea) {

        subAreaDao.save(subArea);
    }

    @Override
    public List<SubArea> findListNotAssociation() {

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SubArea.class);
        detachedCriteria.add(Restrictions.isNull("decidedZone"));
        return subAreaDao.findByCriteria(detachedCriteria);
    }

    @Override
    public void pageQuery(PageBean pageBean) {

        subAreaDao.pageQuery(pageBean);
    }

    @Override
    public List<SubArea> findAll() {

        return subAreaDao.findAll();
    }
}
