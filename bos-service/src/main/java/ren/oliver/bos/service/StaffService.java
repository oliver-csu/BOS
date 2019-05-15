package ren.oliver.bos.service;

import ren.oliver.bos.domain.Staff;
import ren.oliver.bos.utils.PageBean;

import java.util.List;

public interface StaffService {

    void save(Staff staff);

    void pageQuery(PageBean pageBean);

    void deleteBatch(String ids);

    void update(Staff model);

    List<Staff> findListNotDelete();
}
