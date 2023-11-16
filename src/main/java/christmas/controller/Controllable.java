package christmas.controller;

import front.model.Model;

@FunctionalInterface
public interface Controllable {
    String process(Model model);

}
