package com.vitorio.entrypointsqsmodule;

import com.vitorio.usecasemodule.data.InputData;

public interface MessageListener {
    void receiveMessage(InputData messageBody);
}
