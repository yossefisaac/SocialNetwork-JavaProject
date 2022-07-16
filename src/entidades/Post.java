package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {

    private Integer idPost;
    private User usuario;
    private String conteudo;

    LocalDateTime agora = LocalDateTime.now();

    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String date = formatterData.format(agora);

    DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    String time = formatterHora.format(agora);

    public Post() {
	super();
    }

    public Post(User usuario, Integer idPost, String conteudo) {
	super();
	this.usuario = usuario;
	this.idPost = idPost;
	this.conteudo = conteudo;
    }

    public Post(Integer idPost) {
	super();
	this.idPost = idPost;
    }

    public Post(Integer idPost, User usuario, String conteudo) {
	super();
	this.idPost = idPost;
	this.usuario = usuario;
	this.conteudo = conteudo;
    }

    public Post(Integer idPost, String conteudo) {
	super();
	this.idPost = idPost;
	this.conteudo = conteudo;
    }

    public Post(String conteudo) {
	super();
	this.conteudo = conteudo;
    }

    public Post(User usuario, String conteudo) {
	this.usuario = usuario;
	this.conteudo = conteudo;
    }

    public User getUsuario() {
	return usuario;
    }

    public Integer getIdPost() {
	return idPost;
    }

    public void setIdPost(Integer idPost) {
	this.idPost = idPost;
    }

    public String getConteudo() {
	return conteudo;
    }

    public void setConteudo(String conteudo) {
	this.conteudo = conteudo;
    }
}