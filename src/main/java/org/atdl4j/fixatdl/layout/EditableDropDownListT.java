//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.02.24 at 10:55:05 AM CST 
//


package org.atdl4j.fixatdl.layout;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EditableDropDownList_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EditableDropDownList_t">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.fixprotocol.org/FIXatdl-1-1/Layout}Control_t">
 *       &lt;sequence>
 *         &lt;element name="ListItem" type="{http://www.fixprotocol.org/FIXatdl-1-1/Layout}ListItem_t" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="initValue" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EditableDropDownList_t", propOrder = {
    "listItem"
})
public class EditableDropDownListT
    extends ControlT
{

    @XmlElement(name = "ListItem")
    protected List<ListItemT> listItem;
    @XmlAttribute
    protected String initValue;

    /**
     * Gets the value of the listItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListItemT }
     * 
     * 
     */
    public List<ListItemT> getListItem() {
        if (listItem == null) {
            listItem = new ArrayList<>();
        }
        return this.listItem;
    }

    /**
     * Gets the value of the initValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitValue() {
        return initValue;
    }

    /**
     * Sets the value of the initValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitValue(String value) {
        this.initValue = value;
    }

}
