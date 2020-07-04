package com.fast.cps.study.controller.api;

import com.fast.cps.study.controller.CrudController;
import com.fast.cps.study.model.entity.User;
import com.fast.cps.study.model.network.request.UserApiRequest;
import com.fast.cps.study.model.network.response.UserApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, User> {

}
