package com.artur.patterns.MVC.view;

import com.artur.patterns.MVC.controller.Controller;
import com.artur.patterns.MVC.model.ModelData;

public interface View {
    void refresh(ModelData modelData);
    void setController(Controller controller);
}
