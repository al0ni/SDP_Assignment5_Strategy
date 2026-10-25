package com.detectivebureau.strategy;

import com.detectivebureau.model.Detective;
import com.detectivebureau.model.Evidence;
import java.util.List;

public class SpecializationStrategy implements AllocationStrategy {
    private final AllocationStrategy fallback = new LeastLoadedStrategy();

    @Override
    public Detective selectDetective(List<Detective> detectives, Evidence evidence) {
        for (Detective candidate : detectives) {
            if (candidate.getSpecialization().equalsIgnoreCase(evidence.getType())) {
                System.out.println("Matching specialist found: " + candidate.getName());
                return candidate;
            }
        }

        System.out.println("No matching specialist. Using the least-loaded detective.");
        return fallback.selectDetective(detectives, evidence);
    }
}
