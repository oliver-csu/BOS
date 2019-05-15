package ren.oliver.bos.dao;

import ren.oliver.bos.domain.SubArea;

import java.util.List;

public interface SubAreaDao extends BaseDao<SubArea> {

    List<Object> findSubareasGroupByProvince();
}
