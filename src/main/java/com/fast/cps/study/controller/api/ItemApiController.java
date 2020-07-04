package com.fast.cps.study.controller.api;

import com.fast.cps.study.controller.CrudController;
import com.fast.cps.study.model.entity.Item;
import com.fast.cps.study.model.network.request.ItemApiRequest;
import com.fast.cps.study.model.network.response.ItemApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

}
