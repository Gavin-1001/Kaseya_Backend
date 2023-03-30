package com.example.backend.service;

import com.example.backend.entity.User;

public interface AuthenticationService {


    User signInAndReturnJwt(User signInRequest);

}
