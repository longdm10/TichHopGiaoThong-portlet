//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.11 at 11:13:31 AM ICT 
//


package vn.nsw.model.inland;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="IsArrival" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NameOfShip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SignPlace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SignDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MasterSigned" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CrewList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Crew" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="PassportNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="CrewCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="FamilyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="GivenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="RankCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "signPlace",
    "signDate",
    "masterSigned",
    "crewList"
})
@XmlRootElement(name = "InlandCrewLists")
public class InlandCrewLists {

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
    @XmlElement(name = "SignPlace", required = true)
    protected String signPlace;
    @XmlElement(name = "SignDate", required = true)
    protected String signDate;
    @XmlElement(name = "MasterSigned", required = true)
    protected String masterSigned;
    @XmlElement(name = "CrewList", required = true)
    protected InlandCrewLists.CrewList crewList;

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

    /**
     * Gets the value of the crewList property.
     * 
     * @return
     *     possible object is
     *     {@link InlandCrewLists.CrewList }
     *     
     */
    public InlandCrewLists.CrewList getCrewList() {
        return crewList;
    }

    /**
     * Sets the value of the crewList property.
     * 
     * @param value
     *     allowed object is
     *     {@link InlandCrewLists.CrewList }
     *     
     */
    public void setCrewList(InlandCrewLists.CrewList value) {
        this.crewList = value;
    }


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
     *         &lt;element name="Crew" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="PassportNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="CrewCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="FamilyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="GivenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="RankCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "crew"
    })
    public static class CrewList {

        @XmlElement(name = "Crew", required = true)
        protected List<InlandCrewLists.CrewList.Crew> crew;

        /**
         * Gets the value of the crew property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the crew property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCrew().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link InlandCrewLists.CrewList.Crew }
         * 
         * 
         */
        public List<InlandCrewLists.CrewList.Crew> getCrew() {
            if (crew == null) {
                crew = new ArrayList<InlandCrewLists.CrewList.Crew>();
            }
            return this.crew;
        }


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
         *         &lt;element name="PassportNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="CrewCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="FamilyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="GivenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="RankCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "passportNumber",
            "crewCode",
            "familyName",
            "givenName",
            "rankCode"
        })
        public static class Crew {

            @XmlElement(name = "PassportNumber", required = true)
            protected String passportNumber;
            @XmlElement(name = "CrewCode", required = true)
            protected String crewCode;
            @XmlElement(name = "FamilyName", required = true)
            protected String familyName;
            @XmlElement(name = "GivenName", required = true)
            protected String givenName;
            @XmlElement(name = "RankCode", required = true)
            protected String rankCode;

            /**
             * Gets the value of the passportNumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPassportNumber() {
                return passportNumber;
            }

            /**
             * Sets the value of the passportNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPassportNumber(String value) {
                this.passportNumber = value;
            }

            /**
             * Gets the value of the crewCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCrewCode() {
                return crewCode;
            }

            /**
             * Sets the value of the crewCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCrewCode(String value) {
                this.crewCode = value;
            }

            /**
             * Gets the value of the familyName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFamilyName() {
                return familyName;
            }

            /**
             * Sets the value of the familyName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFamilyName(String value) {
                this.familyName = value;
            }

            /**
             * Gets the value of the givenName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGivenName() {
                return givenName;
            }

            /**
             * Sets the value of the givenName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGivenName(String value) {
                this.givenName = value;
            }

            /**
             * Gets the value of the rankCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRankCode() {
                return rankCode;
            }

            /**
             * Sets the value of the rankCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRankCode(String value) {
                this.rankCode = value;
            }

        }

    }

}
