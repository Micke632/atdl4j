//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.02.24 at 10:55:05 AM CST 
//


package org.atdl4j.fixatdl.core;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * List of locations as defined by the provider. Used to declare the regions where the algorithm is supported. The absence of this element implies that the strategy is valid globally.  A region can also contain countries in order to make the classifications more granular. See the regions schema file for the list of country to region mappings.
 * 
 * <p>Java class for Regions_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Regions_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Region" type="{http://www.fixprotocol.org/FIXatdl-1-1/Core}Region_t" maxOccurs="3"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Regions_t", propOrder = {
    "region"
})
public class RegionsT {

    @XmlElement(name = "Region", required = true)
    protected List<RegionT> region;

    /**
     * Gets the value of the region property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the region property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegionT }
     * 
     * 
     */
    public List<RegionT> getRegion() {
        if (region == null) {
            region = new ArrayList<>();
        }
        return this.region;
    }

}
