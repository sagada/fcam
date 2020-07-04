package com.fast.cps.study.controller.api;

import com.fast.cps.study.controller.CrudController;
import com.fast.cps.study.ifs.CrudInterface;
import com.fast.cps.study.model.network.Header;
import com.fast.cps.study.model.network.request.UserApiRequest;
import com.fast.cps.study.model.network.response.UserApiResponse;
import com.fast.cps.study.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    public void init()
    {
        this.baseService = userApiLogicService;
    }


}
