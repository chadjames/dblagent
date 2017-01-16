package doubleAgent.util;

import doubleAgent.domain.DoubleAgent;

import java.util.List;

/**
 * Created by chad on 1/14/17.
 */
public class DoubleAgentSearchResult {
    public List<DoubleAgent> getDoubleAgents() {
        return doubleAgents;
    }

    public void setDoubleAgents(List<DoubleAgent> doubleAgents) {
        this.doubleAgents = doubleAgents;
    }

    private List<DoubleAgent> doubleAgents;

    public DoubleAgentSearchResult(List<DoubleAgent> doubleAgents) {
        this.doubleAgents = doubleAgents;
    }
    public DoubleAgentSearchResult() {
    }

    public void addDoubleAgent(DoubleAgent da){
        this.doubleAgents.add(da);
    }
}
