package doubleAgent.service;

import doubleAgent.domain.DoubleAgent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by chad on 1/13/17.
 */
public interface DoubleAgentRepository extends JpaRepository<DoubleAgent, Integer> {

    List<DoubleAgent> findByGender(String gender);
}
