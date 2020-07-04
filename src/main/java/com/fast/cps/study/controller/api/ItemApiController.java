package com.fast.cps.study.controller.api;

import com.fast.cps.study.ifs.CrudInterface;
import com.fast.cps.study.model.network.Header;
import com.fast.cps.study.model.network.request.ItemApiRequest;
import com.fast.cps.study.model.network.response.ItemApiResponse;
import com.fast.cps.study.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @Override
    @PostMapping
    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
        return itemApiLogicService.create(request);
    }

    @Override
    @GetMapping("/{id}")
    public Header<ItemApiResponse> read(@PathVariable(value = "id") Long id) {
        return itemApiLogicService.read(id);
    }

    @Override
    @PutMapping
    public Header<ItemApiResponse> update(Header<ItemApiRequest> requset) {
        return itemApiLogicService.update(requset);
    }

    @Override
    @DeleteMapping("/{id}")
    public Header delete(@PathVariable Long id) {
        return itemApiLogicService.delete(id);
    }
}
