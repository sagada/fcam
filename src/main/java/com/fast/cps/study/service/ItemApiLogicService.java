package com.fast.cps.study.service;

import com.fast.cps.study.model.entity.Item;
import com.fast.cps.study.model.network.Header;
import com.fast.cps.study.model.network.request.ItemApiRequest;
import com.fast.cps.study.model.network.response.ItemApiResponse;
import com.fast.cps.study.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemApiLogicService extends BaseService<ItemApiRequest, ItemApiResponse, Item> {

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {

        ItemApiRequest body = request.getData();

        Item item = Item.builder()
                .status(body.getStatus())
                .name(body.getName())
                .price(body.getPrice())
                .title(body.getTitle())
                .content(body.getContent())
                .registeredAt(body.getRegisteredAt())
                .partner(partnerRepository.getOne(body.getPartnerId()))
                .brandName(body.getName())
                .build();

        Item newItem = baseRepository.save(item);
        return response(newItem);
    }


    @Override
    public Header<ItemApiResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(this::response)
                .orElseGet(()-> Header.ERROR("데이터가 없습니다."));
    }

    private Header<ItemApiResponse> response(Item item)
    {
        ItemApiResponse body = ItemApiResponse.builder()
                .id(item.getId())
                .status(item.getStatus())
                .title(item.getTitle())
                .price(item.getPrice())
                .content(item.getContent())
                .name(item.getName())
                .unregisteredAt(item.getUnregisteredAt())
                .partnerId(item.getId())
                .registeredAt(item.getRegisteredAt())
                .build();

        return Header.OK(body);
    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> requset) {
        ItemApiRequest body = requset.getData();
        return baseRepository.findById(body.getId())
                .map(entityItem ->
                {
                    entityItem
                            .setBrandName(body.getBrandName())
                            .setContent(body.getContent())
                            .setTitle(body.getTitle())
                            .setName(body.getName())
                            .setStatus(body.getStatus())
                            .setPrice(body.getPrice())
                            .setUnregisteredAt(body.getUnregisteredAt())
                            .setRegisteredAt(body.getRegisteredAt());

                    return entityItem;
                })
                .map(newEntityItem -> baseRepository.save(newEntityItem))
                .map(this::response)
                .orElseGet(()-> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        return baseRepository.findById(id)
                .map(item -> {
                    baseRepository.delete(item);
                    return Header.OK();
                })
                .orElseGet(()-> Header.ERROR("삭제할 아이템 아이디가 없습니다."));
    }
}
