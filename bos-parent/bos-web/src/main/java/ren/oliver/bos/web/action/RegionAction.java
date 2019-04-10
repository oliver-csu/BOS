package ren.oliver.bos.web.action;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ren.oliver.bos.domain.Region;
import ren.oliver.bos.service.RegionService;
import ren.oliver.bos.utils.PageBean;
import ren.oliver.bos.utils.PinYin4jUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region> {

    private int page;
    private int rows;
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

    public String pageQuery() throws IOException {

        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(rows);
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Region.class);
        pageBean.setDetachedCriteria(detachedCriteria);

        regionService.pageQuery(pageBean);

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"currentPage","detachedCriteria","pageSize","subAreas"});
        String json = JSONObject.fromObject(pageBean, jsonConfig).toString();
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(json);

        return NONE;
    }

    public int getPage() {

        return page;
    }

    public void setPage(int page) {

        this.page = page;
    }

    public int getRows() {

        return rows;
    }

    public void setRows(int rows) {

        this.rows = rows;
    }

    public void setRegionFile(File regionFile) {

        this.regionFile = regionFile;
    }

    public File getRegionFile() {

        return this.regionFile;
    }
}
