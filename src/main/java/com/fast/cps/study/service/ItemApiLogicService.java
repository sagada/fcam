package com.fast.cps.study.service;

import com.fast.cps.study.ifs.CrudInterface;
import com.fast.cps.study.model.entity.Item;
import com.fast.cps.study.model.network.Header;
import com.fast.cps.study.model.network.request.ItemApiRequest;
import com.fast.cps.study.model.network.response.ItemApiResponse;
import com.fast.cps.study.repository.ItemRepository;
import com.fast.cps.study.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ItemApiLogicService implements CrudInterface<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private ItemRepository itemRepository;

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

        Item newItem = itemRepository.save(item);
        return response(newItem);
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
    public Header<ItemApiResponse> read(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        item.orElseThrow(()->new IllegalArgumentException("없는 ID 입니다."));

        return response(item.get());
    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> requset) {
        return null;
    }

    @Override
    public Header<ItemApiResponse> delete(Long id) {
        return null;
    }
}
