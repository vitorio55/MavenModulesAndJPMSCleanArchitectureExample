package com.vitorio.entrypointsqsmodule;

import com.vitorio.usecaseinteractormodule.data.InputData;

public interface MessageListener {
    void receiveMessage(InputData messageBody);
}
