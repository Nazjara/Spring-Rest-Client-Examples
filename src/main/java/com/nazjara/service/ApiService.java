package com.nazjara.service;

import com.nazjara.model.UserData;

public interface ApiService {
    UserData getUsers(Integer limit);
}
