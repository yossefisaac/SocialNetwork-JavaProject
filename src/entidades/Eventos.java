package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Eventos {

    private User usuario;
    private Integer eventoId;
    private String eventoNome;
    private String eventoData;
    private String eventoLocal;
    private String eventoDescricao;

    LocalDateTime agora = LocalDateTime.now();

    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String date = formatterData.format(agora);

    DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    String time = formatterHora.format(agora);

    public Eventos(User usuario, Integer eventoId, String eventoNome, String eventoData, String eventoLocal,
	    String eventoDescricao) {
	super();
	this.usuario = usuario;
	this.eventoId = eventoId;
	this.eventoNome = eventoNome;
	this.eventoData = eventoData;
	this.eventoLocal = eventoLocal;
	this.eventoDescricao = eventoDescricao;
    }

    public Eventos(User usuario, String eventoNome, String eventoData, String eventoLocal, String eventoDescricao) {
	super();
	this.usuario = usuario;
	this.eventoNome = eventoNome;
	this.eventoData = eventoData;
	this.eventoLocal = eventoLocal;
	this.eventoDescricao = eventoDescricao;
    }

    public Eventos(User usuario, Integer eventoId, String eventoNome, String eventoDescricao) {
	super();
	this.usuario = usuario;
	this.eventoId = eventoId;
	this.eventoNome = eventoNome;
	this.eventoDescricao = eventoDescricao;
    }

    public Eventos(String eventoNome) {
	this.eventoNome = eventoNome;
    }

    public Eventos(Integer eventoId, String eventoNome) {
	this.eventoId = eventoId;
	this.eventoNome = eventoNome;
    }

    public Eventos(String eventoNome, String eventoData, String eventoLocal, String eventoDescricao) {
	super();
	this.eventoNome = eventoNome;
	this.eventoData = eventoData;
	this.eventoLocal = eventoLocal;
	this.eventoDescricao = eventoDescricao;
    }

    public Eventos(Integer eventoId, String eventoNome, String eventoData, String eventoLocal, String eventoDescricao) {
	super();
	this.eventoId = eventoId;
	this.eventoNome = eventoNome;
	this.eventoData = eventoData;
	this.eventoLocal = eventoLocal;
	this.eventoDescricao = eventoDescricao;
    }

    public User getUsuario() {
	return usuario;
    }

	public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}

	public String getEventoNome() {
		return eventoNome;
	}

	public void setEventoNome(String eventoNome) {
		this.eventoNome = eventoNome;
	}

	public String getEventoData() {
		return eventoData;
	}

	public void setEventoData(String eventoData) {
		this.eventoData = eventoData;
	}

	public String getEventoLocal() {
		return eventoLocal;
	}

	public void setEventoLocal(String eventoLocal) {
		this.eventoLocal = eventoLocal;
	}

	public String getEventoDescricao() {
		return eventoDescricao;
	}

	public void setEventoDescricao(String eventoDescricao) {
		this.eventoDescricao = eventoDescricao;
	}
}