package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class InputData {
    private List<RozetkaFilter> rozetkaFilter;

    public InputData(){
    }

    public InputData(List<RozetkaFilter> rozetkaFilter) {
        this.rozetkaFilter = rozetkaFilter;
    }

    @XmlElement
    public List<RozetkaFilter> getRozetkaFilter() {
        return rozetkaFilter;
    }
    public void setRozetkaFilter(List<RozetkaFilter> rozetkaFilter) {
        this.rozetkaFilter = rozetkaFilter;
    }
}
