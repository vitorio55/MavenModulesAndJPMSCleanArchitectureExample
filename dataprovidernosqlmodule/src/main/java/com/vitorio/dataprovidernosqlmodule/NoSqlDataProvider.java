package com.vitorio.dataprovidernosqlmodule;

import com.vitorio.usecaseinteractormodule.persistence.DataAccessInterface;

public class NoSqlDataProvider implements DataAccessInterface {

    @Override
    public int saveCalcResult(int result) {
        System.out.println("Saved result " + result + " in No-SQL database!");
        return result;
    }
}
