package ren.oliver.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ren.oliver.bos.dao.SubAreaDao;
import ren.oliver.bos.domain.SubArea;
import ren.oliver.bos.service.SubAreaService;

@Service
@Transactional
public class SubAreaServiceImpl implements SubAreaService {

    @Autowired
    SubAreaDao subAreaDao;

    @Override
    public void save(SubArea subArea) {

        subAreaDao.save(subArea);
    }
}
