@FXML protected void handleSubmitButtonAction(ActionEvent event) {  try {  Parent root = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml")); Stage stage = new Stage(); Scene scene = new Scene(root, 400, 240); stage.setScene(scene); stage.show();  } catch (IOException e) { e.printStackTrace(); }       }