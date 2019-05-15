package ren.oliver.bos.web.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ren.oliver.bos.domain.Region;
import ren.oliver.bos.service.RegionService;
import ren.oliver.bos.utils.PinYin4jUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region> {

    private String q;
    private File regionFile;

    @Autowired
    RegionService regionService;

    public String importXls() throws IOException {

        List<Region> regionList = new ArrayList<Region>();

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(regionFile));

        HSSFSheet hssfSheet = hssfWorkbook.getSheet("Sheet1");

        for (Row row : hssfSheet) {

            int rowNum =  row.getRowNum();

            if (rowNum == 0) {

                continue;
            }

            String id = row.getCell(0).getStringCellValue();
            String province = row.getCell(1).getStringCellValue();
            String city = row.getCell(2).getStringCellValue();
            String district = row.getCell(3).getStringCellValue();
            String postcode = row.getCell(4).getStringCellValue();
            province = province.substring(0, province.length() - 1);
            city = city.substring(0, city.length() - 1);
            district = district.substring(0, district.length() - 1);
            String info = province + city + district;
            String[] headByString = PinYin4jUtils.getHeadByString(info);
            String shortcode = StringUtils.join(headByString);
            String citycode = PinYin4jUtils.hanziToPinyin(city, "");
            Region region = new Region(id, province, city, district, postcode, shortcode, citycode, null);
            regionList.add(region);
        }
        regionService.saveBatch(regionList);

        return NONE;
    }

    public String pageQuery() {

        regionService.pageQuery(pageBean);
        java2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize","subAreas"});
        return NONE;
    }

    public void setRegionFile(File regionFile) {

        this.regionFile = regionFile;
    }

    public String listajax() {

        List<Region> regionList = null;
        if (StringUtils.isNotBlank(q)) {
            regionList = regionService.findListByQ(q);
        } else {
            regionList = regionService.findAll();
        }
        java2Json(regionList, new String[]{"subAreas"});

        return NONE;
    }

    public File getRegionFile() {

        return this.regionFile;
    }

    public String getQ() {

        return q;
    }

    public void setQ(String q) {

        this.q = q;
    }
}
