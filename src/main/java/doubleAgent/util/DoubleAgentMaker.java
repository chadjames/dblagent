package doubleAgent.util;

import doubleAgent.domain.DoubleAgent;

import java.util.Random;
import java.util.UUID;

/**
 * Created by chad on 1/14/17.
 */
public class DoubleAgentMaker {
    private static Random random = new Random();
    public static DoubleAgent makeDoubleAgent(){
        DoubleAgent doubleAgent = new DoubleAgent(
                random.nextDouble(),
                random.nextDouble(),
                UUID.randomUUID().toString(),
                random.nextInt(),
                UUID.randomUUID().toString());
        return doubleAgent;
    }
}
