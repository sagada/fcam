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


    @Override
    public Header<ItemApiResponse> read(Long id) {
        return itemRepository.findById(id)
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
        return itemRepository.findById(body.getId())
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
                .map(newEntityItem -> itemRepository.save(newEntityItem))
                .map(this::response)
                .orElseGet(()-> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        return itemRepository.findById(id)
                .map(item -> {
                    itemRepository.delete(item);
                    return Header.OK();
                })
                .orElseGet(()-> Header.ERROR("삭제할 아이템 아이디가 없습니다."));
    }
}
