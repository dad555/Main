package com.artur.patterns.MVC.model;

public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long id);
    void deleteUserById(long id);
    void changeUserData(String name, long id, int level);
}
