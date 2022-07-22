package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bancoDeDados.EventosDAO;
import bancoDeDados.FollowDAO;
import bancoDeDados.PostDAO;
import bancoDeDados.UserDAO;
import bancoDeDados.UtilBD;
import entidades.Eventos;
import entidades.Follow;
import entidades.Post;
import entidades.User;


public class Main2 {

    public static void main(String[] args) {

	UtilBD.initBD();

	UtilBD.closeConection();
  
  	List<User> users = new ArrayList<>();
  
  	EventosDAO eventosDAO = new EventosDAO();
  	FollowDAO followDAO = new FollowDAO();
  	PostDAO postDAO = new PostDAO();
  	UserDAO userDAO = new UserDAO();
  
  	int i = 0, choose = 0, tempChoose = 0;
  	User loggedUser = null;
  
  	Scanner sc = new Scanner(System.in);
  
  	while (true) {
		System.out.println();
  	    System.out.println("██████╗░███████╗██████╗░███████╗  ░██████╗░█████╗░░█████╗░██╗░█████╗░██╗░░░░░");
  	    System.out.println("██╔══██╗██╔════╝██╔══██╗██╔════╝  ██╔════╝██╔══██╗██╔══██╗██║██╔══██╗██║░░░░░");
  	    System.out.println("██████╔╝█████╗░░██║░░██║█████╗░░  ╚█████╗░██║░░██║██║░░╚═╝██║███████║██║░░░░░");
  	    System.out.println("██╔══██╗██╔══╝░░██║░░██║██╔══╝░░  ░╚═══██╗██║░░██║██║░░██╗██║██╔══██║██║░░░░░");
		System.out.println("██║░░██║███████╗██████╔╝███████╗  ██████╔╝╚█████╔╝╚█████╔╝██║██║░░██║███████╗");
		System.out.println("╚═╝░░╚═╝╚══════╝╚═════╝░╚══════╝  ╚═════╝░░╚════╝░░╚════╝░╚═╝╚═╝░░╚═╝╚══════");
  	    System.out.println("                   {SKT(/) - CONECTANDO PESSOAS..}");
  	    System.out.println();
  	    do {
  		System.out.println("{1} NOVA CONTA ~ {2} LOGIN");
  		System.out.print(":~$ ");
  		choose = sc.nextInt();
  		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  		switch (choose) {
  		case 1:
  		    sc.nextLine();
  		    System.out.print("USUARIO:~$ ");
  		    String username = sc.nextLine();
  		    System.out.print("SENHA:~$ ");
  		    String password = sc.nextLine();
  		    System.out.print("NOME COMPLETO:~$ ");
  		    String name = sc.nextLine();
  		    System.out.print("DATA DE NASCIMENTO (dd/MM/AAAA):~$ ");
  		    String birthdate = sc.nextLine();
  		    System.out.print("RELACIONAMENTO:~$ ");
  		    String relationship = sc.nextLine();
  		    System.out.println();
  		    User newUser = new User(username, password, name, birthdate, relationship);
  		    userDAO.add(newUser);
  		    break;
  		case 2:
  		    sc.nextLine();
  		    do {
  			System.out.print("USUARIO:~$ ");
  			String usernameCheck = sc.nextLine();
  			System.out.print("SENHA:~$ ");
  			String passwordCheck = sc.nextLine();
  			System.out.println();
  			List<User> userList = userDAO.all();
  
  			for (i = 0; i < userList.size(); i++) {
  			    if (userList.get(i).getNomeUsuario().contentEquals(usernameCheck)
  				    && userList.get(i).getSenha().contentEquals(passwordCheck)) {
  				loggedUser = userList.get(i);
  				break;
  			    }
  			}
  		    } while (loggedUser == null);
  		}
  	    } while (loggedUser == null);
  
  	    do {
  		System.out.println();
  	    System.out.println("██████╗░███████╗██████╗░███████╗  ░██████╗░█████╗░░█████╗░██╗░█████╗░██╗░░░░░");
  	    System.out.println("██╔══██╗██╔════╝██╔══██╗██╔════╝  ██╔════╝██╔══██╗██╔══██╗██║██╔══██╗██║░░░░░");
  	    System.out.println("██████╔╝█████╗░░██║░░██║█████╗░░  ╚█████╗░██║░░██║██║░░╚═╝██║███████║██║░░░░░");
  	    System.out.println("██╔══██╗██╔══╝░░██║░░██║██╔══╝░░  ░╚═══██╗██║░░██║██║░░██╗██║██╔══██║██║░░░░░");
		System.out.println("██║░░██║███████╗██████╔╝███████╗  ██████╔╝╚█████╔╝╚█████╔╝██║██║░░██║███████╗");
		System.out.println("╚═╝░░╚═╝╚══════╝╚═════╝░╚══════╝  ╚═════╝░░╚════╝░░╚════╝░╚═╝╚═╝░░╚═╝╚══════");
  	    System.out.println("                   {SKT(/) - CONNECTING PEOPLE..}");
  	    System.out.println();
  		System.out.println("                    {LOGADO COMO " + loggedUser.getNomeUsuario() + "}");
  		System.out.println();
  		System.out.println();
  		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  		System.out.println();
  		System.out.println();
  		System.out.println("{ " + loggedUser.getNomeUsuario() + "'s POSTS }");
  		List<Post> showPosts = userDAO.getPost(loggedUser);
  		for (i = 0; i < showPosts.size(); i++) {
  		    System.out.println("# " + showPosts.get(i).getIdPost() + " - " + showPosts.get(i).getConteudo());
  		}
  		System.out.println();
  		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  		System.out.println("{1} CONFIGURAÇÕES DE USUARIO");
  		System.out.println("{2} POSTS");
  		System.out.println("{3} AMIGOS");
  		System.out.println("{4} EVENTOS");
  		System.out.println("{5} SAIR");
  		System.out.print(":~$ ");
  		choose = sc.nextInt();
  		System.out.println();
  		if (choose == 1) {
  		    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  		    System.out.println("{INFORMAÇÕES DE USUARIO}");
  		    System.out.println();
  		    sc.nextLine();
  		    System.out.print("USUARIO:~$ ");
  		    loggedUser.setNomeUsuario(sc.nextLine());
  		    System.out.print("SENHA:~$ ");
  		    loggedUser.setSenha(sc.nextLine());
  		    System.out.print("NOME COMPLETO:~$ ");
  		    loggedUser.setNome(sc.nextLine());
  		    System.out.print("DATA DE NASCIMENTO (dd/MM/aaaa):~$ ");
  		    loggedUser.setDataNascimento(sc.nextLine());
  		    System.out.print("RELACIONAMENTO:~$ ");
  		    loggedUser.setEstadoCivil(sc.nextLine());
  		    System.out.println();
  		    userDAO.update(loggedUser);
  		}
  		if (choose == 2) {
  		    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  		    System.out.println("{POSTS}");
  		    System.out.println();
  		    System.out.println("{1} O QUE DESEJA PUBLICAR?");
  		    System.out.println("{2} LISTAR SEUS POSTS");
  		    System.out.println("{3} LISTAR TODOS OS POSTS");
  		    System.out.println("{4} TELA DE MENU");
  		    System.out.print(":~$ ");
  		    System.out.println();
  		    tempChoose = sc.nextInt();
  		    System.out.println();
  		    switch (tempChoose) {
  		    case 1:
  			sc.nextLine();
  			System.out.print("O QUE DESEJA PUBLICAR?:~$ ");
  			String content = sc.nextLine();
  			Post newPost = new Post(loggedUser, content);
  			postDAO.add(newPost);
  			break;
  		    case 2:
  			if (userDAO.getPost(loggedUser).isEmpty()){
				System.out.println("{VOCÊ AINDA NÃO FEZ NENHUM POST!}");
  			} else {
  			    List<Post> postList = userDAO.getPost(loggedUser);
  			    for (i = 0; i < postList.size(); i++) {
  				System.out.println("#" + (i + 1) + " - " + postList.get(i).getConteudo());
  				System.out.println();
  			    }
  			    do {
  				System.out.println();
  				System.out.println("{1} EDITAR POST ~ {2} REMOVER POST ~ {3} TELA DE MENU");
  				tempChoose = sc.nextInt();
  				System.out.println();
  				switch (tempChoose) {
  				case 1:
  				    sc.nextLine();
  				    System.out.println(
  					    "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  				    System.out.print("DIGITE O NUMERO DO POST QUE VOCÊ QUER EDITAR:~$ ");
  				    Integer postNum = sc.nextInt();
  				    postNum--;
  				    System.out.println();
  				    sc.nextLine();
  				    System.out.print("ESCREVA O NOVO CONTEUDO:~$ ");
  				    postList.get(postNum).setConteudo(sc.nextLine());
  				    postDAO.update(postList.get(postNum));
  				    break;
  				case 2:
  				    sc.nextLine();
  				    System.out.print("DIGITE O NUMERO DO POST QUE VOCÊ QUER REMOVER:~$ ");
  				    Integer postNumRemove = sc.nextInt();
  				    sc.nextLine();
  				    postNumRemove--;
  				    postDAO.remove(postList.get(postNumRemove));
					System.out.println("{ POST DELETADO }");
  				    break;
  				case 3:
  				    break;
  				}
  			    } while (tempChoose != 3);
  			}
  			break;
  		    case 3:
  			List<Post> allPost = postDAO.all();
  			for (i = 0; i < allPost.size(); i++) {
  			    System.out.println("# " + (i + 1) + " by " + allPost.get(i).getUsuario().getNomeUsuario());
  			    System.out.println("~: " + allPost.get(i).getConteudo());
  			}
  			break;
  		    case 4:
  			break;
  		    }
  		}
  		if (choose == 3) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("{SEUS AMIGOS}");
			System.out.println();
			List<User> followedUsers = userDAO.getFollowed(loggedUser);
			for (i = 0; i < followedUsers.size(); i++) {
			System.out.println("#" + (i + 1) + " " + followedUsers.get(i).getNomeUsuario());
			}
			System.out.println();
			System.out.println("{1} LISTAR TODAS AS PESSOAS");
			System.out.println("{2} DEIXAR DE SEGUIR AMIGO");
			System.out.println("{3} TELA DE MENU");
			System.out.print(":~$ ");
			tempChoose = sc.nextInt();
			System.out.println();
			switch (tempChoose) {
			case 1:
			do {
				System.out.println();
				List<User> allUsers = userDAO.all();

				for (i = 0; i < allUsers.size(); i++) {
				System.out.println("#: " + (i + 1) + " " + allUsers.get(i).getNome());
				}
				System.out.println();
				System.out.println("{1} SEGUIR AMIGO");
				System.out.println("{2} TELA DE MENU");
				tempChoose = sc.nextInt();
				switch (tempChoose) {
				case 1:
				System.out.println(
					"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				sc.nextLine();
				System.out.print("NUMERO DE AMIGO:~$ ");
				Integer friendNumber = sc.nextInt();
				friendNumber--;

				Follow follow = new Follow(allUsers.get(friendNumber), loggedUser);
				followDAO.add(follow);
				break;
				case 2:
				break;
				}
			} while (tempChoose != 2);
			break;
			case 2:
			System.out.println();
			sc.nextLine();
			System.out.print("NUMERO DE AMIGO:~$ ");
			Integer friendNameRemove = sc.nextInt();
			friendNameRemove--;

			Follow follow = new Follow(followedUsers.get(friendNameRemove), loggedUser);
			followDAO.remove(follow);

			break;
			case 3:
			break;
			}
  		    
  		}
  		if (choose == 4) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("{EVENTOS}");
			System.out.println();
			System.out.println("{1} NOVO EVENTO");
			System.out.println("{2} LISTAR SEUS EVENTOS");
			System.out.println("{3} LISTAR TODOS OS EVENTS");
			System.out.println("{4} TELA DE MENU");
			System.out.print(":~$ ");
			tempChoose = sc.nextInt();
			System.out.println();
			switch (tempChoose) {
			case 1:
			System.out.println(
					"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.print("NOME DO EVENTO:~$ ");
				sc.nextLine();
				String devEventName = sc.nextLine();
				
				System.out.print("DATA DO EVENTO (dd/MM/aaaa):~$ ");
				String devEventDate = sc.nextLine();
				System.out.print("LOCAL DO EVENTO:~$ ");
				String devEventLocal = sc.nextLine();
				System.out.print("DESCRIÇÃO DO EVENTO:~$ ");
				String devEventDescription = sc.nextLine();
				Eventos newEvento = new Eventos(loggedUser, devEventName, devEventDate, devEventLocal,
					devEventDescription);
				eventosDAO.add(newEvento);
				tempChoose = 0;
				break;
			case 2:
			if (userDAO.getDevEvents(loggedUser).isEmpty()) {
				System.out.println("{VOCÊ AINDA NÃO TEM NENHUM EVENTO}");
			} else {
				List<Eventos> devList = userDAO.getDevEvents(loggedUser);
				for (i = 0; i < devList.size(); i++) {
				System.out.println("#" + (i + 1) + " { " + devList.get(i).getEventoNome() + " } " + " - "
					+ devList.get(i).getEventoData() + " - " + devList.get(i).getEventoLocal());
				System.out.println(devList.get(i).getEventoDescricao());
				System.out.println();
				}
				do {
				System.out.println();
				System.out.println("{1} EDITAR EVENTO ~ {2} REMOVER EVENTO ~ {3} TELA DE MENU");
				tempChoose = sc.nextInt();
				System.out.println();
				switch (tempChoose) {
				case 1:
					sc.nextLine();
					System.out.println(
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.print("DIGITE O NUMERO DO EVENTO QUE QUER EDITAR:~$ ");
					Integer devNum = sc.nextInt();
					devNum--;
					System.out.println();
					sc.nextLine();
					System.out.print("ESCREVA UM NOVO NOME PARA O EVENTO:~$ ");
					devList.get(devNum).setEventoNome(sc.nextLine());
					eventosDAO.update(devList.get(devNum));
					System.out.print("ESCREVA UMA NOVA DATA PARA O EVENTO:~$ ");
					devList.get(devNum).setEventoData(sc.nextLine());
					eventosDAO.update(devList.get(devNum));
					System.out.print("ESCREVA UM NOVO LOCAL PARA O EVENTO~$ ");
					devList.get(devNum).setEventoLocal(sc.nextLine());
					eventosDAO.update(devList.get(devNum));
					System.out.print("ESCREVA UMA NOVA DESCRIÇÃO PARA O EVENTO:~$ ");
					devList.get(devNum).setEventoDescricao(sc.nextLine());
					eventosDAO.update(devList.get(devNum));
					break;
				case 2:
					sc.nextLine();
					System.out.print("DIGITE O NUMERO DO EVENTO QUE QUER REMOVER:~$ ");
					Integer devNumRemove = sc.nextInt();
					sc.nextLine();
					devNumRemove--;
					eventosDAO.remove(devList.get(devNumRemove));
					System.out.println("{ EVENTO DELETADO }");
					break;
				case 3:
					break;
				}
				} while (tempChoose != 3);
			}
			break;
			case 3:
			
			System.out.println("{EVENTOS}");
			List<Eventos> allDevEvents = eventosDAO.all();
			for (i = 0; i < allDevEvents.size(); i++) {
			System.out.println("# " + (i + 1) + " { " + allDevEvents.get(i).getEventoNome() + " } ");
			System.out.println(allDevEvents.get(i).getEventoData() + " - "
				+ allDevEvents.get(i).getEventoLocal());
			System.out.println("~: " + allDevEvents.get(i).getEventoDescricao());
			}
			break;
			
			case 4:
			break;
			}
  		}
  		if (choose == 5) {
			loggedUser = null;
  		    break;
  		}
  	    } while (true);
  	}
  
    }
}