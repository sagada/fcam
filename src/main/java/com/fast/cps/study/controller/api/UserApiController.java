package com.fast.cps.study.controller.api;

import com.fast.cps.study.ifs.CrudInterface;
import com.fast.cps.study.model.network.Header;
import com.fast.cps.study.model.network.request.UserApiRequest;
import com.fast.cps.study.model.network.response.UserApiResponse;
import com.fast.cps.study.service.UserApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;


    @Override
    @PostMapping
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        return userApiLogicService.create(request);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> requset) {
        return null;
    }

    @Override
    public Header<UserApiResponse> delete(Long id) {
        return null;
    }
}
