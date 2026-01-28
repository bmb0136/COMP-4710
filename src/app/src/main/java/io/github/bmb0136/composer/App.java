package io.github.bmb0136.composer;

import io.github.bmb0136.composer.core.Test;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Test.hello();
        stage.show();
    }
}
