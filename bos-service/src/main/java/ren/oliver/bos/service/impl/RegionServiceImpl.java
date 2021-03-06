package ren.oliver.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ren.oliver.bos.dao.RegionDao;
import ren.oliver.bos.domain.Region;
import ren.oliver.bos.service.RegionService;
import ren.oliver.bos.utils.PageBean;

import java.util.List;

@Service
@Transactional
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionDao regionDao;

    @Override
    public void saveBatch(List<Region> regionList) {

        for ( Region region : regionList) {
            regionDao.saveOrUpdate(region);
        }
    }

    @Override
    public void pageQuery(PageBean pageBean) {

        regionDao.pageQuery(pageBean);
    }

    @Override
    public List<Region> findAll() {

        return regionDao.findAll();
    }

    @Override
    public List<Region> findListByQ(String q) {

        return regionDao.findListByQ(q);
    }
}
