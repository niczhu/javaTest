package com.test.multiDataSource.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultiDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {

        return MultiDataSourceHandler.getDataSource();
    }

}
