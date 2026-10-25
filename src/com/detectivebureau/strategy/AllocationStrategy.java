package com.detectivebureau.strategy;

import com.detectivebureau.model.Detective;
import com.detectivebureau.model.Evidence;
import java.util.List;

public interface AllocationStrategy {
    Detective selectDetective(List<Detective> detectives, Evidence evidence);
}
