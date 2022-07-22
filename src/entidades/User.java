package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class User {

    private Integer id;
    private String NomeUsuario;
    private String senha;
    private String nome;
    private String dataNascimento;
    private String estadoCivil;

    private List<Post> posts;
    private List<Follow> followers;
    private List<Eventos> eventos;

    LocalDateTime agora = LocalDateTime.now();

    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String date = formatterData.format(agora);

    DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    String time = formatterHora.format(agora);

    public User() {
    super();
    }

    public User(Integer id, String NomeUsuario, String senha, String nome, String dataNascimento, String estadoCivil) {
    super();
    this.id = id;
    this.NomeUsuario = NomeUsuario;
    this.senha = senha;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.estadoCivil = estadoCivil;
    this.posts = new ArrayList<>();
    this.followers = new ArrayList<>();
    this.eventos = new ArrayList<>();
    }
    
    public User(Integer id, String NomeUsuario, String nome, String dataNascimento, String estadoCivil) {
    super();
    this.id = id;
    this.NomeUsuario = NomeUsuario;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.estadoCivil = estadoCivil;
    this.posts = new ArrayList<>();
    this.followers = new ArrayList<>();
    this.eventos = new ArrayList<>();
    }
    
    public User(String NomeUsuario, String senha, String nome, String dataNascimento, String estadoCivil) {
    super();
    this.NomeUsuario = NomeUsuario;
    this.senha = senha;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.estadoCivil = estadoCivil;
    
    this.posts = new ArrayList<>();
    this.followers = new ArrayList<>();
    this.eventos = new ArrayList<>();
    }

    public User(String NomeUsuario, String dataNascimento, String estadoCivil) {
    this.NomeUsuario = NomeUsuario;
    this.dataNascimento = dataNascimento;
    this.estadoCivil = estadoCivil;
    this.posts = new ArrayList<>();
    this.followers = new ArrayList<>();
    this.eventos = new ArrayList<>();
    }
    
    public User(String NomeUsuario
) {
    this.NomeUsuario = NomeUsuario;
    }
    
    public User(Integer id, String NomeUsuario
) {
    super();
    this.id = id;
    this.NomeUsuario = NomeUsuario;
    }

    public User(String NomeUsuario, String senha) {
    super();
    this.NomeUsuario = NomeUsuario;
    this.senha = senha;
    }
    
    public User(Integer id, String NomeUsuario, String senha) {
    super();
    this.id = id;
    this.NomeUsuario = NomeUsuario;
    this.senha = senha;
    }

    public Integer getId() {
    return id;
    }

    public void setId(Integer id) {
    this.id = id;
    }

    public String getNomeUsuario() {
    return NomeUsuario;
    }

    public void setNomeUsuario(String NomeUsuario) {
    this.NomeUsuario = NomeUsuario;
    }

    public String getSenha() {
    return senha;
    }

    public void setSenha(String senha) {
    this.senha = senha;
    }

    public String getNome() {
    return nome;
    }

    public void setNome(String nome) {
    this.nome = nome;
    }

    public String getDataNascimento() {
    return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
    }

    public String getEstadoCivil() {
    return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
    this.estadoCivil = estadoCivil;
    }

    public List<Post> getPosts() {
    return posts;
    }

    public List<Follow> getFollowers() {
    return followers;
    }

    public List<Eventos> getEventos() {
    return eventos;
    }

    

    // POSTS

    public void MostrarPosts() {
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("                                                                  {TIMELINE}");
    for (int i = 0; i < posts.size(); i++) {
        System.out.println();
        System.out.println("Post #" + posts.get(i).getIdPost() + " por " + nome + " em " + date + " as " + time);
        System.out.println("        " + posts.get(i).getConteudo());

    }
    }

    public void MostrarSeusPosts() {
    for (int i = 0; i < posts.size(); i++) {
        System.out.println();
        System.out.println("Post #" + posts.get(i).getIdPost() + " por " + nome + " em " + date + " as " + time);
        System.out.println("        " + posts.get(i).getConteudo());
        System.out.println();
    }
    }

    public void CadastrarPost(User user, Integer idPost, String content) {
    posts.add(new Post(user, idPost, content));
    }

    public void EditarPost(Integer idPost, String content) {
    for (int i = 0; i < posts.size(); i++) {
        if (posts.get(i).getIdPost() == idPost) {
        posts.get(i).setConteudo(content);
        }
    }
    }

    public void ExcluirPost(Integer idPost) {
    for (int i = 0; i < posts.size(); i++) {
        if (posts.get(i).getIdPost() == idPost) {
        posts.remove(i);
        }
    }
    System.out.println("{POST APAGADO}");
    }


 // EVENTOS

    public void mostrarEventos() {
	for (int i = 0; i < eventos.size(); i++) {
	    System.out.println();
	    System.out.println("Evento #" + eventos.get(i).getEventoId() + " " + " por " + nome + ", criado em " + date
		    + " as " + time);
	    System.out.println("Título: " + eventos.get(i).getEventoNome());
	    System.out.println("Reserve a data: " + eventos.get(i).getEventoData() + ", em/na: " + eventos.get(i).getEventoLocal());
	    System.out.println("Infos: " + eventos.get(i).getEventoDescricao());
	}
    }

    public void mostrarSeusEventos() {
	for (int i = 0; i < eventos.size(); i++) {
	    System.out.println();
	    System.out.println("Evento #" + eventos.get(i).getEventoId() + " " + " por " + nome + " criado em " + date
		    + " as " + time);
	    System.out.println("We presents to you " + eventos.get(i).getEventoNome());
	    System.out.println("Reserve a data: " + eventos.get(i).getEventoData() + ", em/na: " + eventos.get(i).getEventoLocal());
	    System.out.println("InfoS: " + eventos.get(i).getEventoDescricao());
	    System.out.println();
	}
    }

    public void adicionarEvento(User usuario, Integer eventoId, String eventoNome, String eventoData, String eventoLocal,
	    String eventoDescricao) {
	eventos.add(new Eventos(usuario, eventoId, eventoNome, eventoData, eventoLocal, eventoDescricao));
    }

    public void editarEventoNome(Integer eventoId, String eventoNome) {
	for (int i = 0; i < eventos.size(); i++) {
	    if (eventos.get(i).getEventoId() == eventoId) {
		eventos.get(i).setEventoNome(eventoNome);
	    }
	}
    }

    public void editarEventoData(Integer eventoId, String eventoData) {
	for (int i = 0; i < eventos.size(); i++) {
	    if (eventos.get(i).getEventoId() == eventoId) {
		eventos.get(i).setEventoData(eventoData);
	    }
	}
    }

    public void editarEventoLocal(Integer eventoId, String eventoLocal) {
	for (int i = 0; i < eventos.size(); i++) {
	    if (eventos.get(i).getEventoId() == eventoId) {
		eventos.get(i).setEventoLocal(eventoLocal);
	    }
	}
    }

    public void editarEventoDescricao(Integer eventoId, String eventoDescricao) {
	for (int i = 0; i < eventos.size(); i++) {
	    if (eventos.get(i).getEventoId() == eventoId) {
		eventos.get(i).setEventoDescricao(eventoDescricao);
	    }
	}
    }

    public void removerEvento(Integer eventoId) {
	for (int i = 0; i < eventos.size(); i++) {
	    if (eventos.get(i).getEventoId() == eventoId) {
		eventos.remove(i);
	    }
	}
    System.out.println("{EVENTO APAGADO}");
    }
}