//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.09 at 02:32:20 PM ICT 
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
 *         &lt;element name="isArrival" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NameOfShip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SignPlace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SignDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MasterSigned" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ListPassengers">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Passenger" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="PassengerCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="FamilyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="GivenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="BirthDay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="BirthPlace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="TypeOfIdentity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="SerialNumberOfIdentity" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "listPassengers"
})
@XmlRootElement(name = "InlandPassengerList")
public class InlandPassengerList {

    @XmlElement(name = "DocumentName", required = true)
    protected String documentName;
    @XmlElement(name = "DocumentYear", required = true)
    protected String documentYear;
    @XmlElement(name = "UserCreated", required = true)
    protected String userCreated;
    @XmlElement(required = true)
    protected String isArrival;
    @XmlElement(name = "NameOfShip", required = true)
    protected String nameOfShip;
    @XmlElement(name = "SignPlace", required = true)
    protected String signPlace;
    @XmlElement(name = "SignDate", required = true)
    protected String signDate;
    @XmlElement(name = "MasterSigned", required = true)
    protected String masterSigned;
    @XmlElement(name = "ListPassengers", required = true)
    protected InlandPassengerList.ListPassengers listPassengers;

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
     * Gets the value of the listPassengers property.
     * 
     * @return
     *     possible object is
     *     {@link InlandPassengerList.ListPassengers }
     *     
     */
    public InlandPassengerList.ListPassengers getListPassengers() {
        return listPassengers;
    }

    /**
     * Sets the value of the listPassengers property.
     * 
     * @param value
     *     allowed object is
     *     {@link InlandPassengerList.ListPassengers }
     *     
     */
    public void setListPassengers(InlandPassengerList.ListPassengers value) {
        this.listPassengers = value;
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
     *         &lt;element name="Passenger" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="PassengerCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="FamilyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="GivenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="BirthDay" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="BirthPlace" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="TypeOfIdentity" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="SerialNumberOfIdentity" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "passenger"
    })
    public static class ListPassengers {

        @XmlElement(name = "Passenger", required = true)
        protected List<InlandPassengerList.ListPassengers.Passenger> passenger;

        /**
         * Gets the value of the passenger property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the passenger property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPassenger().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link InlandPassengerList.ListPassengers.Passenger }
         * 
         * 
         */
        public List<InlandPassengerList.ListPassengers.Passenger> getPassenger() {
            if (passenger == null) {
                passenger = new ArrayList<InlandPassengerList.ListPassengers.Passenger>();
            }
            return this.passenger;
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
         *         &lt;element name="PassengerCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="FamilyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="GivenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="BirthDay" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="BirthPlace" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="TypeOfIdentity" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="SerialNumberOfIdentity" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "passengerCode",
            "familyName",
            "givenName",
            "birthDay",
            "birthPlace",
            "typeOfIdentity",
            "serialNumberOfIdentity"
        })
        public static class Passenger {

            @XmlElement(name = "PassengerCode", required = true)
            protected String passengerCode;
            @XmlElement(name = "FamilyName", required = true)
            protected String familyName;
            @XmlElement(name = "GivenName", required = true)
            protected String givenName;
            @XmlElement(name = "BirthDay", required = true)
            protected String birthDay;
            @XmlElement(name = "BirthPlace", required = true)
            protected String birthPlace;
            @XmlElement(name = "TypeOfIdentity", required = true)
            protected String typeOfIdentity;
            @XmlElement(name = "SerialNumberOfIdentity", required = true)
            protected String serialNumberOfIdentity;

            /**
             * Gets the value of the passengerCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPassengerCode() {
                return passengerCode;
            }

            /**
             * Sets the value of the passengerCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPassengerCode(String value) {
                this.passengerCode = value;
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
             * Gets the value of the birthDay property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBirthDay() {
                return birthDay;
            }

            /**
             * Sets the value of the birthDay property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBirthDay(String value) {
                this.birthDay = value;
            }

            /**
             * Gets the value of the birthPlace property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBirthPlace() {
                return birthPlace;
            }

            /**
             * Sets the value of the birthPlace property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBirthPlace(String value) {
                this.birthPlace = value;
            }

            /**
             * Gets the value of the typeOfIdentity property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTypeOfIdentity() {
                return typeOfIdentity;
            }

            /**
             * Sets the value of the typeOfIdentity property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTypeOfIdentity(String value) {
                this.typeOfIdentity = value;
            }

            /**
             * Gets the value of the serialNumberOfIdentity property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSerialNumberOfIdentity() {
                return serialNumberOfIdentity;
            }

            /**
             * Sets the value of the serialNumberOfIdentity property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSerialNumberOfIdentity(String value) {
                this.serialNumberOfIdentity = value;
            }

        }

    }

}