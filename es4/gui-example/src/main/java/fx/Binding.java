/* Code from https://www.dummies.com/programming/java/javafx-binding-properties/*/
package fx;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.control.*;

public class Binding extends Application {

    TextField txtCharacter;
    TextField txtActor;

    @Override
    public void start(Stage primaryStage) {
        // Create the Character label
        Label lblCharacter = new Label("Character's Name:");
        lblCharacter.setMinWidth(100);

        // Create the Character text field
        txtCharacter = new TextField();
        txtCharacter.setMinWidth(300);
        txtCharacter.setMaxWidth(300);
        txtCharacter.setPromptText("Enter the name of the character here.");

        // Create the Actor label
        Label lblActor = new Label("Actor's Name:");
        lblActor.setMinWidth(100);

        // Create the Actor text field
        txtActor = new TextField();
        txtActor.setMinWidth(300);
        txtActor.setMaxWidth(300);
        txtActor.setPromptText("Enter the name of the actor here.");

        Label lblRole1 = new Label("The role of ");
        Label lblRole2 = new Label();
        Label lblRole3 = new Label("will be played by ");
        Label lblRole4 = new Label();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(lblCharacter, 0, 0);
        grid.add(txtCharacter, 1, 0);
        grid.add(lblActor, 0, 1);
        grid.add(txtActor,1,1);
        GridPane.setHalignment(lblCharacter, HPos.LEFT);
        GridPane.setHalignment(lblActor, HPos.LEFT);
        GridPane.setFillWidth(lblCharacter, true);
        GridPane.setFillWidth(lblActor, true);

        HBox paneRole = new HBox(lblRole1, lblRole2, lblRole3, lblRole4);
        paneRole.setPadding(new Insets(10));

        // Add the Character and Actor panes to a VBox
        VBox pane = new VBox(10, grid, paneRole);

        //Create the bindings
        lblRole2.textProperty().bind(txtCharacter.textProperty());
        lblRole4.textProperty().bind(txtActor.textProperty());

        // Set the stage
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Role Player");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

