package doubleAgent.service;

import doubleAgent.util.DoubleAgentFileParser;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chad on 1/14/17.
 */
@Service
public class BootstrapService implements InitializingBean {
    @Autowired
    DoubleAgentFileParser fileParser;

    @Override
    public void afterPropertiesSet() throws Exception {
        fileParser.parseAndLoadDoubleAgenFile();
    }
}
