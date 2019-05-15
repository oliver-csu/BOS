package ren.oliver.bos.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ren.oliver.bos.dao.RoleDao;
import ren.oliver.bos.domain.Function;
import ren.oliver.bos.domain.Role;
import ren.oliver.bos.service.RoleService;
import ren.oliver.bos.utils.PageBean;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    /**
     * 保存角色并关联权限
     * @param model
     * @param functionIds
     */
    @Override
    public void save(Role model, String functionIds) {

        roleDao.save(model);
        if(StringUtils.isNotBlank(functionIds)){
            String[] fIds = functionIds.split(",");
            for (String functionId : fIds) {
                // 手动构造一个权限对象，设置id，对象状态为托管状态
                Function function = new Function(functionId);
                // 角色关联权限
                model.getFunctions().add(function);
            }
        }
    }

    @Override
    public void pageQuery(PageBean pageBean) {

        roleDao.pageQuery(pageBean);
    }

    @Override
    public List<Role> findAll() {

        return roleDao.findAll();
    }


}
