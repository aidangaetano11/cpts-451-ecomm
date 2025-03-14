package cpts451.ecomm.services;

import cpts451.ecomm.entities.User;
import cpts451.ecomm.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService
{
    private final UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User find(String email) { return userRepository.findByEmail(email); }

    @Override
    public boolean verifyLogin(String email, String password) {
        User account = this.find(email);
        
        if (account == null){
            return false;
        }
        else
        {
            if (account.getPassword().equals(password)){
                return true;
            }

            return false;
        }
    }
}
