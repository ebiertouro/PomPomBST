
module pomPomTree {requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics; // Add this line


opens pomPomTree to javafx.graphics, javafx.fxml;
    exports pomPomTree;
}