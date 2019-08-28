package com.nazjara.service;

import com.nazjara.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;

    @Autowired
    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserData getUsers(Integer limit) {
        return restTemplate.getForObject(String.format("http://private-anon-5ec3d38939-apifaketory.apiary-mock.com/api/user?limit=%d", limit), UserData.class);
    }
}
