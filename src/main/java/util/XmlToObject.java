package util;

import model.InputData;
import model.RozetkaFilter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XmlToObject {

    public List<RozetkaFilter> inputData () {
        try {
            File file = new File("src/test/resources/inputData.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(InputData.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            InputData data = (InputData) jaxbUnmarshaller.unmarshal(file);
            List<RozetkaFilter> list = data.getRozetkaFilter();
            return list;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
