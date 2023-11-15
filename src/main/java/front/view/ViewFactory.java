package front.view;

import java.util.HashMap;

public class ViewFactory {

    private static ViewFactory viewFactory;
    private HashMap<String, Viewable> views;

    public ViewFactory() {
        views = new HashMap<>();

    }

    public static ViewFactory getInstance() {
        if (viewFactory == null) {
            viewFactory = new ViewFactory();
            return viewFactory;
        }
        return viewFactory;
    }

    public Viewable getView(String viewPath) {
        return views.get(viewPath);
    }
}
