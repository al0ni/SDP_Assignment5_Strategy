package com.detectivebureau.strategy;

import com.detectivebureau.model.Detective;
import com.detectivebureau.model.Evidence;
import java.util.List;

public class RoundRobinStrategy implements AllocationStrategy {
    private int nextIndex;

    @Override
    public synchronized Detective selectDetective(List<Detective> detectives, Evidence evidence) {
        Detective target = detectives.get(nextIndex);
        nextIndex++;

        if (nextIndex == detectives.size()) {
            nextIndex = 0;
        }

        return target;
    }
}
