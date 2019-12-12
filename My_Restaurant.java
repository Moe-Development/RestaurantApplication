import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class My_Restaurant extends Application {

    // adding windows
    Stage window;
    Scene scene1, scene2;

    // graphics
    GraphicsContext gc;

    // buttons
    Button scene1_button, scene2_button2,scene2_button, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31, b32;
    Button cock, water, beer;
    //food buttons
    Button kebab_plate;

    //primery keys
    Button removeTable, viewTables, save, add, take;

    //labels
    Label l1, availableTable_header, drinks_header, food_header, drink_Border,food_Border;

    //Text box
    TextField tf;



    //add or take control
    int add_take;
    int select_item;

    // control varaibles
    String s = "";
    double total_cost;


    //delete  control
    int delete = 0;


    //new class stuff
    int table_Number = 0;

    //tables cost
    double table_1_cost;
    double table_2_cost;
    double table_3_cost;

    // main array
    ArrayList<ArrayList> tables;

    //tables lists
    ArrayList<String>table_1_list;
    ArrayList<String>table_2_list;
    ArrayList<String>table_3_list;



    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        Pane first_root = new Pane();
        window.setTitle("Mohamad Restaurant "); // set the window title here
        //window.setScene(scene1);
        Canvas canvas1 = new Canvas(2000, 1000);
        Canvas canvas2 = new Canvas(2000, 1000);

        // scene 1 setting
        scene1_button = new Button("Back to Main");
        scene1_button.relocate(1250, 20);
        scene1_button.setOnAction(e -> window.setScene(scene2));
        scene1 = new Scene(first_root, 2000, 1000); // set the size here

        // scene 2 setting
        scene2_button = new Button("Go To Restaurant");
        scene2_button.relocate(1500, 500);
        scene2_button.setOnAction(e -> window.setScene(scene1));
        Pane second_root = new Pane();
        scene2 = new Scene(second_root, 2000, 1000);

        // button copy
        scene2_button2 = new Button("Go To Restaurant");
        scene2_button2.relocate(270, 500);
        scene2_button2.setOnAction(e -> window.setScene(scene1));


        // main list
        tables = new ArrayList<>();
        // new lists for new class
        table_1_list = new ArrayList<>();
        table_2_list = new ArrayList<>();

        //image

        // canvas 1
        gc = canvas1.getGraphicsContext2D();
        gc.setFill(Color.RED);                               // background color
        gc.fillRect(0, 0, 2000, 1000);

        // orders background
        gc = canvas1.getGraphicsContext2D();
        gc.setFill(Color.LIGHTBLUE);                               // background color
        gc.fillRect(0, 0, 350, 1000);

        //items background
        gc = canvas1.getGraphicsContext2D();
        gc.setFill(Color.BISQUE);                               // background color
        gc.fillRect(350, 80, 1275, 1000);

        // canvas 2
        gc = canvas2.getGraphicsContext2D();
        gc.setFill(Color.SADDLEBROWN);                               // background color
        gc.fillRect(0, 0, 2000, 1000);


        //my image
        Image image = new Image("file:mohamad.jpg");
        ImageView iv = new ImageView(image);
        iv.setFitHeight(1000);
        iv.setFitWidth(900);
        iv.setX(500);
        iv.setY(0);


        //Todo : Labels and headers section

        //labels
        l1 = new Label("Start with: \nAdd to Table:");
        l1.relocate(15, 10);
        l1.setFont(new Font("Arial", 20));


        availableTable_header = new Label("\tMy Tables\n ==============");
        availableTable_header.relocate(1650, 20);
        availableTable_header.setStyle("-fx-text-fill: lightGreen");
        availableTable_header.setFont(new Font("Arial", 30));

        // items label header
        drinks_header = new Label("Drinks List\n=========");
        drinks_header.setFont(new Font("Arial", 20));
        drinks_header.setStyle("-fx-text-fill: blue");
        drinks_header.relocate(1515,85);

        // adding drink border
        drink_Border = new Label("||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n");
        drink_Border.setFont(new Font("Arial", 20));
        drink_Border.setStyle("-fx-text-fill: red");
        drink_Border.relocate(1500,85);

        // items food  header
        food_header = new Label("Food List\n=========");
        food_header.setFont(new Font("Arial", 20));
        food_header.setStyle("-fx-text-fill: blue");
        food_header.relocate(1390,85);

        // adding food border
        food_Border = new Label("||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n||\n");
        food_Border.setFont(new Font("Arial", 20));
        food_Border.setStyle("-fx-text-fill: red");
        food_Border.relocate(1375,85);

        // Todo: Drinks item button
        cock = new Button("Cock");
        water = new Button("Water");
        beer = new Button("Beer");


        //Todo: Food Items Buttons
        kebab_plate = new Button("Kebab Plate");


        //Todo: primary keys buttons
        removeTable = new Button("Remove Table");
        viewTables = new Button("Current Tables");
        save = new Button("Done");
        add = new Button("Add to Table");
        take = new Button("Take off");

        //Todo: primary keys locations
        removeTable.relocate(650, 20);
        save.relocate(800, 20);
        add.relocate(950, 20);
        take.relocate(1100, 20);


        //Todo: primary buttons width
        removeTable.setPrefWidth(115);
        save.setPrefWidth(115);
        add.setPrefWidth(115);
        take.setPrefWidth(115);


        //Todo: Drinks items button width
        cock.setPrefWidth(100);
        water.setPrefWidth(100);
        beer.setPrefWidth(100);

        //Todo: Drinks item re locate
        cock.relocate(1515, 130);
        water.relocate(1515, 170);
        beer.relocate(1515, 210);

        //Todo: Food items width
        kebab_plate.setPrefWidth(100);


        //Todo: Food items Re Locate
        kebab_plate.relocate(1390,130);

        //declaring  the buttons
        b1 = new Button("1");
        b2 = new Button("2");
        b3 = new Button("3");
        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");
        b10 = new Button("10");
        b11 = new Button("11");
        b12 = new Button("12");
        b13 = new Button("13");
        b14 = new Button("14");
        b15 = new Button("15");
        b16 = new Button("16");
        b17 = new Button("17");
        b18 = new Button("18");
        b19 = new Button("19");
        b20 = new Button("20");
        b21 = new Button("21");
        b22 = new Button("22");
        b23 = new Button("23");
        b24 = new Button("24");
        b25 = new Button("25");
        b26 = new Button("26");
        b27 = new Button("27");
        b28 = new Button("28");
        b29 = new Button("29");
        b30 = new Button("30");
        b31 = new Button("31");
        b32 = new Button("32");


        //Todo: Tables button locations
        b1.relocate(1650, 100);
        b2.relocate(1720, 100);
        b3.relocate(1790, 100);
        b4.relocate(1860, 100);

        b5.relocate(1650, 150);
        b6.relocate(1720, 150);
        b7.relocate(1790, 150);
        b8.relocate(1860, 150);

        b9.relocate(1650, 200);
        b10.relocate(1720, 200);
        b11.relocate(1790, 200);
        b12.relocate(1860, 200);

        b13.relocate(1650, 250);
        b14.relocate(1720, 250);
        b15.relocate(1790, 250);
        b16.relocate(1860, 250);

        b17.relocate(1650, 300);
        b18.relocate(1720, 300);
        b19.relocate(1790, 300);
        b20.relocate(1860, 300);

        b21.relocate(1650, 350);
        b22.relocate(1720, 350);
        b23.relocate(1790, 350);
        b24.relocate(1860, 350);

        b25.relocate(1650, 400);
        b26.relocate(1720, 400);
        b27.relocate(1790, 400);
        b28.relocate(1860, 400);

        b29.relocate(1650, 450);
        b30.relocate(1720, 450);
        b31.relocate(1790, 450);
        b32.relocate(1860, 450);

        //buttons width
        b1.setPrefWidth(50);
        b2.setPrefWidth(50);
        b3.setPrefWidth(50);
        b4.setPrefWidth(50);
        b5.setPrefWidth(50);
        b6.setPrefWidth(50);
        b7.setPrefWidth(50);
        b8.setPrefWidth(50);
        b9.setPrefWidth(50);
        b10.setPrefWidth(50);
        b11.setPrefWidth(50);
        b12.setPrefWidth(50);
        b13.setPrefWidth(50);
        b14.setPrefWidth(50);
        b15.setPrefWidth(50);
        b16.setPrefWidth(50);
        b17.setPrefWidth(50);
        b18.setPrefWidth(50);
        b19.setPrefWidth(50);
        b20.setPrefWidth(50);
        b21.setPrefWidth(50);
        b22.setPrefWidth(50);
        b23.setPrefWidth(50);
        b24.setPrefWidth(50);
        b25.setPrefWidth(50);
        b26.setPrefWidth(50);
        b27.setPrefWidth(50);
        b28.setPrefWidth(50);
        b29.setPrefWidth(50);
        b30.setPrefWidth(50);
        b31.setPrefWidth(50);
        b32.setPrefWidth(50);

        //Todo: the root for the main scene 1
        first_root.getChildren().addAll(canvas1,drink_Border,food_header, availableTable_header,drinks_header,food_Border,
                scene1_button, l1, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31, b32,
                cock, water, beer,
                kebab_plate,
                save, add, take,removeTable);

        // the root for the second scene 2
        second_root.getChildren().addAll(canvas2,iv,scene2_button,scene2_button2);

        // primary buttons actions
        removeTable.setOnAction(this::removeTable);
        viewTables.setOnAction(this::viewTables);
        save.setOnAction(this::save);
        add.setOnAction(this::add);
        take.setOnAction(this::take);

        //todo: Drinks items button action
        cock.setOnAction(this::cock);
        water.setOnAction(this::water);
        beer.setOnAction(this::beer);

        //todo: Food items Button action
        kebab_plate.setOnAction(this::kebabPlate);

        //tables action
        b1.setOnAction(this::b1);
        b2.setOnAction(this::b2);

        //running program
        window.setScene(scene2);
        window.show();
    }

    private void take(ActionEvent actionEvent) {
        if (tables.size() > 0) {
            take.setStyle("-fx-background-color: lightGreen");
            add.setStyle("");
            removeTable.setStyle("");
            save.setStyle("");

            add_take = 2;
            l1.setStyle("-fx-text-fill: black");
            l1.setText("Select Table:");
            //savecontrol = 0;
            table_Number = 0;
            new Alert(Alert.AlertType.INFORMATION, "Select Table !").showAndWait();
        } else{new Alert(Alert.AlertType.WARNING, "No Tables Yet !").showAndWait();}

    }

    private void add(ActionEvent actionEvent) {
        add.setStyle("-fx-background-color: lightGreen");
        take.setStyle("");
        removeTable.setStyle("");
        save.setStyle("");

        add_take = 1;
        table_Number = 0;
        l1.setStyle("-fx-text-fill: black");
        l1.setText("Select Table:");
    }

    private void save(ActionEvent actionEvent) {

            save.setStyle("-fx-background-color: lightGreen");
            take.setStyle("");
            removeTable.setStyle("");
            add.setStyle("");
            kebab_plate.setStyle("");


            delete = 0;
            table_Number = 0;
            add_take = 0;
            l1.setText("Start with: \nAdd to Table:");

    }

    private void b2(ActionEvent actionEvent) {
        if ((add_take == 1 || add_take == 2) || table_2_list.size() > 0) {
            l1.setStyle("-fx-text-fill: black");
            table_Number = 2;
            String t1 = "Table 2\n=========\n";
            l1.setText(t1);

        }
        if (table_2_list.size() <= 0){
            b2.setStyle("");
        }
        if (table_2_list.size() > 0) {
            b2.setStyle("-fx-background-color: green");
            if (tables.contains(table_2_list)){
                tables.remove(table_2_list);
            }
            tables.add(table_2_list);
            l1.setStyle("-fx-text-fill: black");
            String t = "Table 2\n=========\n";
            for (String e : table_2_list) {
                t += e;
            }

            l1.setText(t + "\n----------------------\nTotal Cost: $" + table_2_cost);
            beer.setStyle("");
            water.setStyle("");
            cock.setStyle("");
            s = "";

        }

    }


    private void removeTable(ActionEvent actionEvent) {
        if (tables.size() > 0) {
            removeTable.setStyle("-fx-background-color: lightGreen");
            take.setStyle("");
            save.setStyle("");
            add.setStyle("");

            delete += 1;
            if (delete == 1) {
                new Alert(Alert.AlertType.WARNING, "You are about to Delete a Table.\n1- Click on the table button. \n2- Click on the Remove Table to delete the table.\n\n** To Cancel Click on Save Button.").showAndWait();
                l1.setText("You are about to Delete a Table.\n1- Click on the table button. \n2- Click on Remove to delete.\n\n** To Cancel Click on Save Button.");
                table_Number = 0;
            }
            if (delete == 2 && table_Number > 0) {
                if (table_Number == 1) {
                    table_1_list.clear();
                    table_1_cost = 0;
                    tables.remove(table_1_list);
                    b1.setStyle("");
                    removeTable.setStyle("");
                    l1.setText("Table 1 Removed");
                    delete = 0;
                    add_take = 0;
                }
                if (table_Number == 2) {
                    table_2_list.clear();
                    table_2_cost = 0;
                    tables.remove(table_2_list);
                    b2.setStyle("");
                    removeTable.setStyle("");
                    l1.setText("Table 2 Removed");
                    delete = 0;
                    add_take = 0;
                }
            }

        } else {
            new Alert(Alert.AlertType.WARNING, "No Tables To Delete!!").showAndWait();
        }

    }

    private void b1(ActionEvent actionEvent) {
        if ((add_take == 1 || add_take == 2) || table_1_list.size() > 0) {
            l1.setStyle("-fx-text-fill: black");
            table_Number = 1;
            String t1 = "Table 1\n=========\n";
            l1.setText(t1);

        }
        if (table_1_list.size() <= 0){
            b1.setStyle("");
        }
        if (table_1_list.size() > 0) {
            b1.setStyle("-fx-background-color: green");
            if (tables.contains(table_1_list)){
                tables.remove(table_1_list);
            }
            tables.add(table_1_list);
            l1.setStyle("-fx-text-fill: black");
            String t = "Table 1\n=========\n";
            for (String e : table_1_list) {
                t += e;
            }

            l1.setText(t + "\n----------------------\nTotal Cost: $" + table_1_cost);
            beer.setStyle("");
            water.setStyle("");
            cock.setStyle("");
            s = "";

        }

    }

    private void setTable() {
        String r = "";
        total_cost = 0;
        String temString = "";
        if (select_item == 1) {
            r = "Cock $2.00\n";
            total_cost += 2.00;
            select_item = 0;

            if (add_take == 1) {
                if (table_Number == 1) {
                    table_1_list.add(r);
                    table_1_cost += total_cost;
                    s += "Cock $2.00\n";

                }
                if (table_Number == 2) {
                    table_2_list.add(r);
                    table_2_cost += total_cost;
                    s += "Cock $2.00\n";

                }
            }
            if (add_take == 2){
                if (table_Number == 1) {
                    if (table_1_list.contains(r)) {
                        table_1_list.remove(r);
                        table_1_cost -= 2;
                        for (String e : table_1_list) {
                            temString += e;
                        }
                    }else{
                        for (String e : table_1_list) {
                            temString += e;
                        }
                    }
                }
                if (table_Number == 2) {
                    if (table_2_list.contains(r)) {
                        table_2_list.remove(r);
                        table_2_cost -= 2;
                        for (String e : table_2_list) {
                            temString += e;
                        }
                    }else{
                        for (String e : table_2_list) {
                            temString += e;
                        }
                    }
                }
            }

        }
        if (select_item == 2) {
            r = "Water $1.00\n";
            total_cost += 1.00;
            select_item = 0;
            if (add_take == 1) {
                if (table_Number == 1) {
                    table_1_list.add(r);
                    table_1_cost += total_cost;
                    s += "Water $1.00\n";

                }
                if (table_Number == 2) {
                    table_2_list.add(r);
                    table_2_cost += total_cost;
                    s += "Water $1.00\n";

                }
            }
            if (add_take == 2){
                if (table_Number == 1) {
                    if (table_1_list.contains(r)) {
                        table_1_list.remove(r);
                        table_1_cost -= 1;
                        for (String e : table_1_list) {
                            temString += e;
                        }
                    }else{
                        for (String e : table_1_list) {
                            temString += e;
                        }
                    }
                }
                if (table_Number == 2) {
                    if (table_2_list.contains(r)) {
                        table_2_list.remove(r);
                        table_2_cost -= 1;
                        for (String e : table_2_list) {
                            temString += e;
                        }
                    }else{
                        for (String e : table_2_list) {
                            temString += e;
                        }
                    }
                }
            }
        }
        if (select_item == 3) {
            r = "Beer $5.00\n";
            total_cost += 5.00;
            select_item = 0;
            if (add_take == 1) {
                if (table_Number == 1) {
                    table_1_list.add(r);
                    table_1_cost += total_cost;
                    s += "Beer $5.00\n";

                }
                if (table_Number == 2) {
                    table_2_list.add(r);
                    table_2_cost += total_cost;
                    s += "Beer $5.00\n";

                }
            }
            if (add_take == 2){
                if (table_Number == 1) {
                    if (table_1_list.contains(r)) {
                        table_1_list.remove(r);
                        table_1_cost -= 5;
                        for (String e : table_1_list) {
                            temString += e;
                        }
                    }else{
                        for (String e : table_1_list) {
                            temString += e;
                        }
                    }
                }
                if (table_Number == 2) {
                    if (table_2_list.contains(r)) {
                        table_2_list.remove(r);
                        table_2_cost -= 5;
                        for (String e : table_2_list) {
                            temString += e;
                        }
                    }else{
                        for (String e : table_2_list) {
                            temString += e;
                        }
                    }

                }
            }

        }
        if (select_item == 4) {
            r = "Kebab Plate $15.00\n";
            total_cost += 15.00;
            select_item = 0;

            if (add_take == 1) {
                if (table_Number == 1) {
                    table_1_list.add(r);
                    table_1_cost += total_cost;
                    s += "Kebab Plate $15.00\n";

                }
                if (table_Number == 2) {
                    table_2_list.add(r);
                    table_2_cost += total_cost;
                    s += "Kebab Plate $15.00\n";

                }
            }
            if (add_take == 2){
                if (table_Number == 1) {
                    if (table_1_list.contains(r)) {
                        table_1_list.remove(r);
                        table_1_cost -= 15;
                        for (String e : table_1_list) {
                            temString += e;
                        }
                    }else{
                        for (String e : table_1_list) {
                            temString += e;
                        }
                    }
                }
                if (table_Number == 2) {
                    if (table_2_list.contains(r)) {
                        table_2_list.remove(r);
                        table_2_cost -= 15;
                        for (String e : table_2_list) {
                            temString += e;
                        }
                    }else{
                        for (String e : table_2_list) {
                            temString += e;
                        }
                    }
                }
            }

        }


        // adding items
        if (add_take == 1) {
            if (table_Number == 1) {
                l1.setText("Table 1\n=========\n" + s + "\n----------------------\nTotal Cost: $" + table_1_cost);
            }
            if (table_Number == 2) {
                l1.setText("Table 2\n=========\n" + s + "\n----------------------\nTotal Cost: $" + table_2_cost);
            }
        }

        // taking off items
        if (add_take == 2){
            if (table_Number == 1) {
                l1.setText("Table 1\n=========\n" + temString + "\n----------------------\nTotal Cost: $" + table_1_cost);
            }
            if (table_Number == 2) {
                l1.setText("Table 2\n=========\n" + temString + "\n----------------------\nTotal Cost: $" + table_2_cost);
            }
        }
    }

    // Todo: Drinks items methods
    private void cock(ActionEvent e) {
        if ((add_take == 1 || add_take == 2) && table_Number > 0) {
            cock.setStyle("-fx-background-color: green");
            beer.setStyle("");
            water.setStyle("");

            //food buttons
            kebab_plate.setStyle("");

            select_item = 1;
            setTable();
        }


    }

    private void water(ActionEvent e) {

        if ((add_take == 1 || add_take == 2) && table_Number > 0) {
            water.setStyle("-fx-background-color: green");
            cock.setStyle("");
            beer.setStyle("");

            //food buttons
            kebab_plate.setStyle("");


            select_item = 2;
            setTable();
        }

    }

    private void beer(ActionEvent e) {
        if ((add_take == 1 || add_take == 2) && table_Number > 0) {
            beer.setStyle("-fx-background-color: green");
            cock.setStyle("");
            water.setStyle("");

            //food buttons
            kebab_plate.setStyle("");

            select_item = 3;
            setTable();
        }

    }

    //todo: Food items methods
    private void kebabPlate(ActionEvent e) {
        if ((add_take == 1 || add_take == 2) && table_Number > 0) {
            kebab_plate.setStyle("-fx-background-color: green");

            //Drinks button
            cock.setStyle("");
            beer.setStyle("");
            water.setStyle("");

            select_item = 4;
            setTable();
        }

    }

    public static void main(String[] args) {

        launch(args);
    }


}
