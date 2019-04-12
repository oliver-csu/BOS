package ren.oliver.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ren.oliver.bos.dao.DecidedZoneDao;
import ren.oliver.bos.domain.DecidedZone;
import ren.oliver.bos.service.DecidedZoneService;
import ren.oliver.bos.utils.PageBean;

@Service
@Transactional
public class DecidedZoneServiceImpl implements DecidedZoneService {

    @Autowired
    DecidedZoneDao decidedZoneDao;

    @Override
    public void pageQuery(PageBean pageBean) {

        decidedZoneDao.pageQuery(pageBean);
    }

    @Override
    public void save(DecidedZone model, String[] subareaid) {

    }
}
