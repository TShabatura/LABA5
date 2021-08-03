package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement
public class RozetkaFilter {
    private String groupOfThings;
    private String producer;
    private BigDecimal totalAmount;

    public RozetkaFilter(String groupOfThings, String producer, int totalAmount) {
        this.groupOfThings = groupOfThings;
        this.producer = producer;
        this.totalAmount = new BigDecimal(totalAmount);
    }
    public RozetkaFilter(){

    }
    @XmlElement
    public String getGroupOfThings() {
        return groupOfThings;
    }
    public void setGroupOfThings(String groupOfThings) {
        this.groupOfThings = groupOfThings;
    }

    @XmlElement
    public String getProducer() {
        return producer;
    }
    public void setProducer(String producer) {
        this.producer = producer;
    }

    @XmlElement
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
