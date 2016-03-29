//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.09.16 at 03:55:13 PM ICT 
//


package vn.nsw.model;

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
 *         &lt;element name="IMONumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Callsign" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VoyageNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NationalityOfShip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PortOfArrivalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AnchorageCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DateOfArrival" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LastPortOfCallCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NumberOfPersonsOnBoat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PeriodOfStay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PeriodOfStayUnit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NameOfMaster" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SignPlace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SignDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MasterSigned" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ListShipsStores">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ShipsStoreItem" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ShipsStoreItemCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="NameOfArticle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="QuantityUnit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="LocationOnBoat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="UseInBoat" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "imoNumber",
    "callsign",
    "voyageNumber",
    "nationalityOfShip",
    "portOfArrivalCode",
    "anchorageCode",
    "dateOfArrival",
    "lastPortOfCallCode",
    "numberOfPersonsOnBoat",
    "periodOfStay",
    "periodOfStayUnit",
    "nameOfMaster",
    "signPlace",
    "signDate",
    "masterSigned",
    "listShipsStores"
})
@XmlRootElement(name = "ShipsStoresDeclaration")
public class ShipsStoresDeclaration {

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
    @XmlElement(name = "IMONumber", required = true)
    protected String imoNumber;
    @XmlElement(name = "Callsign", required = true)
    protected String callsign;
    @XmlElement(name = "VoyageNumber", required = true)
    protected String voyageNumber;
    @XmlElement(name = "NationalityOfShip", required = true)
    protected String nationalityOfShip;
    @XmlElement(name = "PortOfArrivalCode", required = true)
    protected String portOfArrivalCode;
    @XmlElement(name = "AnchorageCode", required = true)
    protected String anchorageCode;
    @XmlElement(name = "DateOfArrival", required = true)
    protected String dateOfArrival;
    @XmlElement(name = "LastPortOfCallCode", required = true)
    protected String lastPortOfCallCode;
    @XmlElement(name = "NumberOfPersonsOnBoat", required = true)
    protected String numberOfPersonsOnBoat;
    @XmlElement(name = "PeriodOfStay", required = true)
    protected String periodOfStay;
    @XmlElement(name = "PeriodOfStayUnit", required = true)
    protected String periodOfStayUnit;
    @XmlElement(name = "NameOfMaster", required = true)
    protected String nameOfMaster;
    @XmlElement(name = "SignPlace", required = true)
    protected String signPlace;
    @XmlElement(name = "SignDate", required = true)
    protected String signDate;
    @XmlElement(name = "MasterSigned", required = true)
    protected String masterSigned;
    @XmlElement(name = "ListShipsStores", required = true)
    protected ShipsStoresDeclaration.ListShipsStores listShipsStores;

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
     * Gets the value of the imoNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIMONumber() {
        return imoNumber;
    }

    /**
     * Sets the value of the imoNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIMONumber(String value) {
        this.imoNumber = value;
    }

    /**
     * Gets the value of the callsign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallsign() {
        return callsign;
    }

    /**
     * Sets the value of the callsign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallsign(String value) {
        this.callsign = value;
    }

    /**
     * Gets the value of the voyageNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoyageNumber() {
        return voyageNumber;
    }

    /**
     * Sets the value of the voyageNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoyageNumber(String value) {
        this.voyageNumber = value;
    }

    /**
     * Gets the value of the nationalityOfShip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationalityOfShip() {
        return nationalityOfShip;
    }

    /**
     * Sets the value of the nationalityOfShip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationalityOfShip(String value) {
        this.nationalityOfShip = value;
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
     * Gets the value of the anchorageCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnchorageCode() {
        return anchorageCode;
    }

    /**
     * Sets the value of the anchorageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnchorageCode(String value) {
        this.anchorageCode = value;
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
     * Gets the value of the numberOfPersonsOnBoat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfPersonsOnBoat() {
        return numberOfPersonsOnBoat;
    }

    /**
     * Sets the value of the numberOfPersonsOnBoat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfPersonsOnBoat(String value) {
        this.numberOfPersonsOnBoat = value;
    }

    /**
     * Gets the value of the periodOfStay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodOfStay() {
        return periodOfStay;
    }

    /**
     * Sets the value of the periodOfStay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodOfStay(String value) {
        this.periodOfStay = value;
    }

    /**
     * Gets the value of the periodOfStayUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodOfStayUnit() {
        return periodOfStayUnit;
    }

    /**
     * Sets the value of the periodOfStayUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodOfStayUnit(String value) {
        this.periodOfStayUnit = value;
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
     * Gets the value of the listShipsStores property.
     * 
     * @return
     *     possible object is
     *     {@link ShipsStoresDeclaration.ListShipsStores }
     *     
     */
    public ShipsStoresDeclaration.ListShipsStores getListShipsStores() {
        return listShipsStores;
    }

