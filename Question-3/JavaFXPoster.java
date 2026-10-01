/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafxposter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Admin
 */
public class JavaFXPoster extends Application{
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

        Label title = new Label("SDG 4");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 42));

        Label subtitle = new Label("QUALITY EDUCATION");
        subtitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        Label slogan = new Label("Ensure inclusive and equitable quality education and promote lifelong learning opportunities for all.");
        slogan.setWrapText(true);
        slogan.setFont(Font.font("Arial", 16));

        VBox header = new VBox(8, title, subtitle, slogan);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(10));

        root.setTop(header);

        Label message = new Label( "Education is the key to a better future!\n"+ "• Equal learning opportunity"+ "• Quality teachers\n"
                + "• Safe learning environments\n"
                + "• Lifelong learning\n"
                + "• Education for everyone");

        message.setFont(Font.font("Arial", 18));
        message.setWrapText(true);

        CheckBox awareness = new CheckBox( "I support Quality Education");

        RadioButton student = new RadioButton("Student");
        RadioButton teacher = new RadioButton("Teacher");
        RadioButton publicUser = new RadioButton("Public");

        ToggleGroup group = new ToggleGroup();

        student.setToggleGroup(group);
        teacher.setToggleGroup(group);
        publicUser.setToggleGroup(group);

        HBox radioBox = new HBox(15, student, teacher, publicUser);

        Label roleLabel = new Label("Choose your role:");

        Label progressLabel=new Label("Education Awareness Level");

        ProgressBar progress = new ProgressBar(0.75);
        progress.setPrefWidth(300);

        VBox centerBox = new VBox(
                15,
                message,
                awareness,
                roleLabel,
                radioBox,
                progressLabel,
                progress
        );

        centerBox.setAlignment(Pos.CENTER);
        centerBox.setPadding(new Insets(25));

        root.setCenter(centerBox);

        Label controlTitle = new Label("Poster Settings");
        controlTitle.setFont(
                Font.font("Arial", FontWeight.BOLD, 20));

        ComboBox<String> backgroundChoice =
                new ComboBox<>();

        backgroundChoice.getItems().addAll(
                "Light Blue",
                "Light Green",
                "Light Yellow",
                "White",
                "Lavender"
        );

        backgroundChoice.setValue("Light Blue");

        Label colorLabel =
                new Label("Background Color:");

        TextField nameField =
                new TextField();

        nameField.setPromptText("Enter your name");

        TextArea ideaField =
                new TextArea();

        ideaField.setPromptText( "Write your idea for improving education...");
        ideaField.setPrefRowCount(4);

        Button applyButton =
                new Button("Apply Theme");

        Button clearButton =
                new Button("Clear");

        Label result =
                new Label("Create your SDG poster!");

        applyButton.setOnAction(e -> {

            String selected =  backgroundChoice.getValue();

            switch (selected) {

                case "Light Blue":
                    root.setBackground( new Background( new BackgroundFill(
                                            Color.LIGHTBLUE,
                                            CornerRadii.EMPTY,
                                            Insets.EMPTY)));
                    break;

                case "Light Green":
                    root.setBackground( new Background(  new BackgroundFill(
                                            Color.LIGHTGREEN,
                                            CornerRadii.EMPTY,
                                            Insets.EMPTY)));
                    break;

                case "Light Yellow":
                    root.setBackground( new Background(  new BackgroundFill(
                                            Color.LIGHTYELLOW,
                                            CornerRadii.EMPTY,
                                            Insets.EMPTY)));
                    break;

                case "White":
                    root.setBackground( new Background( new BackgroundFill(
                                            Color.WHITE,
                                            CornerRadii.EMPTY,
                                            Insets.EMPTY)));
                    break;

                case "Lavender":
                    root.setBackground( new Background(new BackgroundFill(
                                            Color.LAVENDER,
                                            CornerRadii.EMPTY,
                                            Insets.EMPTY)));
                    break;
            }

            String name = nameField.getText();

            if (name.isEmpty()) {
                result.setText(
                        "Please enter your name.");
            } else {
                result.setText(
                        "Thank you, " + name +
                        "! You support Quality Education.");
            }
        });

        clearButton.setOnAction(e -> {

            nameField.clear();
            ideaField.clear();
            awareness.setSelected(false);
            result.setText(
                    "Create your SDG poster!");
        });

        VBox rightBox = new VBox(
                12,
                controlTitle,
                colorLabel,
                backgroundChoice,
                new Label("Your Name:"),
                nameField,
                new Label("Your Idea:"),
                ideaField,
                applyButton,
                clearButton,
                result
        );

        rightBox.setPadding(new Insets(15));
        rightBox.setPrefWidth(300);

        root.setRight(rightBox);


        Label footer = new Label(
                "SDG 4 | QUALITY EDUCATION | Education for All");

        footer.setFont(
                Font.font("Arial", FontWeight.BOLD, 16));

        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(15));

        root.setBottom(footer);


        Scene scene =
                new Scene(root, 1100, 700);

        stage.setTitle(
                "SDG 4 - Quality Education");

        stage.setScene(scene);
        stage.show();
    }

       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         launch(args);
        
    }
    
}
