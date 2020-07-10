package com.md.mp.controller;

import com.md.mp.dal.model.MpAccountModel;
import com.md.mp.repository.MpAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * MpAccountController
 *
 * @author zhuhaipeng6 in 2020/7/10 18:26
 * @version 1.0
 **/
@RestController
public class MpAccountController {

    @Autowired
    private MpAccountRepository mpAccountRepository;

    @PostMapping("mp/search")
    public Object search(@RequestBody MpAccountModel accountModel) {
        // 必要参数检验
        List<MpAccountModel> search = mpAccountRepository.search(accountModel);

        return search;

    }

    @GetMapping("mp/test")
    public Object test() {
        return "hello world";
    }
}
