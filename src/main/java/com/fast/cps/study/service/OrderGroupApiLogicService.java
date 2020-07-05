package com.fast.cps.study.service;

import com.fast.cps.study.model.entity.OrderGroup;
import com.fast.cps.study.model.network.Header;
import com.fast.cps.study.model.network.request.OrderGroupApiRequest;
import com.fast.cps.study.model.network.response.OrderGroupApiResponse;
import com.fast.cps.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderGroupApiLogicService extends BaseService<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

    @Autowired
    private UserRepository userRepository;

    public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request)
    {
        OrderGroupApiRequest body = request.getData();
        OrderGroup orderGroup = OrderGroup.builder()
                .status(body.getStatus())
                .orderType(body.getOrderType())
                .revAddress(body.getRevAddress())
                .revName(body.getRevName())
                .paymentType(body.getPaymentType())
                .totalPrice(body.getTotalPrice())
                .totalQuantity(body.getTotalQuantity())
                .orderAt(body.getOrderAt())
                .arrivalDate(body.getArrivalDate())
                .user(userRepository.getOne(body.getUserId()))
                .build();

        OrderGroup newOrderGroup = baseRepository.save(orderGroup);

        return response(newOrderGroup);
    }

    @Override
    public Header<OrderGroupApiResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(this::response)
                .orElseGet(()->Header.ERROR("해당 주문 내역이 없습니다."));
    }

    @Override
    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> requset)
    {
        OrderGroupApiRequest body = requset.getData();
        return baseRepository.findById(body.getId())
                .map(
                        entity-> entity
                                    .setStatus(body.getStatus())
                                    .setOrderAt(body.getOrderAt())
                                    .setArrivalDate(body.getArrivalDate())
                                    .setRevAddress(body.getRevAddress())
                                    .setRevName(body.getRevName())
                                    .setOrderType(body.getOrderType())
                                    .setTotalQuantity(body.getTotalQuantity())
                                    .setTotalPrice(body.getTotalPrice())
                                    .setPaymentType(body.getPaymentType()))
                .map(changeOrderGroup -> baseRepository.save(changeOrderGroup))
                .map(this::response)
                .orElseGet(()->Header.ERROR("주문 내역이 없습니다."));
    }

    @Override
    public Header delete(Long id) {
            return baseRepository.findById(id)
                    .map(orderGroup -> {
                        baseRepository.delete(orderGroup);
                        return Header.OK();
                    })
                    .orElseGet(()-> Header.ERROR("데이터 없음"));
    }

    public Header<OrderGroupApiResponse> response(OrderGroup orderGroup)
    {
        OrderGroupApiResponse body = OrderGroupApiResponse.builder()
                .id(orderGroup.getId())
                .status(orderGroup.getStatus())
                .orderType(orderGroup.getOrderType())
                .revAddress(orderGroup.getRevAddress())
                .revName(orderGroup.getRevName())
                .paymentType(orderGroup.getPaymentType())
                .totalPrice(orderGroup.getTotalPrice())
                .totalQuantity(orderGroup.getTotalQuantity())
                .orderAt(orderGroup.getOrderAt())
                .arrivalDate(orderGroup.getArrivalDate())
                .userId(orderGroup.getUser().getId())
                .build();

        return Header.OK(body);
    }
}
