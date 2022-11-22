package controllers;

import entities.Carta;
import entities.DBconnection;
import entities.Envio;
import entities.Planificacion;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class InterfaceController implements Initializable{


    private Connection  con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

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
    @FXML
    private TextField busqCarta;
    @FXML
    private TextField idCartaBusq;
    @FXML
    private TextField direccionCartaBusq;
    @FXML
    private TextField serviceCartaBusq;
    @FXML
    private TextField dispoCartaBusq;
    @FXML
    private Label errorInfoCarta;
    @FXML
    private TextArea cartasPlanificadas;
    @FXML
    private AnchorPane infoCarta;
    @FXML
    private AnchorPane infoEstado;
    @FXML
    private TextField estadoCarta;
    @FXML
    private DatePicker planDate;
    @FXML
    private ListView  cartasView = new ListView();
    @FXML
    private Pane listaPane;
    @FXML
    private ListView rutaView = new ListView();
    @FXML
    private TextField idEntrega;
    @FXML
    private TextField idUsuario;

    Planificacion plan = new Planificacion();
    int cont=0;


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

    public void switchtoPlannerMenu(javafx.event.ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../resources/PlaniMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchtoPlannerPlanning(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/PlannerPlanning.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchtoJaimitoMenu(javafx.event.ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../resources/JaimitoMenu.fxml"));
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection con = DBconnection.getCon();
    }

    public void busquedaInv(javafx.event.ActionEvent event){

        Connection con = DBconnection.getCon();
        boolean existe=false;

        try {
            pst = con.prepareStatement("SELECT * FROM bartleby.carta");
            rs = pst.executeQuery();
            while(rs.next()){

                if(rs.getString(1).equalsIgnoreCase(busqCarta.getText())){
                    existe = true;
                    llenarinfoCarta(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3), LocalDate.parse(rs.getString(5)));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(!existe){
            infoCarta.setVisible(false);
            errorInfoCarta.setVisible(true);
        }


    }

    public void llenarinfoCarta(int id, String dir, String service, LocalDate dispo){

        idCartaBusq.setText(Integer.toString(id));
        direccionCartaBusq.setText(dir);
        serviceCartaBusq.setText(service);
        dispoCartaBusq.setText(String.valueOf(dispo));

        infoCarta.setVisible(true);

    }

    public void fechaPlaneacion(javafx.event.ActionEvent event){

        LocalDate fecha = planDate.getValue();
        Connection con = DBconnection.getCon();
        cartasView.getItems().clear();

        try {
            pst = con.prepareStatement("SELECT * FROM bartleby.carta");
            rs = pst.executeQuery();
            while(rs.next()){

                System.out.println(fecha);
                System.out.println(rs.getString(5));
                if(fecha.equals(LocalDate.parse(rs.getString(5)))){

                    Carta carta = new Carta(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),Integer.parseInt(rs.getString(4)),LocalDate.parse(rs.getString(5)));
                    cartasView.getItems().add(rs.getString(2));
                    cont++;

                    plan.agregarAPlan(carta);

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void planificarRuta(javafx.event.ActionEvent event){

        String ruta = cartasPlanificadas.getText();

        plan.OrganizarCartas(ruta);

    }

    public void mostrarDirdeRuta(javafx.event.ActionEvent event){

        rutaView.getItems().clear();

        Envio ev = Envio.getInstance();

        for(int i=0; i < ev.getCartasEnvio().size(); i++){
            rutaView.getItems().add(ev.getCartasEnvio().get(i).getDireccionEntrega());
        }

    }

    public void entregarCarta(javafx.event.ActionEvent event){

        Envio env = Envio.getInstance();
        boolean existe =false;

        for(int i=0; i < env.getCartasEnvio().size();i++){

            if(env.getCartasEnvio().get(i).getIdentificador() == Integer.parseInt(idEntrega.getText())){
                rutaView.getItems().remove(i);
                existe = true;
            }
        }



    }

    public void consultarIdentificadorUser(javafx.event.ActionEvent event){

        Connection con = DBconnection.getCon();
        try {
            pst = con.prepareStatement("SELECT * FROM bartleby.carta");
            rs = pst.executeQuery();
            while(rs.next()){

                if(Integer.parseInt(rs.getString(4)) == Integer.parseInt(idUsuario.getText())){
                    infoEstado.setVisible(true);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }




}
