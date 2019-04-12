package ren.oliver.bos.service;

import ren.oliver.bos.domain.DecidedZone;
import ren.oliver.bos.utils.PageBean;

public interface DecidedZoneService {

    void pageQuery(PageBean pageBean);

    void save(DecidedZone model, String[] subareaid);
}
