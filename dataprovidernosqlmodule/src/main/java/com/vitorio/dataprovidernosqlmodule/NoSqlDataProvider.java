package com.vitorio.dataprovidernosqlmodule;

import com.vitorio.usecasemodule.persistence.DataAccessInterface;

public class NoSqlDataProvider implements DataAccessInterface {

    @Override
    public int saveCalcResult(int result) {
        System.out.println("Saved result " + result + " in No-SQL database!");
        return result;
    }
}
