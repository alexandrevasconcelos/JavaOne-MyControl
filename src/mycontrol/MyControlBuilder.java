package mycontrol;

import java.util.HashMap;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.ControlBuilder;
import javafx.scene.paint.Color;
import javafx.util.Builder;


public class MyControlBuilder<B extends MyControlBuilder<B>> extends ControlBuilder<B> implements Builder<MyControl> {

    // <editor-fold defaultstate="collapsed" desc="Variable definitions">
    private HashMap<String, Property> properties = new HashMap<>();
    // </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Constructor">
	protected MyControlBuilder() {}
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Methods">
    public final static MyControlBuilder create() {
        return new MyControlBuilder();
    }
    
    public final MyControlBuilder color(final Color COLOR) {
        properties.put("color", new SimpleObjectProperty<>(COLOR));
        return this;
    }
    
    
    
    // </editor-fold>

    @Override
    public final B prefHeight(final double PREF_HEIGHT) {
        properties.put("prefHeight", new SimpleDoubleProperty(PREF_HEIGHT));
        return (B)this;
    }

    @Override
    public final B prefWidth(final double PREF_WIDTH) {
        properties.put("prefWidth", new SimpleDoubleProperty(PREF_WIDTH));
        return (B)this;
    }

    @Override
    public final B layoutX(final double LAYOUT_X) {
        properties.put("layoutX", new SimpleDoubleProperty(LAYOUT_X));
        return (B)this;
    }

    @Override
    public final B layoutY(final double LAYOUT_Y) {
        properties.put("layoutY", new SimpleDoubleProperty(LAYOUT_Y));
        return (B)this;
    }

    @Override
    public MyControl build() {
        final MyControl CONTROL = new MyControl();
        for (String key : properties.keySet()) {
            switch (key) {
                case "color": CONTROL.setColor(((ObjectProperty<Color>)
                               properties.get(key)).get());
                    break;
                case "prefWidth": CONTROL.setPrefWidth(((DoubleProperty)
                               properties.get(key)).get());
                    break;
                case "prefHeight": CONTROL.setPrefHeight(((DoubleProperty)
                               properties.get(key)).get());
                    break;
                case "layoutX": CONTROL.setLayoutX(((DoubleProperty)
                               properties.get(key)).get());
                    break;
                case "layoutY": CONTROL.setLayoutY(((DoubleProperty)
                               properties.get(key)).get());
                    break;
            }
        }
        return CONTROL;
    }
    
    
    
}
