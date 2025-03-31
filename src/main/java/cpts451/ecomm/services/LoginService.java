package cpts451.ecomm.services;

import cpts451.ecomm.entities.User;

public interface LoginService {
    User find(String email);
    boolean verifyLogin(String email, String password);
    String getUserRole(String email);
}
