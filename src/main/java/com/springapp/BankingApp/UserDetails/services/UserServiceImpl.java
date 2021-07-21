package com.springapp.BankingApp.UserDetails.services;

import com.springapp.BankingApp.UserDetails.VO.ResponseEntityVO;
import com.springapp.BankingApp.UserDetails.entity.Account;
import com.springapp.BankingApp.UserDetails.entity.User;
import com.springapp.BankingApp.UserDetails.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<User> fetchAll() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntityVO findUserById(long id) {
        Optional<User> user = userRepository.findById(id);
       // return user.get();
        ResponseEntityVO vo = new ResponseEntityVO();
        vo.setUser(user.get());
        Account account = restTemplate.getForObject("http://ACCOUNT-SERVICE/account/byUser/"+id,Account.class);
        if (account != null) {
            vo.setAccountNumber(account.getAccountNumber());
        }
        return vo;

    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
