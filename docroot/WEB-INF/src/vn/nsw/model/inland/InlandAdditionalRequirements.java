//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.08 at 05:27:50 PM ICT 
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
 *         &lt;element name="RequirementCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RequirementDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Organization" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Division" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RequirementDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "requirementCode",
    "requirementDesc",
    "organization",
    "division",
    "name",
    "requirementDate"
})
@XmlRootElement(name = "InlandAdditionalRequirements")
public class InlandAdditionalRequirements {

    @XmlElement(name = "RequirementCode", required = true)
    protected String requirementCode;
    @XmlElement(name = "RequirementDesc", required = true)
    protected String requirementDesc;
    @XmlElement(name = "Organization", required = true)
    protected String organization;
    @XmlElement(name = "Division", required = true)
    protected String division;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "RequirementDate", required = true)
    protected String requirementDate;

    /**
     * Gets the value of the requirementCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequirementCode() {
        return requirementCode;
    }

    /**
     * Sets the value of the requirementCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequirementCode(String value) {
        this.requirementCode = value;
    }

    /**
     * Gets the value of the requirementDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequirementDesc() {
        return requirementDesc;
    }

    /**
     * Sets the value of the requirementDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequirementDesc(String value) {
        this.requirementDesc = value;
    }

    /**
     * Gets the value of the organization property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganization(String value) {
        this.organization = value;
    }

    /**
     * Gets the value of the division property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDivision() {
        return division;
    }

    /**
     * Sets the value of the division property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDivision(String value) {
        this.division = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the requirementDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequirementDate() {
        return requirementDate;
    }

    /**
     * Sets the value of the requirementDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequirementDate(String value) {
        this.requirementDate = value;
    }

}
