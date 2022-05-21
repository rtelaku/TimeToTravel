package com.example.demo.Register.Service;

import com.example.demo.Register.Helper.GeneralResponse;

public interface IUserService {

    boolean checkIfUserIsValid(String username, String password);

    GeneralResponse<?> getUserByUsername(String username);
}
