package io.nextree.javafx.bill2;

import io.nextree.javafx.bill2.model.Bill;
import io.nextree.javafx.bill2.model.Order;
import io.nextree.javafx.bill2.model.OrderMenu;
import io.nextree.javafx.bill2.view.BillLayoutView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BillApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //
        BillLayoutView rootLayout = new BillLayoutView();
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

        initializeSampleData(rootLayout);
        primaryStage.show();
    }

    private void initializeSampleData(BillLayoutView layout) {
        //
        Platform.runLater(() -> {
            Bill billSample = new Bill();

            Order order1 = new Order(OrderMenu.Chicken, 1000, 1);
            Order order2 = new Order(OrderMenu.Pizza, 2000, 2);
            billSample.getOrders().add(order1);
            billSample.getOrders().add(order2);

            layout.modifyBill(billSample);
        });
    }
}
