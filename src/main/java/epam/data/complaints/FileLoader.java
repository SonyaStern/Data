package epam.data.complaints;

import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URISyntaxException;

@Component
public class FileLoader {

    public void loadData() throws URISyntaxException {
        File file = new File(getClass().getClassLoader().getResource("ConsumerComplaints.csv").getFile());

    }
}
