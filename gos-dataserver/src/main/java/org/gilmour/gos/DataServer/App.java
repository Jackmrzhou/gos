package org.gilmour.gos.DataServer;

import org.gilmour.gos.DataServer.conf.DataServerConf;
import org.gilmour.gos.DataServer.server.DataServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DataServerConf.class);
        DataServer dataServer = applicationContext.getBean(DataServer.class);
        try {
            dataServer.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
