package doubleAgent.web;

import doubleAgent.service.DoubleAgentRepository;
import doubleAgent.util.DoubleAgentSearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by chad on 1/11/17.
 */
@RestController
public class DoubleAgentController {
    private final Logger logger = LoggerFactory.getLogger(DoubleAgentController.class);

    @Autowired
    DoubleAgentRepository repository;

    @RequestMapping("/doubleAgent")
    public DoubleAgentSearchResult doubleAgents(){
        DoubleAgentSearchResult result = new DoubleAgentSearchResult();
        result.setDoubleAgents(repository.findAll());
        return result;
    }


}
