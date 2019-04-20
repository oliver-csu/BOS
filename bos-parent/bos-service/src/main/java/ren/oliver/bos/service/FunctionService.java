package ren.oliver.bos.service;

import ren.oliver.bos.domain.Function;
import ren.oliver.bos.utils.PageBean;

import java.util.List;

public interface FunctionService {

    List<Function> findAll();

    void save(Function model);

    void pageQuery(PageBean pageBean);
}
