
package ren.oliver.bos.sao;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ren.oliver.bos.sao package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindListHasAssociation_QNAME = new QName("http://service.crm.oliver.ren/", "findListHasAssociation");
    private final static QName _FindListHasAssociationResponse_QNAME = new QName("http://service.crm.oliver.ren/", "findListHasAssociationResponse");
    private final static QName _AssignCustomersToDecidedZone_QNAME = new QName("http://service.crm.oliver.ren/", "assignCustomersToDecidedZone");
    private final static QName _AssignCustomersToDecidedZoneResponse_QNAME = new QName("http://service.crm.oliver.ren/", "assignCustomersToDecidedZoneResponse");
    private final static QName _FindAll_QNAME = new QName("http://service.crm.oliver.ren/", "findAll");
    private final static QName _FindAllResponse_QNAME = new QName("http://service.crm.oliver.ren/", "findAllResponse");
    private final static QName _FindListNotAssociation_QNAME = new QName("http://service.crm.oliver.ren/", "findListNotAssociation");
    private final static QName _FindListNotAssociationResponse_QNAME = new QName("http://service.crm.oliver.ren/", "findListNotAssociationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ren.oliver.bos.sao
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindListHasAssociation }
     * 
     */
    public FindListHasAssociation createFindListHasAssociation() {
        return new FindListHasAssociation();
    }

    /**
     * Create an instance of {@link FindListHasAssociationResponse }
     * 
     */
    public FindListHasAssociationResponse createFindListHasAssociationResponse() {
        return new FindListHasAssociationResponse();
    }

    /**
     * Create an instance of {@link AssignCustomersToDecidedZone }
     * 
     */
    public AssignCustomersToDecidedZone createAssignCustomersToDecidedZone() {
        return new AssignCustomersToDecidedZone();
    }

    /**
     * Create an instance of {@link AssignCustomersToDecidedZoneResponse }
     * 
     */
    public AssignCustomersToDecidedZoneResponse createAssignCustomersToDecidedZoneResponse() {
        return new AssignCustomersToDecidedZoneResponse();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link FindListNotAssociation }
     * 
     */
    public FindListNotAssociation createFindListNotAssociation() {
        return new FindListNotAssociation();
    }

    /**
     * Create an instance of {@link FindListNotAssociationResponse }
     * 
     */
    public FindListNotAssociationResponse createFindListNotAssociationResponse() {
        return new FindListNotAssociationResponse();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindListHasAssociation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindListHasAssociation }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.crm.oliver.ren/", name = "findListHasAssociation")
    public JAXBElement<FindListHasAssociation> createFindListHasAssociation(FindListHasAssociation value) {
        return new JAXBElement<FindListHasAssociation>(_FindListHasAssociation_QNAME, FindListHasAssociation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindListHasAssociationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindListHasAssociationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.crm.oliver.ren/", name = "findListHasAssociationResponse")
    public JAXBElement<FindListHasAssociationResponse> createFindListHasAssociationResponse(FindListHasAssociationResponse value) {
        return new JAXBElement<FindListHasAssociationResponse>(_FindListHasAssociationResponse_QNAME, FindListHasAssociationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignCustomersToDecidedZone }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AssignCustomersToDecidedZone }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.crm.oliver.ren/", name = "assignCustomersToDecidedZone")
    public JAXBElement<AssignCustomersToDecidedZone> createAssignCustomersToDecidedZone(AssignCustomersToDecidedZone value) {
        return new JAXBElement<AssignCustomersToDecidedZone>(_AssignCustomersToDecidedZone_QNAME, AssignCustomersToDecidedZone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignCustomersToDecidedZoneResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AssignCustomersToDecidedZoneResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.crm.oliver.ren/", name = "assignCustomersToDecidedZoneResponse")
    public JAXBElement<AssignCustomersToDecidedZoneResponse> createAssignCustomersToDecidedZoneResponse(AssignCustomersToDecidedZoneResponse value) {
        return new JAXBElement<AssignCustomersToDecidedZoneResponse>(_AssignCustomersToDecidedZoneResponse_QNAME, AssignCustomersToDecidedZoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.crm.oliver.ren/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.crm.oliver.ren/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindListNotAssociation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindListNotAssociation }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.crm.oliver.ren/", name = "findListNotAssociation")
    public JAXBElement<FindListNotAssociation> createFindListNotAssociation(FindListNotAssociation value) {
        return new JAXBElement<FindListNotAssociation>(_FindListNotAssociation_QNAME, FindListNotAssociation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindListNotAssociationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindListNotAssociationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.crm.oliver.ren/", name = "findListNotAssociationResponse")
    public JAXBElement<FindListNotAssociationResponse> createFindListNotAssociationResponse(FindListNotAssociationResponse value) {
        return new JAXBElement<FindListNotAssociationResponse>(_FindListNotAssociationResponse_QNAME, FindListNotAssociationResponse.class, null, value);
    }

}
