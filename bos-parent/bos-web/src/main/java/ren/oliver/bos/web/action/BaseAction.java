package ren.oliver.bos.web.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction<T> extends ActionSupport {

	private static final long serialVersionUID = -5593155892446592382L;
	
	public static final String HOME = "home";

	protected T model;
	
	public T getModel() {
		
		return this.model;
	}
	
	public BaseAction() {
		
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		Class<T> entityClass = (Class<T>) actualTypeArguments[0];
		try {
			model = entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
