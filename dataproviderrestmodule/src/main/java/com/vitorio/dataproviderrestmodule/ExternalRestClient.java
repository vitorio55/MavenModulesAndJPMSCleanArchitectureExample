package com.vitorio.dataproviderrestmodule;

import com.vitorio.usecasemodule.boundary.OutputBoundary;
import com.vitorio.usecasemodule.data.OutputData;

public class ExternalRestClient implements OutputBoundary {

    @Override
    public void interact(OutputData data) {
        System.out.println("Sent data to external REST client! calculationResult=" + data.calculationResult());
    }
}
