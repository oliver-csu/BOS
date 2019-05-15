package ren.oliver.bos.service;

import ren.oliver.bos.domain.Region;
import ren.oliver.bos.utils.PageBean;

import java.util.List;

public interface RegionService {

    void saveBatch(List<Region> regionList);

    void pageQuery(PageBean pageBean);

    List<Region> findAll();

    List<Region> findListByQ(String q);
}
