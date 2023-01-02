



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

    public void switchToEditCVPage(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("edit.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void goToEditTab2() {

        String jdbcUrl ="jdbc:sqlite:/C:\\Users\\gokce\\IdeaProjects\\gokceson\\src\\\\cvGUITry.db";

        try{

            ObservableList<CV> data3 = FXCollections.observableArrayList();

            Connection connection = DriverManager.getConnection(jdbcUrl);


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

        catch (SQLException e) {
            e.printStackTrace();
        }



        tabPane.getSelectionModel().select(tab2);

    }





}
    public void goToEditTab1(){
        tabPane.getSelectionModel().select(tab1);

    }
    public void renameMethod (ActionEvent b) throws IOException{
        PreparedStatement preparedStatement= null;


        String jdbcUrl = "jdbc:sqlite:/C:\\Users\\gokce\\IdeaProjects\\gokceson\\src\\\\cvGUITry.db";

        try {

            Connection connection = DriverManager.getConnection(jdbcUrl);
            String updateSQL = "UPDATE CV SET " + columnNameTextField.getText() + " = ? WHERE id = "+idTextField.getText();
            preparedStatement = connection.prepareStatement(updateSQL);


            preparedStatement.setString(1, columnNameTextField1.getText());

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
    public void editPageAddNewInfo(ActionEvent b) throws IOException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        String jdbcUrl = "jdbc:sqlite:/C:\\Users\\gokce\\IdeaProjects\\gokceson\\src\\\\cvGUITry.db";
        try {
            String columnName = columnNameTextField12.getText();
            String tableName = "CV";


            connection = DriverManager.getConnection(jdbcUrl);

            PreparedStatement stmt = connection.prepareStatement("SELECT 1 FROM sqlite_master WHERE type='table' AND name=? AND sql LIKE ?");
            stmt.setString(1, tableName);
            stmt.setString(2, "%" + columnName + "%");
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {  // column does not exist
                stmt = connection.prepareStatement("ALTER TABLE " + tableName + " ADD " + columnName);
                stmt.executeUpdate();
            }


            String updateSQL = "UPDATE CV SET " + columnNameTextField12.getText() + " = ? WHERE id = " + idTextField.getText();
            preparedStatement  = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, columnNameTextField11.getText());
            preparedStatement.executeUpdate();

            s
            rs.close();
            stmt.close();
            preparedStatement.close();
            connection.close();

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
        String jdbcUrl = "jdbc:sqlite:/C:\\Users\\gokce\\IdeaProjects\\gokceson\\src\\\\cvGUITry.db";
        try {

            connection = DriverManager.getConnection(jdbcUrl);


            String deleteSQL = "UPDATE CV SET " + columnNameTextField2.getText() + " = ? WHERE id = " + idTextField.getText();

            preparedStatement = connection.prepareStatement(deleteSQL);


            preparedStatement.setString(1, null);

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

}



