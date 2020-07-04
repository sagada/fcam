package com.fast.cps.study.controller.api;

import com.fast.cps.study.controller.CrudController;
import com.fast.cps.study.model.network.request.OrderGroupApiRequest;
import com.fast.cps.study.model.network.response.OrderGroupApiResponse;
import com.fast.cps.study.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/ordergroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @PostConstruct
    public void init()
    {
        this.baseService = orderGroupApiLogicService;
    }

}
