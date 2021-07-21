package com.springapp.BankingApp.UserDetails.services;

import com.springapp.BankingApp.UserDetails.VO.ResponseEntityVO;
import com.springapp.BankingApp.UserDetails.entity.User;

import java.util.List;

public interface UserService {
    List<User> fetchAll();

    ResponseEntityVO findUserById(long id);

    User saveUser(User user);
}
