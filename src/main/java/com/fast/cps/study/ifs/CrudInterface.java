package com.fast.cps.study.ifs;

import com.fast.cps.study.model.network.Header;

public interface CrudInterface<Request, Response> {
    Header<Response> create(Header<Request> request); //todo request object 추가
    Header<Response> read(Long id);
    Header<Response> update(Header<Request> requset);
    Header delete(Long id);
}
