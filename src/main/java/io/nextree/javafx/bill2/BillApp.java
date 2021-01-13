package io.nextree.javafx.bill2;

import io.nextree.javafx.bill2.view.OrderView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BillApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //
        BorderPane rootLayout = new BorderPane();
        rootLayout.setCenter(new OrderView());
        Scene scene = new Scene(rootLayout, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bill App");
        primaryStage.setOnCloseRequest(event -> {
            if (Platform.isFxApplicationThread()) {
                primaryStage.close();
                Platform.exit();
            }

            System.exit(0);
        });

        primaryStage.show();
    }
}
