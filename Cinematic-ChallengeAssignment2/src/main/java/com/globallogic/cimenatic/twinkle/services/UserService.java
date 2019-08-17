package com.globallogic.cimenatic.twinkle.services;

import com.globallogic.cimenatic.twinkle.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
