
package com.nttdata.ofertassecundarias.model.client.dto;

import javax.xml.bind.annotation.*;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Login" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TelOrigen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TelDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MensajeSMS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "login",
    "password",
    "telOrigen",
    "telDestino",
    "mensajeSMS"
})
@XmlRootElement(name = "NotificaConsultaSMS")
public class NotificaConsultaSMS {

    @XmlElement(name = "Login")
    protected String login;
    @XmlElement(name = "Password")
    protected String password;
    @XmlElement(name = "TelOrigen")
    protected String telOrigen;
    @XmlElement(name = "TelDestino")
    protected String telDestino;
    @XmlElement(name = "MensajeSMS")
    protected String mensajeSMS;

    /**
     * Obtiene el valor de la propiedad login.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogin() {
        return login;
    }

    /**
     * Define el valor de la propiedad login.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Obtiene el valor de la propiedad password.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define el valor de la propiedad password.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Obtiene el valor de la propiedad telOrigen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelOrigen() {
        return telOrigen;
    }

    /**
     * Define el valor de la propiedad telOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelOrigen(String value) {
        this.telOrigen = value;
    }

    /**
     * Obtiene el valor de la propiedad telDestino.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelDestino() {
        return telDestino;
    }

    /**
     * Define el valor de la propiedad telDestino.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelDestino(String value) {
        this.telDestino = value;
    }

    /**
     * Obtiene el valor de la propiedad mensajeSMS.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensajeSMS() {
        return mensajeSMS;
    }

    /**
     * Define el valor de la propiedad mensajeSMS.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensajeSMS(String value) {
        this.mensajeSMS = value;
    }

}
