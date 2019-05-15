package ren.oliver.bos.service;

import ren.oliver.bos.domain.Role;
import ren.oliver.bos.utils.PageBean;

import java.util.List;

public interface RoleService {

    void save(Role model, String functionIds);

    void pageQuery(PageBean pageBean);

    List<Role> findAll();
}
