//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.23 at 10:40:13 AM EDT 
//


package com.york.api.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for viewport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="viewport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="southwest" type="{}location" minOccurs="0"/>
 *         &lt;element name="northeast" type="{}location" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "viewport", propOrder = {
    "southwest",
    "northeast"
})
public class Viewport {

    protected Location southwest;
    protected Location northeast;

    /**
     * Gets the value of the southwest property.
     * 
     * @return
     *     possible object is
     *     {@link Location }
     *     
     */
    public Location getSouthwest() {
        return southwest;
    }

    /**
     * Sets the value of the southwest property.
     * 
     * @param value
     *     allowed object is
     *     {@link Location }
     *     
     */
    public void setSouthwest(Location value) {
        this.southwest = value;
    }

    /**
     * Gets the value of the northeast property.
     * 
     * @return
     *     possible object is
     *     {@link Location }
     *     
     */
    public Location getNortheast() {
        return northeast;
    }

    /**
     * Sets the value of the northeast property.
     * 
     * @param value
     *     allowed object is
     *     {@link Location }
     *     
     */
    public void setNortheast(Location value) {
        this.northeast = value;
    }

}
