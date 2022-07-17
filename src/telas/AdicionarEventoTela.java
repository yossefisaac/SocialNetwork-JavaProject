package telas;

//import dataBase.GameEventsDAO;
import entidades.Eventos;
import entidades.User;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AdicionarEventoTela {
    private Stage stage;
    private Label lblAddEventos;
    private ImageView game;
    private User usuarioLogado;
    private TextField eventoNomeTxt;
    private TextField eventoDataTxt;
    private TextField eventoLocalTxt;
    private TextField eventoDescricaoTxt;
    private Button btnSalvar;
    private Button btnCancelar;
    private Pane pane;
    
    public AdicionarEventoTela(User usuarioLogado) {
	this.usuarioLogado = usuarioLogado;
    }
    
    public void start(Stage stage) throws Exception {
	this.stage = stage;

	iniciarComponentes();
	layoutConfiguracao();

	Scene scene = new Scene(pane);
	btnSalvar.requestFocus();

	stage.setScene(scene);
	stage.getIcons().add(new Image("/imagens/game.png"));
	stage.setTitle("Skynet");
	stage.setResizable(false);
	stage.show();
    }
    
    private void iniciarComponentes() {
	
	Image imagem = new Image("/imagens/game.png");
	game = new ImageView(imagem);
	
	lblAddEventos = new Label("NOVOS EVENTOS");
	lblAddEventos.setFont(new Font(40));
	lblAddEventos.styleProperty().set("-fx-text-fill: #778899");

	eventoNomeTxt = new TextField();
	eventoNomeTxt.setPromptText("EVENTO NOME");
	eventoNomeTxt.styleProperty().set(
		"-fx-text-fill: #778899; -fx-border-color: #4169E1; -fx-border-radius: 0; -fx-background-color: #F8F8FF;");

	eventoDataTxt = new TextField();
	eventoDataTxt.setPromptText("RESERVE A DATA");
	eventoDataTxt.styleProperty().set(
		"-fx-text-fill: #778899; -fx-border-color: #4169E1; -fx-border-radius: 0; -fx-background-color: #F8F8FF;");

	eventoLocalTxt = new TextField();
	eventoLocalTxt.setPromptText("EVENTO LOCAL");
	eventoLocalTxt.styleProperty().set(
		"-fx-text-fill: #778899; -fx-border-color: #4169E1; -fx-border-radius: 0; -fx-background-color: #F8F8FF;");

	eventoDescricaoTxt = new TextField();
	eventoDescricaoTxt.setPromptText("EVENTO DESCRIÇÃO");
	eventoDescricaoTxt.styleProperty().set(
		"-fx-text-fill: #778899; -fx-border-color: #4169E1; -fx-border-radius: 0; -fx-background-color: #F8F8FF;");

	btnSalvar = new Button("SALVAR");
	btnSalvar.setOnAction(salvar());
	btnSalvar.styleProperty().set(
		"-fx-text-fill: #FFFFFF; -fx-border-color: #4169E1; -fx-border-radius: 0; -fx-background-color: #4169E1;");

	btnCancelar = new Button("CANCELAR");
	btnCancelar.setOnAction(cancelar());
	btnCancelar.styleProperty().set(
		"-fx-text-fill: #FFFFFF; -fx-border-color: #4169E1; -fx-border-radius: 0; -fx-background-color: #4169E1;");

	pane = new AnchorPane();
	pane.styleProperty().set("-fx-background-color: #F2F8D2");

	pane.getChildren().addAll(lblAddEventos, game, eventoNomeTxt, eventoDataTxt, eventoLocalTxt, eventoDescricaoTxt, btnSalvar,
		btnCancelar);
    }

    private void layoutConfiguracao() {
	pane.setPrefSize(1000, 600);
	
	game.setLayoutX(450);
	
	lblAddEventos.setLayoutX(30);
	lblAddEventos.setLayoutY(30);

	eventoNomeTxt.setLayoutX(30);
	eventoNomeTxt.setLayoutY(160);
	eventoNomeTxt.setPrefHeight(40);
	eventoNomeTxt.setPrefWidth((pane.getPrefWidth() - 60)/2);

	eventoDataTxt.setLayoutX(30);
	eventoDataTxt.setLayoutY(220);
	eventoDataTxt.setPrefHeight(40);
	eventoDataTxt.setPrefWidth((pane.getPrefWidth() - 60)/2);

	eventoLocalTxt.setLayoutX(30);
	eventoLocalTxt.setLayoutY(280);
	eventoLocalTxt.setPrefHeight(40);
	eventoLocalTxt.setPrefWidth((pane.getPrefWidth() - 60) / 2);

	eventoDescricaoTxt.setLayoutX(30);
	eventoDescricaoTxt.setLayoutY(340);
	eventoDescricaoTxt.setPrefHeight(40);
	eventoDescricaoTxt.setPrefWidth((pane.getPrefWidth() - 60) / 2);

	btnSalvar.setLayoutX(30);
	btnSalvar.setLayoutY(460);
	btnSalvar.setPrefHeight(40);
	btnSalvar.setPrefWidth((pane.getPrefWidth() - 20) / 4);

	btnCancelar.setLayoutX(30);
	btnCancelar.setLayoutY(520);
	btnCancelar.setPrefHeight(40);
	btnCancelar.setPrefWidth((pane.getPrefWidth() - 20) / 4);

    }

    private EventHandler<ActionEvent> salvar() {
	return new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		try {
		    
		    
		    if (eventoNomeTxt.getText().isEmpty()) {
			AlertaTela.alert("EVENTO SEM NOME?");
			return;
		    }
		    if (eventoDataTxt.getText().isEmpty()) {
			AlertaTela.alert("EVENTO SEM NOME?");
			return;
		    }
		    if (eventoLocalTxt.getText().isEmpty()) {
			AlertaTela.alert("EVENTO SEM LOCAL?");
			return;
		    }
		    if (eventoDescricaoTxt.getText().isEmpty()) {
			AlertaTela.alert("EVENTO SEM DESCRIÇÃO?");
			return;
		    } 
		    
		    System.out.println(usuarioLogado.getId());

		    //new GameEventsDAO().add(new GameEvents(loggedUser , eventNameTxt.getText(), eventDateTxt.getText(),
			    //eventLocalTxt.getText(), eventDescriptionTxt.getText(), gameNameTxt.getText()));

		    abrirTelaDosEventos();
		} catch (Exception e) {
		    AlertaTela.error("ERRO AO TENTAR SALVAR ESSE NOVO EVENTO");
		}
	    }
	};
    }

    private void abrirTelaDosEventos() {
	try {
	    new EventosTela(usuarioLogado).start(stage);
	} catch (Exception e) {
	    AlertaTela.error("ERRO AO TENTAR ABRIR A TELA DE EVENTOS");
	}
    }

    private EventHandler<ActionEvent> cancelar() {
	return new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		try {
		    //new GameEvents_FX(loggedUser).start(stage);
		} catch (Exception e) {
		    AlertaTela.error("ERRO AO TENTAR CANCELAR");
		}
	    }
	};
    }
}