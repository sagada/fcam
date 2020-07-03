package com.fast.cps.study.controller.api;

import com.fast.cps.study.ifs.CrudInterface;
import com.fast.cps.study.model.network.Header;
import com.fast.cps.study.model.network.request.OrderGroupApiRequest;
import com.fast.cps.study.model.network.response.OrderGroupApiResponse;
import com.fast.cps.study.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ordergroup")
public class OrderGroupApiController implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @Override
    @PostMapping
    public Header<OrderGroupApiResponse> create(@RequestBody Header<OrderGroupApiRequest> request)
    {
        return orderGroupApiLogicService.create(request);
    }

    @Override
    @GetMapping("/{id}")
    public Header<OrderGroupApiResponse> read(@PathVariable(value = "id") Long id)
    {
        return orderGroupApiLogicService.read(id);
    }

    @Override
    @PutMapping
    public Header<OrderGroupApiResponse> update(@RequestBody Header<OrderGroupApiRequest> requset) {
        return orderGroupApiLogicService.update(requset);
    }

    @Override
    @DeleteMapping("/{id}")
    public Header delete(@PathVariable Long id) {
        return orderGroupApiLogicService.delete(id);
    }
}
