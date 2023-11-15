package front.controller;

import christmas.controller.Controllable;
import christmas.view.inputview.InputView;
import front.model.Model;
import front.view.ViewFactory;
import front.view.ViewModel;
import front.view.Viewable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrontController {
    private final Map<String, Controllable> controllers;
    private final List<String> order;

    public FrontController() {
        controllers = new HashMap<>();
        order = Arrays.asList(
        );
    }

    public static void run() {
        FrontController frontController = new FrontController();
        for (String s : frontController.order) {
            frontController.service(s);
            System.out.println();
        }
    }

    public void service(String path) {
        if (controllers.containsKey(path)) {
            Model model = new Model();
            Controllable controller = controllers.get(path);
            ViewFactory viewFactory = ViewFactory.getInstance();
            Viewable viewable = viewFactory.getView(path);
            if (viewable instanceof InputView) {
                viewable.render(model);
                controller.process(model);
            }
            ViewModel viewModel = controller.process(model);
            viewModel.render();
        }
    }
}
