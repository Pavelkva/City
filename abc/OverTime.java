//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.01.10 at 09:38:08 AM CET 
//


package abc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for overTime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="overTime">
 *   &lt;complexContent>
 *     &lt;extension base="{}abilityEffect">
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="duration" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="reamingTime" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="stackable" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "overTime")
@XmlSeeAlso({
    Shield.class,
    ConditionEffect.class,
    Buff.class
})
public abstract class OverTime
    extends AbilityEffect
{

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "duration")
    protected Integer duration;
    @XmlAttribute(name = "reamingTime")
    protected Integer reamingTime;
    @XmlAttribute(name = "stackable")
    protected Integer stackable;

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
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDuration(Integer value) {
        this.duration = value;
    }

    /**
     * Gets the value of the reamingTime property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getReamingTime() {
        return reamingTime;
    }

    /**
     * Sets the value of the reamingTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setReamingTime(Integer value) {
        this.reamingTime = value;
    }

    /**
     * Gets the value of the stackable property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStackable() {
        return stackable;
    }

    /**
     * Sets the value of the stackable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStackable(Integer value) {
        this.stackable = value;
    }

}
