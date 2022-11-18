package controllers;

import entities.Carta;
import entities.DBconnection;
import entities.Planificacion;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class InterfaceController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField direccion;
    @FXML
    private TextField idusuario;
    @FXML
    private DatePicker dispo;
    @FXML
    private TextField tipoServicio;

    public  void switchtoMenu(javafx.event.ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../resources/Menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

            DBconnection connect = new DBconnection();
            connect.InitialReading();

    }
    public  void switchtoMenu2(javafx.event.ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../resources/Menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public  void switchtoAgentMenu(javafx.event.ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../resources/AgentMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public  void switchtoAgent(javafx.event.ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../resources/Agent.fxml"));
        /*
        ObservableList<String> list = cbServicio.getItems();
        String a ="normal";
        String b = "express";
        System.out.println(list.size());
        list.addAll(a,b);
        System.out.println(list.size());
         */
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public  void switchtoAgentInventario(javafx.event.ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../resources/AgentInventario.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void AgregarCarta(javafx.event.ActionEvent event) throws IOException, ParseException {

        int idanterior =0;

        Carta carta = new Carta();
        Planificacion plan = new Planificacion();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        idanterior = plan.findId();
        carta.setIdentificador(idanterior+1);
        carta.setDireccionEntrega(direccion.getText());
        carta.setTipoServicio(tipoServicio.getText());
        carta.setOwner(Integer.parseInt(idusuario.getText()));
        LocalDate fecha = dispo.getValue();
        carta.setDisponibilidadEntrega(LocalDate.parse(fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));



        plan.agregarCarta(carta);

    }
}
