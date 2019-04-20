package ren.oliver.bos.dao.impl;

import org.springframework.stereotype.Repository;
import ren.oliver.bos.dao.FunctionDao;
import ren.oliver.bos.domain.Function;

import java.util.List;

@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements FunctionDao {

    /**
     * 重写findAll，只查询父节点
     */
    public List<Function> findAll() {

        String hql = "FROM Function f WHERE f.parentFunction IS NULL";
        List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);
        return list;
    }
}
