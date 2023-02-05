package com.bootStart2.service;
import com.bootStart2.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User getOneUser(int id);
    void delete(int id);
    void update(int id, User user);
}
