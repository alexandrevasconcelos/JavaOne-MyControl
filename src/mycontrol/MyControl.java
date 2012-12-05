package mycontrol;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Control;
import javafx.scene.paint.Color;


public class MyControl extends Control {

    // <editor-fold defaultstate="collapsed" desc="Variable definitions">
    private static final String DEFAULT_STYLE_CLASS = "my-control";
    private ObjectProperty<Color> color;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public MyControl() {
        color = new SimpleObjectProperty<>(Color.RED);
        init();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Initialization">
    private void init() {
        getStyleClass().add(DEFAULT_STYLE_CLASS);

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public Color getColor() {
        return color.get();
    }

    public final void setColor(final Color COLOR) {
        color.set(COLOR);
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Size related">
    @Override
    public void setPrefSize(double WIDTH, double HEIGHT) {
        final double SIZE = WIDTH < HEIGHT ? WIDTH : HEIGHT;
        super.setPrefSize(SIZE, SIZE);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Style related">

    @Override
    protected String getUserAgentStylesheet() {
        return getClass().getResource("mycontrol.css").toExternalForm();
    }

    
    // </editor-fold>

    

}

