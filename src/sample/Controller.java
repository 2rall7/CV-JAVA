package sample;
import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


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
    private TableView<CV> ListPageSpecificTableview=new TableView<>();

    @FXML
    private TableColumn<CV,String> ListPageAttrNameColumn=new TableColumn<>();

    @FXML
    private TableColumn<CV, String> ListPageAttrValueColumn=new TableColumn<>();


//edit page tableview
@FXML
private TableColumn<CV, Integer> editIDCol=new TableColumn<>();

    @FXML
    private TableColumn<CV, String> editNameCol=new TableColumn<>();

    @FXML
    private TableView<CV> editPageTW=new TableView<>();

    @FXML
    private TableColumn<CV, String> editSurnameCol=new TableColumn<>();

//delete cv page
    @FXML
    private TextField deleteCVTextField;

    @FXML
    private TableColumn<CV,Integer> deleteIDCol=new TableColumn<>();

    @FXML
    private TableColumn<CV, String > deleteNameCol=new TableColumn<>();

    @FXML
    private TableView<CV> deletePageTW=new TableView<>();

    @FXML
    private TableColumn<CV, String> deleteSurnameCol=new TableColumn<>();

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
    private TableView<CV> editTab2TW=new TableView<>();
    @FXML
    private TableColumn<CV, String> editAttributeName=new TableColumn<>();

    @FXML
    private TableColumn<CV, String> editAttributeValue=new TableColumn<>();

    // search
    @FXML
    private TextField searchTF;

    @FXML
    private TableColumn<CV,Integer> searchID=new TableColumn<>();

    @FXML
    private TableColumn<CV, String > atNameID=new TableColumn<>();

    @FXML
    private TableView<CV> searchTW=new TableView<>();

    @FXML
    private TableColumn<CV, String> atValID=new TableColumn<>();

    @FXML
    private ComboBox<String> searchComboBox= new ComboBox<>();


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

    // tag page
    @FXML
    private TextField tagIDTextField;

    @FXML
    private TextField tagNameTextField;


    // show pdf
   @FXML
    private WebView webView=new WebView();


    @FXML
    private TextField pdfTextBox;


    // tag tab
    @FXML
    private TableView<CV> tagTableView=new TableView<>();
    @FXML
    private TableColumn<CV,Integer> tagID=new TableColumn<>();
    @FXML
    private TableColumn<CV,String> tagName=new TableColumn<>();
    @FXML
    private TableColumn<CV, String> tagSurname=new TableColumn<>();
    @FXML
    private ComboBox<String> tagNamesComboBox=new ComboBox<>();
    @FXML
    private Tab ListPageTagTab= new Tab();




    private Stage stage;
    private Scene scene;
    private Parent root;
    private int attrvalueCount;

    ArrayList<CV> CVList = new ArrayList<>();


    public void switchToWelcomePage(ActionEvent e) throws IOException {

        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

    }

    public void switchToCreateCVPage(ActionEvent a) throws IOException {
        root = FXMLLoader.load(getClass().getResource("create.fxml"));
        stage = (Stage) ((Node) a.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);




    }

    public void switchToDeleteCVPage(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("delete.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);


    }

    public void switchToEditCVPage(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("edit.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);


    }

    public void switchToListCVPage(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("list.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);


    }




    public void switchToSearchPage(ActionEvent e) throws IOException {

        root = FXMLLoader.load(getClass().getResource("search.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

    }


    ArrayList<String> attrvalue;
    ArrayList<String> attrname;


    public void saveCVForcedInfo() {


        ObservableList<CV> list = FXCollections.observableArrayList(new CV("Name", nameBox.getText()), new CV("Surname",
                surnameBox.getText()), new CV("Job Title:", jobTitleBox.getText()));


        firstColumn.setCellValueFactory(new PropertyValueFactory<CV, String>("x"));
        secondColumn.setCellValueFactory(new PropertyValueFactory<CV, String>("y"));

        specificCVForcedAttrTableView.setItems(list);

        PreparedStatement stmt = null;

        String url = "jdbc:sqlite:database.db";
        try {
            Class.forName("org.sqlite.JDBC");

            Connection conn = DriverManager.getConnection(url);

            String sql = "INSERT INTO CV (name, surname, jobTitle) " +
                    "VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, nameBox.getText());
            stmt.setString(2, surnameBox.getText());
            stmt.setString(3, jobTitleBox.getText());


            // Execute the INSERT statement
            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        nameBox.clear();
        surnameBox.clear();
        jobTitleBox.clear();
    }


    public void createWholeCV() {


        attrvalue = new ArrayList<>();
        attrname = new ArrayList<>();



        CV tempCV = new CV(nameBox.getText(), surnameBox.getText(), jobTitleBox.getText(), attrname, attrvalue);


        CVList.add(tempCV);


// arrayliste tablodan çekme

        for (int i = 0; i < specificCVForcedAttrTableView.getItems().size(); i++) {

            tempCV.getAttrName().add(specificCVForcedAttrTableView.getItems().get(i).getX());
            tempCV.getAttrvalue().add(specificCVForcedAttrTableView.getItems().get(i).getY());

        }


        specificCVForcedAttrTableView.getItems().clear();

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


        String url = "jdbc:sqlite:database.db";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn1 = DriverManager.getConnection(url);
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


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        attrNameTextField.clear();
        attrValueTextField.clear();
    }


    // edit page tabpane switching between tabs methods
    public void goToEditTab2() {

        String url = "jdbc:sqlite:database.db";
        try {
            Class.forName("org.sqlite.JDBC");

            Connection connection = DriverManager.getConnection(url);

            ObservableList<CV> data3 = FXCollections.observableArrayList();


            Statement stmt = connection.createStatement();

            String sql = "SELECT * FROM CV";

            ResultSet rs = stmt.executeQuery(sql);


            ResultSetMetaData metaData = rs.getMetaData();


            int numColumns = metaData.getColumnCount();


            ArrayList<String> allColumnNames= new ArrayList<>();


            ObservableList<CV> list2 = FXCollections.observableArrayList(new CV("",""));

            editAttributeName.setCellValueFactory(new PropertyValueFactory<CV, String>("x"));
            editAttributeValue.setCellValueFactory(new PropertyValueFactory<CV, String>("y"));


            editTab2TW.setItems(list2) ;


            List<String> columnValues = new ArrayList<>();


            String id=idTextField.getText();

            int integerID=Integer.parseInt(id);

            String sql2 = "SELECT * FROM CV WHERE id ="+integerID;


            ResultSet rs2 = stmt.executeQuery(sql2);

            while (rs2.next()) {

                for (int i = 1; i <= numColumns; i++) {


                    String columnName = metaData.getColumnName(i);
                    allColumnNames.add(columnName);

                    String columnValue = rs2.getString(i);
                    columnValues.add(columnValue);


                    CV temp2 = new CV(columnName, columnValue);

                    editTab2TW.getItems().add(temp2);


                }
            }
            rs.close();
            stmt.close();
            connection.close();
        }

        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        tabPane.getSelectionModel().select(tab2);

    }

    public void goToEditTab1(){
        tabPane.getSelectionModel().select(tab1);

    }

    // list page tabpane switching between tabs methods


    public void goToListPageTab2() {

        String url = "jdbc:sqlite:database.db";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(url);

            ObservableList<CV> data3 = FXCollections.observableArrayList();

            Statement stmt = connection.createStatement();

            String sql = "SELECT * FROM CV";

            ResultSet rs = stmt.executeQuery(sql);

            ResultSetMetaData metaData = rs.getMetaData();

            int numColumns = metaData.getColumnCount();

            ArrayList<String> allColumnNames= new ArrayList<>();


            ObservableList<CV> list2 = FXCollections.observableArrayList(new CV("",""));

            ListPageAttrNameColumn.setCellValueFactory(new PropertyValueFactory<CV, String>("x"));
            ListPageAttrValueColumn.setCellValueFactory(new PropertyValueFactory<CV, String>("y"));


            ListPageSpecificTableview.setItems(list2) ;


            List<String> columnValues = new ArrayList<>();


            String id=listFirstPageID.getText();
            int integerID=Integer.parseInt(id);
            String sql2 = "SELECT * FROM CV WHERE id ="+integerID;


            ResultSet rs2 = stmt.executeQuery(sql2);

            while (rs2.next()) {

                for (int i = 1; i <= numColumns; i++) {


                    String columnName = metaData.getColumnName(i);
                    allColumnNames.add(columnName);

                    String columnValue = rs2.getString(i);
                    columnValues.add(columnValue);


                    CV temp2 = new CV(columnName, columnValue);

                    ListPageSpecificTableview.getItems().add(temp2);

                }
            }

            rs.close();
            stmt.close();
            connection.close();
        }

     catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }



        ListPageTabPane.getSelectionModel().select(ListPageTab2);

    }

    public void goToListPageTab1(){
        ListPageTabPane.getSelectionModel().select(ListPageTab1);

    }

    public void deleteCV(ActionEvent b) throws IOException{
        PreparedStatement preparedStatement = null;

        String url = "jdbc:sqlite:database.db";
        try {

            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(url);

            String deleteSQL = "DELETE FROM CV WHERE id = " + deleteCVTextField.getText();
            preparedStatement = connection.prepareStatement(deleteSQL);

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        deleteCVTextField.clear();

        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage) ((Node) b.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void renameMethod (ActionEvent b) throws IOException{
            PreparedStatement preparedStatement= null;


        String url = "jdbc:sqlite:database.db";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(url);
        String updateSQL = "UPDATE CV SET " + columnNameTextField.getText() + " = ? WHERE id = "+idTextField.getText();
        preparedStatement = connection.prepareStatement(updateSQL);

        preparedStatement.setString(1, columnNameTextField1.getText());


        preparedStatement.executeUpdate();

    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
        columnNameTextField.clear();
        columnNameTextField1.clear();

       root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage) ((Node) b.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public void editPageAddNewInfo(ActionEvent b) throws IOException {
        PreparedStatement preparedStatement = null;
        String url = "jdbc:sqlite:database.db";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(url);
            String columnName = columnNameTextField12.getText();
            String tableName = "CV";


            PreparedStatement stmt = connection.prepareStatement("SELECT 1 FROM sqlite_master WHERE type='table' AND name=? AND sql LIKE ?");
            stmt.setString(1, tableName);
            stmt.setString(2, "%" + columnName + "%");
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                stmt = connection.prepareStatement("ALTER TABLE " + tableName + " ADD " + columnName);
                stmt.executeUpdate();
            }

            String updateSQL = "UPDATE CV SET " + columnNameTextField12.getText() + " = ? WHERE id = " + idTextField.getText();
            preparedStatement  = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, columnNameTextField11.getText());
            preparedStatement.executeUpdate();

            rs.close();
            stmt.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();
        }

        columnNameTextField12.clear();
        columnNameTextField11.clear();

        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage) ((Node) b.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

        public void deletesmthingCv(ActionEvent b) throws IOException{
            PreparedStatement preparedStatement = null;


            String url = "jdbc:sqlite:database.db";
            try {
                Class.forName("org.sqlite.JDBC");
                Connection connection = DriverManager.getConnection(url);


                String deleteSQL = "UPDATE CV SET " + columnNameTextField2.getText() + " = ? WHERE id = " + idTextField.getText();

                preparedStatement = connection.prepareStatement(deleteSQL);


                preparedStatement.setString(1, null);


                preparedStatement.executeUpdate();

            } catch (SQLException | ClassNotFoundException e) {

                e.printStackTrace();

            }
            columnNameTextField2.clear();

            root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
            stage = (Stage) ((Node) b.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    public void showAllTaggedIDNames(){

        String url = "jdbc:sqlite:database.db";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(url);

            String selectedTagName=tagNamesComboBox.getSelectionModel().getSelectedItem();

            PreparedStatement stmt4 = connection.prepareStatement("SELECT CV.id,CV.name,CV.surname FROM CV INNER JOIN tags ON CV.id= tags.cv_id" +
                    " WHERE tag LIKE '"+
                    selectedTagName + "'");


            ResultSet rs4 = stmt4.executeQuery();

            List<CV> tagList = new ArrayList<>();

            while (rs4.next()) {

                int value1 = rs4.getInt("id");
                String value2 = rs4.getString("name");
                String value3 = rs4.getString("surname");
                tagList.add(new CV(value1,value2,value3));
            }

            ObservableList<CV> tagData = FXCollections.observableArrayList(tagList);
            tagTableView.setItems(tagData);

        }
        catch (SQLException | ClassNotFoundException a) {
            a.printStackTrace();
        }

    }

        public void search(){
            String url = "jdbc:sqlite:database.db";
            try {
                Class.forName("org.sqlite.JDBC");
                Connection connection = DriverManager.getConnection(url);

                 String searchTerm = searchTF.getText();


                String selectedColumnNameSrc=searchComboBox.getSelectionModel().getSelectedItem();

                PreparedStatement stmt4 = connection.prepareStatement("SELECT * FROM CV WHERE " +selectedColumnNameSrc+" LIKE '"+
                        searchTF.getText() + "'");

                    ResultSet rs4 = stmt4.executeQuery();


                    List<CV> data = new ArrayList<>();

                    while (rs4.next()) {

                        int value1 = rs4.getInt("id");
                        String value2 = rs4.getString("name");
                        String value3 = rs4.getString("surname");

                        data.add(new CV(value1,value2,value3));
                    }

                    ObservableList<CV> ListPageData = FXCollections.observableArrayList(data);
                    searchTW.setItems(ListPageData);

            }
            catch (SQLException | ClassNotFoundException a) {
                    a.printStackTrace();
                }
            searchTF.clear();

        }



    public void tag() {
        String url = "jdbc:sqlite:database.db";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT CV.*, tags.tag FROM CV INNER JOIN tags ON CV.id = tags.cv_id");


        while (rs.next()) {
             rs.getInt("id");
             rs.getString("name");
            rs.getString("tag");
        }
    }

        catch (SQLException | ClassNotFoundException a) {
            a.printStackTrace();
        }

         url = "jdbc:sqlite:database.db";

        try {

            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tags (cv_id, tag) VALUES (?, ?)");

            int cvId = Integer.parseInt(tagIDTextField.getText());

            String tags = tagNameTextField.getText();
            String[] tagList = tags.split(",");
            for (String tag : tagList) {
                pstmt.setInt(1, cvId);
                pstmt.setString(2, tag);
                pstmt.executeUpdate();

            }

            pstmt.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException a) {
            a.printStackTrace();
        }

        tagNameTextField.clear();

    }

        public void print() throws IOException {

            FileChooser fileChooser = new FileChooser();
            MouseEvent mouseEvent = null;
            File file = fileChooser.showSaveDialog(new Stage());

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf"));
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All files (*.*)", "*.*"));

                if (file != null) {
                    //bw.write("Attrname: Attrvalue");
                    //bw.newLine();
                    //print(file,ListPageSpecificTableview.getItems().get(i).get);
                    for (int i = 0; i < ListPageSpecificTableview.getItems().size(); i++) {


                        String attrname = (ListPageSpecificTableview.getItems().get(i).getX());


                        String attrvalue = (ListPageSpecificTableview.getItems().get(i).getY());

                        bw.write(attrname + ": " + attrvalue);
                        bw.newLine();
                    }


                }

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }





    public void deleteTag(){
        String url = "jdbc:sqlite:database.db";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);
            Statement stmt5=conn.createStatement();

            String valueToDelete = tagNamesComboBox.getSelectionModel().getSelectedItem();
            String deleteSql = "DELETE FROM tags WHERE tag = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(deleteSql);
            preparedStatement.setString(1, valueToDelete);
            preparedStatement.executeUpdate();

        }

        catch (SQLException | ClassNotFoundException a) {
            a.printStackTrace();
        }

    }

    public void gotoListForTagPage(ActionEvent a) throws IOException{


        root = FXMLLoader.load(getClass().getResource("list.fxml"));
        stage = (Stage) ((Node) a.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void gotoTagPage(ActionEvent a)throws IOException{

        ListPageTabPane.getSelectionModel().select(ListPageTagTab);

    }





    public void ReadHtmlProjectFolder()throws URISyntaxException, IOException {

            // Get URL for the help file
            URL helpUrl = Main.class.getResource("help.html");
            // Open the help file in the default web browser
            Desktop.getDesktop().browse(helpUrl.toURI());

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        String createTableSQL = "CREATE TABLE IF NOT EXISTS CV (" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT," +
                "surname TEXT ,"+"jobTitle TEXT)";


        String url1 = "jdbc:sqlite:database.db";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url1);

             Statement stmt = conn.createStatement();
            stmt.executeUpdate(createTableSQL);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //creating the table for tags

        String tagTable = "CREATE TABLE IF NOT EXISTS tags ("
                + "cv_id INTEGER NOT NULL,"
                + "tag TEXT NOT NULL,"
                + "PRIMARY KEY (cv_id, tag),"
                + "FOREIGN KEY (cv_id) REFERENCES CV(id)"
                + ")";


        String url2 = "jdbc:sqlite:database.db";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url2);
             Statement stmt = conn.createStatement();
            stmt.executeUpdate(tagTable);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }



        //LIST TABLE VIEW

        String url3 = "jdbc:sqlite:database.db";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url3);

            Statement stmt = conn.createStatement();


            ResultSet rs = stmt.executeQuery("SELECT id,name,surname FROM CV");


            IDfirst.setCellValueFactory(new PropertyValueFactory<CV, Integer>("id"));
            IDsecond.setCellValueFactory(new PropertyValueFactory<CV, String>("name"));
            IDthird.setCellValueFactory(new PropertyValueFactory<CV, String>("surname"));


            List<CV> data= new ArrayList<>();

            while (rs.next()) {


                int value1 = rs.getInt("id");
                String value2 = rs.getString("name");
                String value3 = rs.getString("surname");


                data.add(new CV(value1,value2,value3));


            }
            ObservableList<CV> ListPageData = FXCollections.observableArrayList(data);

            listPageTableIDView.setItems(ListPageData);


            conn.close();
        } catch (SQLException | ClassNotFoundException a) {
            a.printStackTrace();
        }



        //edit first tab table view

        String url6 = "jdbc:sqlite:database.db";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url6);

            Statement stmt = conn.createStatement();


            ResultSet rs = stmt.executeQuery("SELECT id,name,surname FROM CV");


            editIDCol.setCellValueFactory(new PropertyValueFactory<CV, Integer>("id"));
            editNameCol.setCellValueFactory(new PropertyValueFactory<CV, String>("name"));
            editSurnameCol.setCellValueFactory(new PropertyValueFactory<CV, String>("surname"));


            List<CV> data2= new ArrayList<>();

            while (rs.next()) {


                int value1 = rs.getInt("id");
                String value2 = rs.getString("name");
                String value3 = rs.getString("surname");


                data2.add(new CV(value1,value2,value3));

            }
            ObservableList<CV> ListPageData = FXCollections.observableArrayList(data2);

            editPageTW.setItems(ListPageData);


            conn.close();
        } catch (SQLException | ClassNotFoundException a) {
            a.printStackTrace();
        }


        //delete page tableview

        String url7 = "jdbc:sqlite:database.db";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url7);
            Statement stmt = conn.createStatement();


            ResultSet rs = stmt.executeQuery("SELECT id,name,surname FROM CV");


            deleteIDCol.setCellValueFactory(new PropertyValueFactory<CV, Integer>("id"));
            deleteNameCol.setCellValueFactory(new PropertyValueFactory<CV, String>("name"));
            deleteSurnameCol.setCellValueFactory(new PropertyValueFactory<CV, String>("surname"));



            List<CV> data3= new ArrayList<>();

            while (rs.next()) {


                int value1 = rs.getInt("id");
                String value2 = rs.getString("name");
                String value3 = rs.getString("surname");


                data3.add(new CV(value1,value2,value3));


            }
            ObservableList<CV> ListPageData = FXCollections.observableArrayList(data3);

            deletePageTW.setItems(ListPageData);


            conn.close();
        } catch (SQLException | ClassNotFoundException a) {
            a.printStackTrace();
        }


        ObservableList<CV> search = FXCollections.observableArrayList();

        searchID.setCellValueFactory(new PropertyValueFactory<CV, Integer>("id"));
        atNameID.setCellValueFactory(new PropertyValueFactory<CV, String>("name"));
        atValID.setCellValueFactory(new PropertyValueFactory<CV, String>("surname"));

        searchTW.setItems(search);


        ObservableList<String> initialSearch = FXCollections.observableArrayList("TAGS");
        searchComboBox.setItems(initialSearch);


        String url4 = "jdbc:sqlite:database.db";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(url4);

            Statement stmt = connection.createStatement();


            String sql = "SELECT * FROM CV";

            ResultSet rs = stmt.executeQuery(sql);

            ResultSetMetaData metaData = rs.getMetaData();

            int numColumns = metaData.getColumnCount();


            List<String> allColumnNames2= new ArrayList<>();


                for (int i = 1; i <= numColumns; i++) {


                    String columnName = metaData.getColumnName(i);
                    allColumnNames2.add(columnName);

                }


            ObservableList<String> search2 = FXCollections.observableArrayList(allColumnNames2);

            searchComboBox.setItems(search2);


            rs.close();
            stmt.close();

            connection.close();
        }

        catch (SQLException | ClassNotFoundException m) {
            m.printStackTrace();
        }


        ObservableList<CV> tag = FXCollections.observableArrayList();

        tagID.setCellValueFactory(new PropertyValueFactory<CV, Integer>("id"));
        tagName.setCellValueFactory(new PropertyValueFactory<CV, String>("name"));
        tagSurname.setCellValueFactory(new PropertyValueFactory<CV, String>("surname"));

        tagTableView.setItems(tag);

        ObservableList<String> initialTag= FXCollections.observableArrayList("TAG");
        tagNamesComboBox.setItems(initialTag);


        String url5 = "jdbc:sqlite:database.db";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(url5);

            Statement stmt = connection.createStatement();

            String sql = "SELECT tag FROM tags";

            ResultSet rs = stmt.executeQuery(sql);

            List<String> tagValues = new ArrayList<>();

            {
                while (rs.next()) {

                    String columnValue = rs.getString("tag");
                    tagValues.add(columnValue);

                }
            }
            ObservableList<String> tag2 = FXCollections.observableArrayList(tagValues);

            tagNamesComboBox.setItems(tag2);


            rs.close();
            stmt.close();
            connection.close();

        }
        catch (SQLException | ClassNotFoundException m) {
            m.printStackTrace();
        }

    }

}