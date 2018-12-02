package com.qyc.Service.Impl;

import com.qyc.Bean.User;
import com.qyc.Service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    //@Autowired
    //private UserMapper userMapper;

    @Override
    public User saveOrUpdate(User user) {
        return null;
    }

    @Override
    public User get(long id) {
        //return userMapper.get(id);
        return null;
    }

    @Override
    public void delete(long id) {
    }
}
