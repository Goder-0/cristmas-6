package front.view;

import front.model.Model;

@FunctionalInterface
public interface Viewable {
    void render(Model model);
}
