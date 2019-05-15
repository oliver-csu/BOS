package ren.oliver.bos.web.action;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import ren.oliver.bos.utils.PageBean;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	private static final long serialVersionUID = -5593155892446592382L;
	
	public static final String HOME = "home";
	public static final String LIST = "list";

	protected T model;

    protected PageBean pageBean = new PageBean();

    public void setPage(int page) {

        pageBean.setCurrentPage(page);
    }

    public void setRows(int rows) {

        pageBean.setPageSize(rows);
    }
	
	public T getModel() {
		
		return this.model;
	}

    public void setModel(T model) {

        this.model = model;
    }
	
	public BaseAction() {
		
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		Class<T> entityClass = (Class<T>) actualTypeArguments[0];
		pageBean.setDetachedCriteria(DetachedCriteria.forClass(entityClass));
		try {
			model = entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

    public void java2Json(Object o ,String[] exclueds){

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(exclueds);
        String json = JSONObject.fromObject(o,jsonConfig).toString();
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        try {
            ServletActionContext.getResponse().getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void java2Json(List o , String[] exclueds){

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(exclueds);
        String json = JSONArray.fromObject(o,jsonConfig).toString();
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        try {
            ServletActionContext.getResponse().getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
