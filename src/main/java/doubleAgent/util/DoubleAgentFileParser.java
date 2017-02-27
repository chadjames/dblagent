package doubleAgent.util;

import doubleAgent.domain.DoubleAgent;
import doubleAgent.service.DoubleAgentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by chad on 1/14/17.
 */
@Service
public class DoubleAgentFileParser {
    private final Logger logger = LoggerFactory.getLogger(DoubleAgentFileParser.class);
    @Autowired
            //todo: test
    DoubleAgentRepository repository;

    @Autowired
    private ResourceLoader resourceLoader;

    @Value(value = "classpath:static/cc-maps-data-set.csv")
    private Resource doubleAgentFile;

    public void parseAndLoadDoubleAgenFile(){
        Resource resource = resourceLoader.getResource
                ("classpath:cc-maps-data-set.csv");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource
                    .getInputStream()));
            reader.lines().forEach(line -> {
                String[] words = line.split(",");

                DoubleAgent doubleAgent = new DoubleAgent();
                doubleAgent.setName(words[0]);
                doubleAgent.setCurrentLatitude(Double.parseDouble(words[1]));
                doubleAgent.setCurrentLongitude(Double.parseDouble(words[2]));
                doubleAgent.setAge(Integer.parseInt(words[3]));
                doubleAgent.setGender(words[4]);

                repository.save(doubleAgent);

            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
