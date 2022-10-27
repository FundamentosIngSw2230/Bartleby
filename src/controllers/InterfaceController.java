package controllers;

import entities.Carta;
import entities.DBconnection;
import entities.Planificacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;

public class InterfaceController {

    int cont=106;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField direccion;
    @FXML
    private TextField idusuario;
    @FXML
    private TextField service;
    @FXML
    private TextField dispo;


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

    public void AgregarCarta(javafx.event.ActionEvent event) throws IOException{

        Carta carta = new Carta();

        carta.setIdentificador(cont);
        carta.setDireccionEntrega(direccion.getText());
        carta.setTipoServicio(service.getText());
        carta.setOwner(Integer.parseInt(idusuario.getText()));
        carta.setDisponibilidadEntrega(Integer.parseInt(dispo.getText()));

        Planificacion plan = new Planificacion();

        plan.agregarCarta(carta);
        cont++;

    }

}
