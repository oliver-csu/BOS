package ren.oliver.bos.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Function implements Serializable {

    private String id;
    private Function parentFunction;
    private String name;
    private String code;
    private String description;
    private String page;
    private String generateMenu;
    private Integer zindex;
    private Set roles = new HashSet(0);
    private Set children = new HashSet(0);

    public Function() {

    }

    public Function(String id) {

        this.id = id;
    }

    public Function(String id, Function parentFunction, String name, String code, String description, String page, String generateMenu, Integer zindex, Set roles, Set children) {

        this.id = id;
        this.parentFunction = parentFunction;
        this.name = name;
        this.code = code;
        this.description = description;
        this.page = page;
        this.generateMenu = generateMenu;
        this.zindex = zindex;
        this.roles = roles;
        this.children = children;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public Function getParentFunction() {

        return parentFunction;
    }

    public void setParentFunction(Function parentFunction) {

        this.parentFunction = parentFunction;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getPage() {

        return page;
    }

    public void setPage(String page) {

        this.page = page;
    }

    public String getGenerateMenu() {

        return generateMenu;
    }

    public void setGenerateMenu(String generateMenu) {

        this.generateMenu = generateMenu;
    }

    public Integer getZindex() {

        return zindex;
    }

    public void setZindex(Integer zindex) {

        this.zindex = zindex;
    }

    public Set getRoles() {

        return roles;
    }

    public void setRoles(Set roles) {

        this.roles = roles;
    }

    public Set getChildren() {

        return children;
    }

    public void setChildren(Set children) {

        this.children = children;
    }

    public String getpId(){

        if(parentFunction == null){
            return "0";
        } else {
            return parentFunction.getId();
        }
    }

}
