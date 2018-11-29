package com.fantasy.xxtest.activiti;

import com.fantasy.xxtest.base.SpringTest;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author li.fang
 * @since 2018/8/15
 **/
public class ActivitiTest extends SpringTest {

    @Autowired
    private RepositoryService repositoryService;

    @Test
    public void deployFlow() throws FileNotFoundException {

        System.out.println(repositoryService);

//        repositoryService.createDeployment()
//                .addInputStream("parallel", new FileInputStream("C:\\Users\\Lee\\Documents\\Workspace\\xx-fantasy\\xx-web\\src\\test\\java\\com\\fantasy\\xxtest\\activiti\\parallel.bpmn"))
//                .deploy();

    }
}
