package com.artur.patterns.MVC.view;

import com.artur.patterns.MVC.bean.User;
import com.artur.patterns.MVC.controller.Controller;
import com.artur.patterns.MVC.model.ModelData;

import java.util.List;

public class UsersView implements View {
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {
        if(!modelData.isDisplayDeletedUserList()) {
            System.out.println("All users:");
        } else {
            System.out.println("All deleted users:");
        }
        List<User> users = modelData.getUsers();
        for (User u : users) {
            System.out.println("\t" + u);
        }
        System.out.println("===================================================");
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
    public void fireEventOpenUserEditForm(long id) { controller.onOpenUserEditForm(id); }
}
