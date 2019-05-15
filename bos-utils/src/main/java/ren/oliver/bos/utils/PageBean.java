package ren.oliver.bos.utils;

import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class PageBean {

    private int currentPage;
    private int pageSize;
    private DetachedCriteria detachedCriteria;
    private int total;
    private List rows;

    public int getCurrentPage() {

        return currentPage;
    }

    public void setCurrentPage(int currentPage) {

        this.currentPage = currentPage;
    }

    public int getPageSize() {

        return pageSize;
    }

    public void setPageSize(int pageSize) {

        this.pageSize = pageSize;
    }

    public DetachedCriteria getDetachedCriteria() {

        return detachedCriteria;
    }

    public void setDetachedCriteria(DetachedCriteria detachedCriteria) {

        this.detachedCriteria = detachedCriteria;
    }

    public int getTotal() {

        return total;
    }

    public void setTotal(int total) {

        this.total = total;
    }

    public List getRows() {

        return rows;
    }

    public void setRows(List rows) {

        this.rows = rows;
    }
}
