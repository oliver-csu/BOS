package ren.oliver.bos.service;

import ren.oliver.bos.domain.SubArea;

import java.util.List;

public interface SubAreaService {

    void save(SubArea subArea);

    List<SubArea> findListNotAssociation();
}
