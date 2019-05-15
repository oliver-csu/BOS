package ren.oliver.bos.dao.impl;

import org.springframework.stereotype.Repository;
import ren.oliver.bos.dao.RegionDao;
import ren.oliver.bos.domain.Region;

import java.util.List;

@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements RegionDao {

    public List<Region> findListByQ(String q) {

        String hql = "FROM Region r WHERE r.shortcode LIKE ? ";
        hql += "OR r.citycode LIKE ? OR r.province LIKE ? ";
        hql += "OR r.city LIKE ? OR r.district LIKE ?";
        List<Region> list = (List<Region>) this.getHibernateTemplate().find(hql, "%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%");
        return list;
    }
}
