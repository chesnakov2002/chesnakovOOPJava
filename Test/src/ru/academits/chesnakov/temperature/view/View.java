package ru.academits.chesnakov.temperature.view;

import ru.academits.chesnakov.temperature.controller.Controller;

public interface View {
    void start();

    void setController(Controller controller);
}
