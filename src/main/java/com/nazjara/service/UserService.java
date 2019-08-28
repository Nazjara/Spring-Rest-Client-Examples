package com.nazjara.service;

import com.nazjara.model.UserData;

public interface UserService {
    UserData getUsers(Integer limit);
}