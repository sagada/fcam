package com.fast.cps.study.controller.api;

import com.fast.cps.study.model.network.Header;
import com.fast.cps.study.model.network.response.UserApiResponse;
import com.fast.cps.study.repository.UserRepository;
import com.fast.cps.study.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/test" )
public class PageApiController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserApiLogicService userApiLogicService;
    @GetMapping
    public Header<List<UserApiResponse>> search(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 15) Pageable pageable)
    {
        log.info("{}", pageable);
        return userApiLogicService.search(pageable);
    }
}
