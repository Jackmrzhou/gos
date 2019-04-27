package org.gilmour.gos.DataServer.service.impl;

import org.gilmour.gos.DataServer.conf.DataServerConf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataServerConf.class}, initializers = {ConfigFileApplicationContextInitializer.class})
public class FileServiceImplTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void putFile() throws Exception{
        FileServiceImpl fileService = applicationContext.getBean(FileServiceImpl.class);
        boolean res = fileService.PutFile(
                "112233.jpg",
                new FileInputStream(new File("/home/jack/projects/gos/gos-dataserver/src/test/resources/favicon.jpg"))
        );
        assertEquals(res, true);
    }

    @Test
    public void getFile() {
    }
}