package com.test.no_if_else.postConstruct;

import com.test.no_if_else.postConstruct.processer.Processer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistProcessService {

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
        System.out.println("===for each processeorChain");
        for (Processer processer : processorChain) {
            System.out.println("===" + processer.getClass());
        }
    }
}
