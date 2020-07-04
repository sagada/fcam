package com.fast.cps.study.service;

import com.fast.cps.study.model.entity.User;
import com.fast.cps.study.model.enumclass.UserStatus;
import com.fast.cps.study.model.network.Header;
import com.fast.cps.study.model.network.request.UserApiRequest;
import com.fast.cps.study.model.network.response.UserApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserApiLogicService extends BaseService<UserApiRequest, UserApiResponse, User> {

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        // 1. request data
        UserApiRequest userApiRequest = request.getData();

        // 2. user create
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status(UserStatus.REGISTERED)
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();

        User newUser = baseRepository.save(user);

        //3. newUser -> userApiResponse Return
        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id)
    {
        return baseRepository.findById(id)
                .map(this::response)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> requset)
    {
        // 1.data
        UserApiRequest userApiRequest = requset.getData();

        // 2.id ->user
        Optional<User> optionalUser = baseRepository.findById(userApiRequest.getId());

        return optionalUser.map(user->{
                    // 3. update
                    user.setAccount(userApiRequest.getAccount())
                            .setPassword(userApiRequest.getPassword())
                            .setStatus(userApiRequest.getStatus())
                            .setPhoneNumber(userApiRequest.getPhoneNumber())
                            .setEmail(userApiRequest.getEmail())
                            .setRegisteredAt(userApiRequest.getRegisteredAt())
                            .setUnregisteredAt(userApiRequest.getUnRegisteredAt());

                    return user;
                    // 4.userApiResponse

                })
                .map(user->baseRepository.save(user)) // update
                .map(this::response)  // make userApiResponse
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {

        //id -> repository -> user
        Optional<User> optionalUser = baseRepository.findById(id);

        // repository -> delete
        return optionalUser.map(user->{
                        baseRepository.delete(user);
                        return Header.OK();
                })
                .orElseGet(()->Header.ERROR("유저 없음"));

    }

    // 1.request data
    // 2. user create
    // 3. new data => UserApiRespnse return

    private Header<UserApiResponse> response(User user)
    {
        // user -> userApiResponse
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unRegisteredAt(user.getUnregisteredAt())
                .build();

        return Header.OK(userApiResponse);

    }

    private UserApiResponse responsePage(User user)
    {
        // user -> userApiResponse
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unRegisteredAt(user.getUnregisteredAt())
                .build();

        return userApiResponse;

    }

    public Header<List<UserApiResponse>> search(Pageable pageable)
    {
        Page<User> users = baseRepository.findAll(pageable);

        List<UserApiResponse> userApiResponses = users.stream()
                .map(this::responsePage)
                .collect(Collectors.toList());

        return Header.OK(userApiResponses);
    }
}
