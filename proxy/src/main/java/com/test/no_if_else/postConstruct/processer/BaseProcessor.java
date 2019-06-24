package com.test.no_if_else.postConstruct.processer;

import com.test.no_if_else.postConstruct.RegistProcessService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class BaseProcessor implements Processer {

    @Autowired
    private RegistProcessService registProcess;

    @PostConstruct
    public void init(){
        System.out.println("==init postconstruct== this="+this.getClass());
        registProcess.registProcess(this);
    }


    /**
     * 处理器链
     */
    private List<Processer> processorChain = new ArrayList<>();

    public void registProcess(Processer processer) {
        if (!processorChain.contains(processer)) {
            processorChain.add(processer);
        }
    }

    public void allProcesser(){
        System.out.println("===for each processeorChain size="+processorChain.size());

        for (Processer processer : processorChain) {
            System.out.println("===" + processer.getClass());
        }
    }
}
