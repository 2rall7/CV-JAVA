import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controllerfordelete {
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


    public void switchToDeleteCVPage(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("delete.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void deleteCV(ActionEvent b) throws IOException{
        PreparedStatement preparedStatement = null;

        String jdbcUrl = "jdbc:sqlite://C:\\Users\\BLG\\2812ProjeMertDb\\src\\db1.db ";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl);
            // 2. Create a prepared statement
            String deleteSQL = "DELETE FROM CV WHERE id = " + deleteCVTextField.getText();
            preparedStatement = connection.prepareStatement(deleteSQL);

            // 4. Execute the delete statement
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // Handle any errors
            e.printStackTrace();
        }
        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage) ((Node) b.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void deletesmthingCv(ActionEvent b) throws IOException{
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        String jdbcUrl = "jdbc:sqlite://C:\\Users\\BLG\\2812ProjeMertDb\\src\\db1.db ";
        try {
            // 1. Connect to the database
            connection = DriverManager.getConnection(jdbcUrl);

            // 2. Create a prepared statement
            String deleteSQL = "UPDATE CV SET " + columnNameTextField2.getText() + " = ? WHERE id = " + idTextField.getText();

            preparedStatement = connection.prepareStatement(deleteSQL);

            // 3. Set the value for the prepared statement
            preparedStatement.setString(1, null);

            // 4. Execute the delete statement
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // Handle any errors
            e.printStackTrace();

        }
        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage) ((Node) b.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

            Connection conn = DriverManager.getConnection(jdbcUrl);

// Create a statement
            Statement stmt = conn.createStatement();

// Execute a SELECT query to retrieve data from the database

            ResultSet rs = stmt.executeQuery("SELECT id,name,surname FROM CV");


            deleteIDCol.setCellValueFactory(new PropertyValueFactory<CV, Integer>("id"));
            deleteNameCol.setCellValueFactory(new PropertyValueFactory<CV, String>("name"));
            deleteSurnameCol.setCellValueFactory(new PropertyValueFactory<CV, String>("surname"));

            // ListPageData = FXCollections.observableArrayList(new CV(1,"value2","value3"));


            List<CV> data3 = new ArrayList<>();

            while (rs.next()) {


                // Retrieve the value from the specific column you want to add


                int value1 = rs.getInt("id");
                String value2 = rs.getString("name");
                String value3 = rs.getString("surname");


                data3.add(new CV(value1, value2, value3));


                // Add the row to the ObservableList

                //   ListPageData = FXCollections.observableArrayList(new CV(value1,value2,value3));

            }
            ObservableList<CV> ListPageData = FXCollections.observableArrayList(data3);

            deletePageTW.setItems(ListPageData);
        }
    }
   //// List method

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


    @FXML
    private TabPane ListPageTabPane;

    @FXML
    private Tab ListPageTab1;

    @FXML
    private Tab ListPageTab2;

    public void switchToListCVPage(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("list.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void goToListPageTab2() {

        String jdbcUrl = "jdbc:sqlite://C:\\Users\\BLG\\2812ProjeMertDb\\src\\db1.db ";

        try{

            ObservableList<CV> data3 = FXCollections.observableArrayList();

// Connect to the database
            Connection connection = DriverManager.getConnection(jdbcUrl);

// Create a statement
            Statement stmt = connection.createStatement();

// Execute the SELECT query



            String sql = "SELECT * FROM CV";

            ResultSet rs = stmt.executeQuery(sql);

// Get the ResultSetMetaData object for the ResultSet
            ResultSetMetaData metaData = rs.getMetaData();

// Get the number of columns in the ResultSet
            int numColumns = metaData.getColumnCount();

// Create a list to hold the TableColumn objects for the TableView


// Iterate over the columns and create a TableColumn for each column

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

                    // System.out.println("columname1");
                    //System.out.println(columnName);


                    String columnValue = rs2.getString(i);
                    columnValues.add(columnValue);


                    CV temp2 = new CV(columnName, columnValue);

                    ListPageSpecificTableview.getItems().add(temp2);


// Close the result set, statement, and connection
            rs.close();
            stmt.close();
            connection.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }


        ListPageTabPane.getSelectionModel().select(ListPageTab2);


    }
    public void goToListPageTab1(){
        ListPageTabPane.getSelectionModel().select(ListPageTab1);

    }
