package com.vitorio.usecasemodule;

import com.vitorio.usecasemodule.boundary.InputBoundary;
import com.vitorio.usecasemodule.common.UseCase;
import com.vitorio.usecasemodule.data.InputData;

public interface UseCaseFactory {
    InputBoundary createUseCase(UseCase useCase, InputData inputData);
}
