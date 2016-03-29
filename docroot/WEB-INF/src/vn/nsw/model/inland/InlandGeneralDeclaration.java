//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.08 at 05:04:48 PM ICT 
//


package vn.nsw.model.inland;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocumentName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DocumentYear" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UserCreated" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isArrival" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NameOfShip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ShipTypeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CallSign" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PortOfArrivalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DateOfArrival" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PortHarbourCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PortRegionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PortWharfCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NameOfMaster" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LastPortOfCallCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TaxCodeOfShipownersAgents" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NameOfShipownersAgents" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ShipAgencyAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ShipAgencyPhone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ShipAgencyFax" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ShipAgencyEmail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BriefDescriptionOfTheCargo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SignPlace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SignDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MasterSigned" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "documentName",
    "documentYear",
    "userCreated",
    "isArrival",
    "nameOfShip",
    "shipTypeCode",
    "callSign",
    "portOfArrivalCode",
    "dateOfArrival",
    "portHarbourCode",
    "portRegionCode",
    "portWharfCode",
    "nameOfMaster",
    "lastPortOfCallCode",
    "taxCodeOfShipownersAgents",
    "nameOfShipownersAgents",
    "shipAgencyAddress",
    "shipAgencyPhone",
    "shipAgencyFax",
    "shipAgencyEmail",
    "briefDescriptionOfTheCargo",
    "remarks",
    "signPlace",
    "signDate",
    "masterSigned"
})
@XmlRootElement(name = "InlandGeneralDeclaration")
public class InlandGeneralDeclaration {

    @XmlElement(name = "DocumentName", required = true)
    protected String documentName;
    @XmlElement(name = "DocumentYear", required = true)
    protected String documentYear;
    @XmlElement(name = "UserCreated", required = true)
    protected String userCreated;
    @XmlElement(name = "IsArrival", required = true)
    protected String isArrival;
    @XmlElement(name = "NameOfShip", required = true)
    protected String nameOfShip;
    @XmlElement(name = "ShipTypeCode", required = true)
    protected String shipTypeCode;
    @XmlElement(name = "CallSign", required = true)
    protected String callSign;
    @XmlElement(name = "PortOfArrivalCode", required = true)
    protected String portOfArrivalCode;
    @XmlElement(name = "DateOfArrival", required = true)
    protected String dateOfArrival;
    @XmlElement(name = "PortHarbourCode", required = true)
    protected String portHarbourCode;
    @XmlElement(name = "PortRegionCode", required = true)
    protected String portRegionCode;
    @XmlElement(name = "PortWharfCode", required = true)
    protected String portWharfCode;
    @XmlElement(name = "NameOfMaster", required = true)
    protected String nameOfMaster;
    @XmlElement(name = "LastPortOfCallCode", required = true)
    protected String lastPortOfCallCode;
    @XmlElement(name = "TaxCodeOfShipownersAgents", required = true)
    protected String taxCodeOfShipownersAgents;
    @XmlElement(name = "NameOfShipownersAgents", required = true)
    protected String nameOfShipownersAgents;
    @XmlElement(name = "ShipAgencyAddress", required = true)
    protected String shipAgencyAddress;
    @XmlElement(name = "ShipAgencyPhone", required = true)
    protected String shipAgencyPhone;
    @XmlElement(name = "ShipAgencyFax", required = true)
    protected String shipAgencyFax;
    @XmlElement(name = "ShipAgencyEmail", required = true)
    protected String shipAgencyEmail;
    @XmlElement(name = "BriefDescriptionOfTheCargo", required = true)
    protected String briefDescriptionOfTheCargo;
    @XmlElement(name = "Remarks", required = true)
    protected String remarks;
    @XmlElement(name = "SignPlace", required = true)
    protected String signPlace;
    @XmlElement(name = "SignDate", required = true)
    protected String signDate;
    @XmlElement(name = "MasterSigned", required = true)
    protected String masterSigned;

