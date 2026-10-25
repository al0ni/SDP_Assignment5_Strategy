package com.detectivebureau.strategy;

import com.detectivebureau.model.Detective;
import com.detectivebureau.model.Evidence;
import java.util.List;

public class LeastLoadedStrategy implements AllocationStrategy {
    @Override
    public Detective selectDetective(List<Detective> detectives, Evidence evidence) {
        Detective bestMatch = detectives.get(0);

        for (Detective candidate : detectives) {
            if (candidate.getWorkload() < bestMatch.getWorkload()) {
                bestMatch = candidate;
            }
        }

        return bestMatch;
    }
}
