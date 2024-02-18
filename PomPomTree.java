package pomPomTree;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class PomPomTree extends Application {


    private Pane rootPane = new Pane();
    private BST bst;

    @Override
    public void start(Stage primaryStage) {
    	
    	 BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTGRAY, null, null);
         Background background = new Background(backgroundFill);
         rootPane.setBackground(background);
         
         
        PomPom mahogany = new PomPom(128, 0, 0, "mahogany");
        PomPom cardinal = new PomPom(196, 30, 58, "cardinal");
        PomPom redRibbon = new PomPom(189, 32, 49, "red ribbon");
    	PomPom cerise = new PomPom(209, 46, 196, "cerise");
    	PomPom white = new PomPom(255, 255, 255, "white");
    	PomPom amour = new PomPom(239, 205, 239, "amour");
    	PomPom mineralGreen = new PomPom(59, 99, 82, "mineral green");
    	PomPom primrose = new PomPom(100, 239, 163, "primrose");
    	PomPom java = new PomPom(25, 176, 190, "java");
    	PomPom brightTurquoise = new PomPom(30, 227, 241, "bright turquoise");
    	PomPom casal = new PomPom(44, 94, 99, "casal");
    	PomPom persianBlue = new PomPom(34, 20, 189, "persian blue");
    	PomPom thunderbird = new PomPom(189, 48, 20, "thunderbird");
    	PomPom tango = new PomPom(242, 120, 33, "tango");
    	
    	bst = new BST();
    	
    	bst.insert(mahogany);
    	bst.insert(brightTurquoise);
    	bst.insert(casal);
    	bst.insert(primrose);
    	bst.insert(amour);
    	bst.insert(java);
    	bst.insert(cerise);
    	bst.insert(thunderbird);
    	bst.insert(persianBlue);
    	bst.insert(mineralGreen);
    	bst.insert(tango);
    	bst.insert(cardinal);
    	bst.insert(redRibbon);
    	bst.insert(white);
    	
    	int radius = 25;
        // Build the binary search tree
    	BST.BSTnode root = bst.getRoot();
    	double initialX = (Screen.getPrimary().getVisualBounds().getWidth() - radius) / 2; // Assuming 40 is the radius of the circle
    	double initialY = 50; // Top of the screen

    	// Adjust the initial X and Y positions for the white pompom
    	displayBST(root, initialX, initialY, 125, 100, radius); 

    	Scene scene = new Scene(rootPane);
    	primaryStage.setScene(scene);

    	primaryStage.setFullScreen(true);
    	primaryStage.setTitle("PomPom Binary Search Tree Visualizer");
    	primaryStage.show();

    }

    private void displayBST(BST.BSTnode root, double x, double y, double hGap, double vGap, double radius) {
        if (root != null) {
            // Display the current node
            Circle circle = new Circle(x, y, radius);
            circle.setFill(root.info.getFXColor());
            rootPane.getChildren().add(circle);

            // Display the label (color name) under the circle
            Text label = new Text(root.info.getColorName());
            label.setLayoutX(x - radius);
            label.setLayoutY(y + radius * 2 + 5); // Adjust the value for proper placement
            rootPane.getChildren().add(label);

            // Draw lines connecting nodes
            if (root.left != null) {
                double leftX = x - hGap * 3; // Adjust the padding factor as needed
                double leftY = y + vGap; // Adjust the vertical spacing
                rootPane.getChildren().add(new Line(x, y + radius, leftX, leftY + radius));
                displayBST(root.left, leftX, leftY, hGap / 2, vGap, radius);
            }
            if (root.right != null) {
                double rightX = x + hGap * 3; // Adjust the padding factor as needed
                double rightY = y + vGap; // Adjust the vertical spacing
                rootPane.getChildren().add(new Line(x, y + radius, rightX, rightY + radius));
                displayBST(root.right, rightX, rightY, hGap / 2, vGap, radius);
            }
        }
    }

	public static void main(String[] args) {
        launch(args);
    }
}
