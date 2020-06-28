package com.fast.cps.study.controller.api;

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
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    private final UserApiLogicService userApiLogicService;

    @Autowired
    public UserApiController(UserApiLogicService userApiLogicService)
    {
        this.userApiLogicService = userApiLogicService;
    }

    @Override
    @PostMapping
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request)
    {
        log.info("{}",  request);
        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("/{id}")
    public Header<UserApiResponse> read(@PathVariable(value = "id") Long id)
    {
        log.info("{}", id);
        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> requset)
    {
        return userApiLogicService.update(requset);
    }

    @Override
    @DeleteMapping("/{id}")
    public Header delete(@PathVariable(value = "id") Long id)
    {
        return userApiLogicService.delete(id);
    }
}