    /**
     * Sets the value of the listShipsStores property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipsStoresDeclaration.ListShipsStores }
     *     
     */
    public void setListShipsStores(ShipsStoresDeclaration.ListShipsStores value) {
        this.listShipsStores = value;
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
     *         &lt;element name="ShipsStoreItem" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ShipsStoreItemCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="NameOfArticle" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="QuantityUnit" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="LocationOnBoat" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="UseInBoat" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "shipsStoreItem"
    })
    public static class ListShipsStores {

        @XmlElement(name = "ShipsStoreItem", required = true)
        protected List<ShipsStoresDeclaration.ListShipsStores.ShipsStoreItem> shipsStoreItem;

        /**
         * Gets the value of the shipsStoreItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the shipsStoreItem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getShipsStoreItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ShipsStoresDeclaration.ListShipsStores.ShipsStoreItem }
         * 
         * 
         */
        public List<ShipsStoresDeclaration.ListShipsStores.ShipsStoreItem> getShipsStoreItem() {
            if (shipsStoreItem == null) {
                shipsStoreItem = new ArrayList<ShipsStoresDeclaration.ListShipsStores.ShipsStoreItem>();
            }
            return this.shipsStoreItem;
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
         *         &lt;element name="ShipsStoreItemCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="NameOfArticle" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="QuantityUnit" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="LocationOnBoat" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="UseInBoat" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "shipsStoreItemCode",
            "nameOfArticle",
            "quantity",
            "quantityUnit",
            "locationOnBoat",
            "useInBoat"
        })
        public static class ShipsStoreItem {

            @XmlElement(name = "ShipsStoreItemCode", required = true)
            protected String shipsStoreItemCode;
            @XmlElement(name = "NameOfArticle", required = true)
            protected String nameOfArticle;
            @XmlElement(name = "Quantity", required = true)
            protected String quantity;
            @XmlElement(name = "QuantityUnit", required = true)
            protected String quantityUnit;
            @XmlElement(name = "LocationOnBoat", required = true)
            protected String locationOnBoat;
            @XmlElement(name = "UseInBoat", required = true)
            protected String useInBoat;

            /**
             * Gets the value of the shipsStoreItemCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getShipsStoreItemCode() {
                return shipsStoreItemCode;
            }

            /**
             * Sets the value of the shipsStoreItemCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setShipsStoreItemCode(String value) {
                this.shipsStoreItemCode = value;
            }

            /**
             * Gets the value of the nameOfArticle property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNameOfArticle() {
                return nameOfArticle;
            }

            /**
             * Sets the value of the nameOfArticle property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNameOfArticle(String value) {
                this.nameOfArticle = value;
            }

            /**
             * Gets the value of the quantity property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getQuantity() {
                return quantity;
            }

            /**
             * Sets the value of the quantity property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setQuantity(String value) {
                this.quantity = value;
            }

            /**
             * Gets the value of the quantityUnit property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getQuantityUnit() {
                return quantityUnit;
            }

            /**
             * Sets the value of the quantityUnit property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setQuantityUnit(String value) {
                this.quantityUnit = value;
            }

            /**
             * Gets the value of the locationOnBoat property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLocationOnBoat() {
                return locationOnBoat;
            }

            /**
             * Sets the value of the locationOnBoat property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLocationOnBoat(String value) {
                this.locationOnBoat = value;
            }

            /**
             * Gets the value of the useInBoat property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUseInBoat() {
                return useInBoat;
            }

            /**
             * Sets the value of the useInBoat property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUseInBoat(String value) {
                this.useInBoat = value;
            }

        }

    }

}
