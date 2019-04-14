package ren.oliver.bos.sao;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.1
 * 2019-04-14T14:23:14.304+08:00
 * Generated source version: 3.3.1
 *
 */
@WebService(targetNamespace = "http://service.crm.oliver.ren/", name = "CustomerService")
@XmlSeeAlso({ObjectFactory.class})
public interface CustomerService {

    @WebMethod
    @RequestWrapper(localName = "findListHasAssociation", targetNamespace = "http://service.crm.oliver.ren/", className = "ren.oliver.bos.sao.FindListHasAssociation")
    @ResponseWrapper(localName = "findListHasAssociationResponse", targetNamespace = "http://service.crm.oliver.ren/", className = "ren.oliver.bos.sao.FindListHasAssociationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<Customer> findListHasAssociation(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0
    );

    @WebMethod
    @RequestWrapper(localName = "assignCustomersToDecidedZone", targetNamespace = "http://service.crm.oliver.ren/", className = "ren.oliver.bos.sao.AssignCustomersToDecidedZone")
    @ResponseWrapper(localName = "assignCustomersToDecidedZoneResponse", targetNamespace = "http://service.crm.oliver.ren/", className = "ren.oliver.bos.sao.AssignCustomersToDecidedZoneResponse")
    public void assignCustomersToDecidedZone(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0,
            @WebParam(name = "arg1", targetNamespace = "")
                    java.util.List<Integer> arg1
    );

    @WebMethod
    @RequestWrapper(localName = "findAll", targetNamespace = "http://service.crm.oliver.ren/", className = "ren.oliver.bos.sao.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://service.crm.oliver.ren/", className = "ren.oliver.bos.sao.FindAllResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<Customer> findAll();

    @WebMethod
    @RequestWrapper(localName = "findListNotAssociation", targetNamespace = "http://service.crm.oliver.ren/", className = "ren.oliver.bos.sao.FindListNotAssociation")
    @ResponseWrapper(localName = "findListNotAssociationResponse", targetNamespace = "http://service.crm.oliver.ren/", className = "ren.oliver.bos.sao.FindListNotAssociationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<Customer> findListNotAssociation();
}
