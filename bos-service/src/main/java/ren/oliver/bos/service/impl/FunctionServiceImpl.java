package ren.oliver.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ren.oliver.bos.dao.FunctionDao;
import ren.oliver.bos.domain.Function;
import ren.oliver.bos.domain.User;
import ren.oliver.bos.service.FunctionService;
import ren.oliver.bos.utils.BOSUtils;
import ren.oliver.bos.utils.PageBean;

import java.util.List;

@Service
@Transactional
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    FunctionDao functionDao;

    @Override
    public List<Function> findAll() {

        return functionDao.findAll();
    }

    @Override
    public void save(Function model) {

        // 将pid的空串改为null
        Function parentFunction = model.getParentFunction();
        if(parentFunction != null && parentFunction.getId().equals("")){
            model.setParentFunction(null);
        }
        functionDao.save(model);
    }

    @Override
    public void pageQuery(PageBean pageBean) {

        functionDao.pageQuery(pageBean);
    }

    @Override
    public List<Function> findMenu() {

        List<Function> list = null;
        User user = BOSUtils.getLoginUser();
        if(user.getUsername().equals("admin")){
            //如果是超级管理员内置用户，查询所有菜单
            list = functionDao.findAllMenu();
        }else{
            //其他用户，根据用户id查询菜单
            list = functionDao.findMenuByUserId(user.getId());
        }
        return list;
    }
}
