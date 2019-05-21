/* Example inspired by https://www.slideshare.net/skrb/8-true-stories-about-javafx */
package fx;

import javafx.application.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class BindingDouble extends Application {

    @Override
    public void start(Stage primaryStage) {

        DoubleProperty value = new SimpleDoubleProperty();
        Slider slider = new Slider(0.0,1.0,0.0);
        slider.setMinWidth(300);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        //Set the unit distance between major tick marks.
        slider.setMajorTickUnit(0.2f);
        //Set the number of minor ticks to place between any two major ticks.
        slider.setMinorTickCount(1);

        ProgressBar bar = new ProgressBar();
        bar.setMinWidth(300);
        bar.setScaleShape(true);

        Slider slider2 = new Slider(0,100,0);
        slider2.setMinWidth(300);
        slider2.setShowTickLabels(true);
        slider2.setShowTickMarks(true);

        //Bind value to the first slider bidirectionally
        value.bindBidirectional(slider.valueProperty());
        //Bind value to progressBar
        bar.progressProperty().bind(value);
        //Bind slider2 to value with custom logic
        slider2.valueProperty()
                .bind(Bindings.subtract(100.0,
                        Bindings.multiply(value, 100.0)));
        //Init value to show bidirectional binding
        value.set(0.6);

        VBox pane = new VBox(10, slider, bar, slider2);

        // Set the stage
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BindingDouble");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

