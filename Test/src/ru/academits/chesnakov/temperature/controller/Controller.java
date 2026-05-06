package ru.academits.chesnakov.temperature.controller;

import ru.academits.chesnakov.temperature.model.Converter;
import ru.academits.chesnakov.temperature.view.View;

public class Controller {
    private final Converter converter;
    private final View view;

    public Controller(Converter converter, View view) {
        this.converter = converter;
        this.view = view;

        view.setController(this);
    }

    public void convert() {

    }

    public void start() {
        view.start();
    }
}
