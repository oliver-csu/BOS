package ren.oliver.bos.dao.impl;

import org.springframework.stereotype.Repository;
import ren.oliver.bos.dao.SubAreaDao;
import ren.oliver.bos.domain.SubArea;

import java.util.List;

@Repository
public class SubAreaDaoImpl extends BaseDaoImpl<SubArea> implements SubAreaDao {

    @Override
    public List<Object> findSubareasGroupByProvince() {

        String hql = "SELECT r.province ,count(*) FROM SubArea s LEFT OUTER JOIN s.region r Group BY r.province";
        return (List<Object>) this.getHibernateTemplate().find(hql);
    }
}
