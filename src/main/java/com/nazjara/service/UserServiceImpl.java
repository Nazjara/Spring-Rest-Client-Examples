package com.nazjara.service;

import com.nazjara.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserServiceImpl implements UserService {

    private RestTemplate restTemplate;

    @Value("api_url")
    private String url;

    @Autowired
    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserData getUsers(Integer limit) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(url).queryParam("limit", limit);

        return restTemplate.getForObject(uriComponentsBuilder.toUriString(), UserData.class);
    }
}