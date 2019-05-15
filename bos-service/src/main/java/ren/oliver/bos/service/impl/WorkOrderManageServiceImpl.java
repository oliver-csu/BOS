package ren.oliver.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ren.oliver.bos.dao.WorkOrderManageDao;
import ren.oliver.bos.domain.WorkOrderManage;
import ren.oliver.bos.service.WorkOrderManageService;

@Service
@Transactional
public class WorkOrderManageServiceImpl implements WorkOrderManageService {

    @Autowired
    WorkOrderManageDao workOrderManageDao;

    @Override
    public void save(WorkOrderManage workOrderManage) {

        workOrderManageDao.save(workOrderManage);
    }
}
