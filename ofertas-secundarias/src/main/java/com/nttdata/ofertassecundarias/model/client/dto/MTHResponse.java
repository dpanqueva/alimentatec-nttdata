
package com.nttdata.ofertassecundarias.model.client.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para MTHResponse complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="MTHResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="secondaryOfferId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="secondaryOfferName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="secondaryOfferPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MTHResponse", propOrder = {
    "secondaryOfferId",
    "secondaryOfferName",
    "secondaryOfferPrice"
})
public class MTHResponse {

    protected String secondaryOfferId;
    protected String secondaryOfferName;
    protected String secondaryOfferPrice;

    /**
     * Obtiene el valor de la propiedad secondaryOfferId.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSecondaryOfferId() {
        return secondaryOfferId;
    }

    /**
     * Define el valor de la propiedad secondaryOfferId.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSecondaryOfferId(String value) {
        this.secondaryOfferId = value;
    }

    /**
     * Obtiene el valor de la propiedad secondaryOfferName.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSecondaryOfferName() {
        return secondaryOfferName;
    }

    /**
     * Define el valor de la propiedad secondaryOfferName.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSecondaryOfferName(String value) {
        this.secondaryOfferName = value;
    }

    /**
     * Obtiene el valor de la propiedad secondaryOfferPrice.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSecondaryOfferPrice() {
        return secondaryOfferPrice;
    }

    /**
     * Define el valor de la propiedad secondaryOfferPrice.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSecondaryOfferPrice(String value) {
        this.secondaryOfferPrice = value;
    }

}
