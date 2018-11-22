package com.artur.patterns.MVC;

import com.artur.patterns.MVC.controller.Controller;
import com.artur.patterns.MVC.model.MainModel;
import com.artur.patterns.MVC.model.Model;
import com.artur.patterns.MVC.view.EditUserView;
import com.artur.patterns.MVC.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        //Создаём новые объекты для паттерна
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();
        EditUserView editUserView = new EditUserView();

        //Инициализация контроллера
        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        //Прописваем контроллер в наши въюшки
        usersView.setController(controller);
        editUserView.setController(controller);

        //Вызовы въюшек
        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126L);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("Artur", 123L, 5);
        usersView.fireEventShowDeletedUsers();
    }
}