package ren.oliver.bos.service;

import ren.oliver.bos.domain.SubArea;
import ren.oliver.bos.utils.PageBean;

import java.util.List;

public interface SubAreaService {

    void save(SubArea subArea);

    List<SubArea> findListNotAssociation();

    void pageQuery(PageBean pageBean);

    List<SubArea> findAll();

    List<SubArea> findListByDecidedzoneId(String decidedZoneId);

    List<Object> findSubareasGroupByProvince();
}
