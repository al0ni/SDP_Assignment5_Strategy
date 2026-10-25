package com.detectivebureau.core;

import com.detectivebureau.model.Detective;
import com.detectivebureau.model.Evidence;
import com.detectivebureau.strategy.AllocationStrategy;
import java.util.List;

public class DetectiveBureau {
    private final List<Detective> detectives;
    private AllocationStrategy strategy;

    public DetectiveBureau(List<Detective> detectives, AllocationStrategy strategy) {
        if (detectives == null || detectives.isEmpty()) {
            throw new IllegalArgumentException("Detective list is empty.");
        }
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy is required.");
        }
        this.detectives = detectives;
        this.strategy = strategy;
    }

    public void setStrategy(AllocationStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy is required.");
        }
        this.strategy = strategy;
    }

    public Detective assignEvidence(Evidence evidence) {
        if (evidence == null) {
            throw new IllegalArgumentException("Evidence is required.");
        }

        Detective target = strategy.selectDetective(detectives, evidence);
        target.addEvidence();
        return target;
    }
}
