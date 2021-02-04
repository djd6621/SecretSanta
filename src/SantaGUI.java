// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.StackPane;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;


// public class SantaGUI extends Application{

//     public void init() {
//         SecretSantaPicker ssp = new SecretSantaPicker();
//     }

//     public void start(Stage stage) {

//         stage.setTitle("Secret Santa");
//         TextField nameInput = new TextField("Enter your name...");

//         Label output = new Label();

//         Button submit = new Button("Reveal your secret!") ;

//         Button next = new Button("Next Person");
//         HBox buttons = new HBox();
//         buttons.setSpacing(8);

//         buttons.getChildren().addAll(submit, next);

//         VBox view = new VBox();
//         view.setPadding(new Insets(10));
//         view.setSpacing(8);

//         view.getChildren().addAll(nameInput, output, buttons);

//         view.setAlignment(Pos.CENTER);

//         stage.setScene(new Scene(view, 250, 250));
//         stage.show();

//     }


//     public static void main(String[] args) {
//         Application.launch(args);
//     }

// }
