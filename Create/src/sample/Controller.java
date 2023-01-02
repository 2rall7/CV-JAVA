import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class Controller implements Initializable {

    @FXML
    private TextField nameBox;
    @FXML
    private TextField surnameBox;
    @FXML
    private TextField jobTitleBox;


    @FXML
    private TextField attrNameTextField;
    @FXML
    private TextField attrValueTextField;

    //Create cv tableview
    @FXML
    private TableView<CV> specificCVForcedAttrTableView = new TableView<>();
    @FXML
    private TableColumn<CV, String> firstColumn = new TableColumn<>();
    @FXML
    private TableColumn<CV, String> secondColumn = new TableColumn<>();

    //list all cvs tableview

    @FXML
    private TableView<CV> listPageTableIDView = new TableView<>();
    @FXML
    private TableColumn<CV, Integer> IDfirst = new TableColumn<>();
    @FXML
    private TableColumn<CV, String> IDsecond = new TableColumn<>();
    @FXML
    private TableColumn<CV, String> IDthird = new TableColumn<>();
    @FXML
    private TextField listFirstPageID;

    //list specific cv's attributes tableview
    @FXML
    private TableView<CV> ListPageSpecificTableview = new TableView<>();

    @FXML
    private TableColumn<CV, String> ListPageAttrNameColumn = new TableColumn<>();

    @FXML
    private TableColumn<CV, String> ListPageAttrValueColumn = new TableColumn<>();


    //edit page tableview
    @FXML
    private TableColumn<CV, Integer> editIDCol = new TableColumn<>();

    @FXML
    private TableColumn<CV, String> editNameCol = new TableColumn<>();

    @FXML
    private TableView<CV> editPageTW = new TableView<>();

    @FXML
    private TableColumn<CV, String> editSurnameCol = new TableColumn<>();

    //delete cv page
    @FXML
    private TextField deleteCVTextField;

    @FXML
    private TableColumn<CV, Integer> deleteIDCol = new TableColumn<>();

    @FXML
    private TableColumn<CV, String> deleteNameCol = new TableColumn<>();

    @FXML
    private TableView<CV> deletePageTW = new TableView<>();

    @FXML
    private TableColumn<CV, String> deleteSurnameCol = new TableColumn<>();

    // edit pages
    @FXML
    private TextField columnNameTextField;

    @FXML
    private TextField columnNameTextField1;

    @FXML
    private TextField columnNameTextField11;

    @FXML
    private TextField columnNameTextField12;

    @FXML
    private TextField columnNameTextField2;

    @FXML
    private TextField columnNameTextField21;

    @FXML
    private TextField idTextField;


    //edit page tab 2
    @FXML
    private TableView<CV> editTab2TW = new TableView<>();
    @FXML
    private TableColumn<CV, String> editAttributeName = new TableColumn<>();

    @FXML
    private TableColumn<CV, String> editAttributeValue = new TableColumn<>();

    // search
    @FXML
    private TextField searchTF;

    @FXML
    private TableColumn<CV, Integer> searchID = new TableColumn<>();

    @FXML
    private TableColumn<CV, String> atNameID = new TableColumn<>();

    @FXML
    private TableView<CV> searchTW = new TableView<>();

    @FXML
    private TableColumn<CV, String> atValID = new TableColumn<>();


    @FXML
    private TabPane tabPane;
    @FXML
    private Tab tab1;

    @FXML
    private Tab tab2;

    @FXML
    private TabPane ListPageTabPane;

    @FXML
    private Tab ListPageTab1;

    @FXML
    private Tab ListPageTab2;


    private Stage stage;
    private Scene scene;
    private Parent root;
    private int attrvalueCount;

    ArrayList<CV> CVList = new ArrayList<>();

    //ObservableList<CV> CVObservableList;


    public void switchToWelcomePage(ActionEvent e) throws IOException {

        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCreateCVPage(ActionEvent a) throws IOException {
        root = FXMLLoader.load(getClass().getResource("create.fxml"));
        stage = (Stage) ((Node) a.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void switchToDeleteCVPage(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("delete.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToEditCVPage(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("edit.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToListCVPage(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("list.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToPrintCVPage(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("print.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public void switchToSearchPage(ActionEvent e) throws IOException {

        root = FXMLLoader.load(getClass().getResource("search.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    ArrayList<String> attrvalue;
    ArrayList<String> attrname;

    //ArrayList<String> attrNamesOfThisType = new ArrayList<>(typeAttrsListView.getItems());


    public void saveCVForcedInfo() {


        ObservableList<CV> list = FXCollections.observableArrayList(new CV("Name", nameBox.getText()), new CV("Surname",
                surnameBox.getText()), new CV("Job Title:", jobTitleBox.getText()));


        firstColumn.setCellValueFactory(new PropertyValueFactory<CV, String>("x"));
        secondColumn.setCellValueFactory(new PropertyValueFactory<CV, String>("y"));

        specificCVForcedAttrTableView.setItems(list);

        final String DB_URL = "jdbc:sqlite://C:\\Users\\BLG\\2812ProjeMertDb\\src\\db1.db";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {


            // Open a connection to the database
            conn = DriverManager.getConnection(DB_URL);

            // Create a prepared statement for the INSERT statement
            String sql = "INSERT INTO CV (name, surname, jobTitle) " +
                    "VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            // Set the values for the prepared statement
            stmt.setString(1, nameBox.getText());
            stmt.setString(2, surnameBox.getText());
            stmt.setString(3, jobTitleBox.getText());


            // Execute the INSERT statement
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        nameBox.clear();
        surnameBox.clear();
        jobTitleBox.clear();
    }


    public void CVAddMoreInfoButton() {

        String attrName2 = attrNameTextField.getText();

        boolean valueExists = false;

        for (int i = 0; i < specificCVForcedAttrTableView.getItems().size(); i++) {
            String attrname = specificCVForcedAttrTableView.getItems().get(i).getX();

            if (attrname.equals(attrName2)) {

                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("Error");
                alert.setHeaderText("Can not add new attribute name.");
                alert.setContentText("The input you have given already exists!");

                alert.showAndWait();

                valueExists = true;
                break;
            }
        }

        if (!valueExists) {

            CV temp = new CV(attrNameTextField.getText(), attrValueTextField.getText());
            specificCVForcedAttrTableView.getItems().add(temp);

        }
//

        String jdbcUrl = "jdbc:sqlite://C:\\Users\\BLG\\2812ProjeMertDb\\src\\db1.db ";

        Connection conn1 = null;
        //Statement stmt1 = null;
        try {

            conn1 = DriverManager.getConnection(jdbcUrl);
            String columnName = attrNameTextField.getText();
            String tableName = "CV";

            PreparedStatement stmt = conn1.prepareStatement("SELECT 1 FROM sqlite_master WHERE type='table' AND name=? AND sql LIKE ?");
            stmt.setString(1, tableName);
            stmt.setString(2, "%" + columnName + "%");
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {  // column does not exist
                stmt = conn1.prepareStatement("ALTER TABLE " + tableName + " ADD " + columnName);
                stmt.executeUpdate();
            }

            Statement stmt2 = conn1.createStatement();
            String value = attrValueTextField.getText();
            String sql = "UPDATE " + tableName + " SET " + columnName + " = '" + value + "' WHERE id = (SELECT MAX(id) FROM " + tableName + ")";
            stmt2.executeUpdate(sql);


        }
    } catch(
    SQLException e)

    {
        e.printStackTrace();
    }

    public void createWholeCV() {


        attrvalue = new ArrayList<>();
        attrname = new ArrayList<>();

        CV tempCV = new CV(nameBox.getText(), surnameBox.getText(), jobTitleBox.getText(), attrname, attrvalue);


        CVList.add(tempCV);

        for (int i = 0; i < specificCVForcedAttrTableView.getItems().size(); i++) {

            tempCV.getAttrName().add(specificCVForcedAttrTableView.getItems().get(i).getX());
            tempCV.getAttrvalue().add(specificCVForcedAttrTableView.getItems().get(i).getY());

        }


        // listelere ekleme çalışıyor mu kontrol etmek için kod

        for (int i = 0; i < tempCV.getAttrName().size(); i++) {

            System.out.println(tempCV.getAttrName().get(i) + " " + tempCV.getAttrvalue().get(i));


        }


        specificCVForcedAttrTableView.getItems().clear();
    }


}


