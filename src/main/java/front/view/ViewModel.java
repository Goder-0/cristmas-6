package front.view;

import front.model.Model;

public class ViewModel {
    private final Model model;
    private final String viewPath;

    public ViewModel(String viewPath) {
        this.viewPath = viewPath;
        this.model = new Model();
    }

    public ViewModel(String viewPath, Model model) {
        this.viewPath = viewPath;
        this.model = model;
    }

    public void add(String key, Object object) {
        model.add(key, object);
    }

    public Model getModel() {
        return model;
    }

    public void render() {
        if (viewPath.isEmpty()) {
            ViewFactory instance = ViewFactory.getInstance();
            Viewable view = instance.getView(viewPath);
            view.render(model);
        }
    }


}
