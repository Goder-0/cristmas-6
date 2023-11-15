package front.model;

import java.util.HashMap;

public class Model {
    private final HashMap<String, Object> model;

    public Model() {
        this.model = new HashMap<>();
    }

    public Model(HashMap<String, Object> model) {
        this.model = model;
    }

    public void add(String key, Object object) {
        model.put(key, object);
    }

    public Object get(String key) {
        return model.get(key);
    }
}
