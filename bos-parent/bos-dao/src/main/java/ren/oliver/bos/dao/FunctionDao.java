package ren.oliver.bos.dao;

import ren.oliver.bos.domain.Function;

import java.util.List;

public interface FunctionDao extends BaseDao<Function> {

    List<Function> findFunctionListByUserId(String id);
}
