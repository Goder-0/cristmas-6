package christmas.controller;

import front.model.Model;
import front.view.ViewModel;

@FunctionalInterface
public interface Controllable {
    ViewModel process(Model model);

}
