package com.test.threadLocal;

public class Test {

    private static  final ThreadLocal<LocalSession> threadLocal = new ThreadLocal<LocalSession>();

    public static LocalSession  getSession(){
        LocalSession session = threadLocal.get();

        if(session == null){
            session = new LocalSession();
            session.setId(100);
        }
        System.out.println(session.getId() +" ==");
        threadLocal.set(session);

        System.out.println(threadLocal.get());
        return session;
    }




}
