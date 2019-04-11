package ren.oliver.bos.dao;

import ren.oliver.bos.domain.Region;

import java.util.List;

public interface RegionDao extends BaseDao<Region> {

    List<Region> findListByQ(String q);
}
