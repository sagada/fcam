package com.fast.cps.study.controller.api;

import com.fast.cps.study.controller.CrudController;
import com.fast.cps.study.model.entity.Partner;
import com.fast.cps.study.model.network.request.PartnerApiRequest;
import com.fast.cps.study.model.network.response.PartnerApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {
}