    /**
     * Gets the value of the documentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentName() {
        return documentName;
    }

    /**
     * Sets the value of the documentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentName(String value) {
        this.documentName = value;
    }

    /**
     * Gets the value of the documentYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentYear() {
        return documentYear;
    }

    /**
     * Sets the value of the documentYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentYear(String value) {
        this.documentYear = value;
    }

    /**
     * Gets the value of the userCreated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserCreated() {
        return userCreated;
    }

    /**
     * Sets the value of the userCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserCreated(String value) {
        this.userCreated = value;
    }

    /**
     * Gets the value of the isArrival property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsArrival() {
        return isArrival;
    }

    /**
     * Sets the value of the isArrival property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsArrival(String value) {
        this.isArrival = value;
    }

    /**
     * Gets the value of the nameOfShip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOfShip() {
        return nameOfShip;
    }

    /**
     * Sets the value of the nameOfShip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOfShip(String value) {
        this.nameOfShip = value;
    }

    /**
     * Gets the value of the shipTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipTypeCode() {
        return shipTypeCode;
    }

    /**
     * Sets the value of the shipTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipTypeCode(String value) {
        this.shipTypeCode = value;
    }

    /**
     * Gets the value of the callSign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallSign() {
        return callSign;
    }

    /**
     * Sets the value of the callSign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallSign(String value) {
        this.callSign = value;
    }

    /**
     * Gets the value of the portOfArrivalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortOfArrivalCode() {
        return portOfArrivalCode;
    }

    /**
     * Sets the value of the portOfArrivalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortOfArrivalCode(String value) {
        this.portOfArrivalCode = value;
    }

    /**
     * Gets the value of the dateOfArrival property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfArrival() {
        return dateOfArrival;
    }

    /**
     * Sets the value of the dateOfArrival property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfArrival(String value) {
        this.dateOfArrival = value;
    }

    /**
     * Gets the value of the portHarbourCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortHarbourCode() {
        return portHarbourCode;
    }

    /**
     * Sets the value of the portHarbourCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortHarbourCode(String value) {
        this.portHarbourCode = value;
    }

    /**
     * Gets the value of the portRegionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortRegionCode() {
        return portRegionCode;
    }

    /**
     * Sets the value of the portRegionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortRegionCode(String value) {
        this.portRegionCode = value;
    }

    /**
     * Gets the value of the portWharfCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortWharfCode() {
        return portWharfCode;
    }

    /**
     * Sets the value of the portWharfCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortWharfCode(String value) {
        this.portWharfCode = value;
    }

    /**
     * Gets the value of the nameOfMaster property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOfMaster() {
        return nameOfMaster;
    }

    /**
     * Sets the value of the nameOfMaster property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOfMaster(String value) {
        this.nameOfMaster = value;
    }

    /**
     * Gets the value of the lastPortOfCallCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastPortOfCallCode() {
        return lastPortOfCallCode;
    }

    /**
     * Sets the value of the lastPortOfCallCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastPortOfCallCode(String value) {
        this.lastPortOfCallCode = value;
    }

    /**
     * Gets the value of the taxCodeOfShipownersAgents property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxCodeOfShipownersAgents() {
        return taxCodeOfShipownersAgents;
    }

    /**
     * Sets the value of the taxCodeOfShipownersAgents property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxCodeOfShipownersAgents(String value) {
        this.taxCodeOfShipownersAgents = value;
    }

    /**
     * Gets the value of the nameOfShipownersAgents property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOfShipownersAgents() {
        return nameOfShipownersAgents;
    }

    /**
     * Sets the value of the nameOfShipownersAgents property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOfShipownersAgents(String value) {
        this.nameOfShipownersAgents = value;
    }

    /**
     * Gets the value of the shipAgencyAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipAgencyAddress() {
        return shipAgencyAddress;
    }

    /**
     * Sets the value of the shipAgencyAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipAgencyAddress(String value) {
        this.shipAgencyAddress = value;
    }

    /**
     * Gets the value of the shipAgencyPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipAgencyPhone() {
        return shipAgencyPhone;
    }

    /**
     * Sets the value of the shipAgencyPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipAgencyPhone(String value) {
        this.shipAgencyPhone = value;
    }

    /**
     * Gets the value of the shipAgencyFax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipAgencyFax() {
        return shipAgencyFax;
    }

    /**
     * Sets the value of the shipAgencyFax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipAgencyFax(String value) {
        this.shipAgencyFax = value;
    }

    /**
     * Gets the value of the shipAgencyEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipAgencyEmail() {
        return shipAgencyEmail;
    }

    /**
     * Sets the value of the shipAgencyEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipAgencyEmail(String value) {
        this.shipAgencyEmail = value;
    }

    /**
     * Gets the value of the briefDescriptionOfTheCargo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBriefDescriptionOfTheCargo() {
        return briefDescriptionOfTheCargo;
    }

    /**
     * Sets the value of the briefDescriptionOfTheCargo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBriefDescriptionOfTheCargo(String value) {
        this.briefDescriptionOfTheCargo = value;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Sets the value of the remarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

    /**
     * Gets the value of the signPlace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignPlace() {
        return signPlace;
    }

    /**
     * Sets the value of the signPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignPlace(String value) {
        this.signPlace = value;
    }

    /**
     * Gets the value of the signDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignDate() {
        return signDate;
    }

    /**
     * Sets the value of the signDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignDate(String value) {
        this.signDate = value;
    }

    /**
     * Gets the value of the masterSigned property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterSigned() {
        return masterSigned;
    }

    /**
     * Sets the value of the masterSigned property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterSigned(String value) {
        this.masterSigned = value;
    }

}
