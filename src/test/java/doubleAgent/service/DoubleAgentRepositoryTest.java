package doubleAgent.service;

import doubleAgent.domain.DoubleAgent;
import doubleAgent.util.DoubleAgentMaker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

/**
 * Created by chad on 1/13/17.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class DoubleAgentRepositoryTest {
    @Autowired
    private DoubleAgentRepository doubleAgentRepository;

    @Test
    public void testSave(){
        DoubleAgent doubleAgent = DoubleAgentMaker.makeDoubleAgent();
        DoubleAgent savedDoubleAgent = doubleAgentRepository.save(doubleAgent);

        assertNotNull(savedDoubleAgent);
        assertSame(doubleAgentRepository.findOne(savedDoubleAgent.getId()).getId(),savedDoubleAgent
                .getId());
    }

    @Test
    public void testFindByGender(){
        DoubleAgent doubleAgent = DoubleAgentMaker.makeDoubleAgent();
        DoubleAgent savedDoubleAgent = doubleAgentRepository.save(doubleAgent);

        assertNotNull(savedDoubleAgent);
        assertSame(doubleAgentRepository.findByGender(doubleAgent.getGender()
        ).get(0).getId(),
                savedDoubleAgent
                .getId());
    }


}