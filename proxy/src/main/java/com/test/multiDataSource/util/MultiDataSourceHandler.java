package com.test.multiDataSource.util;

public class MultiDataSourceHandler {

    public static final String MASTER="master";
    public static final String SLAVE="slaver";

    private static ThreadLocal<String> dataSource = new ThreadLocal<String>();

    public MultiDataSourceHandler(){
    }

    public static Object getDataSource(){
        return dataSource.get();
    }

    public static void setDataSource(String dataSourceKey){
        dataSource.set(dataSourceKey);
    }


}
