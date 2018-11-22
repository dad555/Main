package com.artur.patterns.MVC.model;

import com.artur.patterns.MVC.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> fakeUsers = new ArrayList<>();
        fakeUsers.add(new User("Artur", 1, 1));
        fakeUsers.add(new User("Diana", 2, 2));
        fakeUsers.add(new User("David", 3, 3));
        modelData.setUsers(fakeUsers);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }
}
