package ren.oliver.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ren.oliver.bos.dao.RegionDao;
import ren.oliver.bos.domain.Region;
import ren.oliver.bos.service.RegionService;

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
}
