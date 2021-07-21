package com.springapp.BankingApp.UserDetails.VO;

import com.springapp.BankingApp.UserDetails.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntityVO {
    private User user;
    private long accountNumber;
}
