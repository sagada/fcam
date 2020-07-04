package com.fast.cps.study.controller.api;

import com.fast.cps.study.controller.CrudController;
import com.fast.cps.study.model.entity.OrderGroup;
import com.fast.cps.study.model.network.request.OrderGroupApiRequest;
import com.fast.cps.study.model.network.response.OrderGroupApiResponse;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/ordergroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

}
