package org.swe550.modelimplementations;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.Edge;
import org.graphwalker.java.annotation.GraphWalker;
import org.swe550.PetClinic;

@GraphWalker(value = "random(edge_coverage(100))", start = "e_StartBrowser")
public class PetClinicTest extends ExecutionContext implements PetClinic {
    @Override
    public void v_HomePage() {

    }

    @Override
    public void e_StartBrowser() {

    }
}
