package com.vitorio.dataprovidersqlmodule;

import com.vitorio.usecasemodule.persistence.DataAccessInterface;

public class SqlDataProvider implements DataAccessInterface {

    @Override
    public int saveCalcResult(int result) {
        System.out.println("Saved result " + result + " in SQL database!");
        return result;
    }
}
