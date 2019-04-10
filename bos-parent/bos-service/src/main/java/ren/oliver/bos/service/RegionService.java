package ren.oliver.bos.service;

import ren.oliver.bos.domain.Region;

import java.util.List;

public interface RegionService {

    void saveBatch(List<Region> regionList);
}
