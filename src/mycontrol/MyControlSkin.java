package mycontrol;

import com.sun.javafx.scene.control.skin.SkinBase;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class MyControlSkin extends SkinBase<MyControl, MyControlBehavior> {

    // <editor-fold defaultstate="collapsed" desc="Variable definitions">
    private MyControl control;
    private Group group;
    private boolean isDirty;
    private boolean initialized;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public MyControlSkin(final MyControl CONTROL) {
        super(CONTROL, new MyControlBehavior(CONTROL));
        control = CONTROL;
        group = new Group();
        initialized = false;
        isDirty = false;
        init();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Initialization">
    private void init() {
        if(control.getPrefWidth() <=0 || control.getPrefHeight() <=0) {
            control.setPrefSize(100, 100);
        }
        registerChangeListener(control.prefWidthProperty(), "PREF_WIDTH");
        registerChangeListener(control.prefHeightProperty(), "PREF_HEIGHT");
        registerChangeListener(control.colorProperty(), "COLOR");
        
        initialized = true;
        paint();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Property related">
    @Override
    protected void handleControlPropertyChanged(final String PROPERTY) {
        super.handleControlPropertyChanged(PROPERTY);
        switch (PROPERTY) {
            case "PREF_WIDTH": break;
            case "PREF_HEIGHT": break;
            case "COLOR": drawControl();
                break;
        }        
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Paint">
    private void paint() {
        if (!initialized) {
            init();
        }
        getChildren().clear();
        drawControl();
        getChildren().addAll(group);
    }
    
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Layout and Size related">
@Override
    public MyControl getSkinnable() {
        return control;
    }

    @Override
    public void dispose() {
        control = null;
    }

    @Override
    protected double computeMinWidth(final double MIN_WIDTH) {
        return super.computeMinWidth(Math.max(20,MIN_WIDTH-
                                     getInsets().getLeft()-
                                     getInsets().getRight()));
    }

    @Override
    protected double computeMinHeight(final double MIN_HEIGHT) {
        return super.computeMinHeight(Math.max(20, MIN_HEIGHT-
                                      getInsets().getTop()-
                                      getInsets().getBottom()));
    }

    @Override
    protected double computePrefWidth(final double PREF_WIDTH) {
        double prefWidth = 100;
        if (PREF_WIDTH != -1) {
            prefWidth = Math.max(0, PREF_WIDTH-getInsets().getLeft()-
                                    getInsets().getRight());
        }
        return super.computePrefWidth(prefWidth);
    }

    @Override
    protected double computePrefHeight(final double PREF_HEIGHT) {
        double prefHeight = 100;
        if (PREF_HEIGHT != -1) {
            prefHeight = Math.max(0, PREF_HEIGHT-getInsets().getTop()-
                                    getInsets().getBottom());
        }
        return super.computePrefHeight(prefHeight);
    }

    @Override
    protected void layoutChildren() {
        if (isDirty) {
            paint();
            isDirty = false;
        }
        super.layoutChildren();
    }

    @Override
    protected double computeMaxWidth(final double MAX_WIDTH) {
        return super.computeMaxWidth(Math.max(1024,MAX_WIDTH-
                                     getInsets().getLeft()-
                                     getInsets().getRight()));
    }

    @Override
    protected double computeMaxHeight(final double MAX_HEIGHT) {
        return super.computeMaxHeight(Math.max(1024, MAX_HEIGHT-
                                      getInsets().getTop()-
                                      getInsets().getBottom()));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Drawing related">
    private void drawControl() {
        final double SIZE = control.getPrefWidth() <
                            control.getPrefHeight() ?
                            control.getPrefWidth() :
                            control.getPrefHeight();
        group.getChildren().clear();
        
        final Rectangle IBOUNDS = new Rectangle(SIZE, SIZE);
        IBOUNDS.setOpacity(0.0);
        
        Rectangle rect = new Rectangle(20,20,60,60);
        rect.getStyleClass().add("rect");
        
        Text text = new Text("This is your control");
        text.setFill(control.getColor());
        
        group.getChildren().addAll(IBOUNDS, rect, text);
        group.setCache(true);
    }
    // </editor-fold>





    






}
