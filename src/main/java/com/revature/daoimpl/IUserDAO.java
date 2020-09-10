package com.revature.daoimpl;

import java.util.List;

import com.revature.models.Users;

public interface IUserDAO {
public boolean insert(Users u);
public boolean update(Users u);
public List<Users> findAll();
public Users findById(int id);
}
