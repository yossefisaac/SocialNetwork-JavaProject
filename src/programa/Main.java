package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import UI_FX.*;

/*import dataBase.DevEventsDAO;
import dataBase.FollowDAO;
import dataBase.GameEventsDAO;
import dataBase.MarketplaceDAO;
import dataBase.PostDAO;
import dataBase.UserDAO;
import dataBase.UtilBD;*/
import entidades.*;

import javafx.application.Application;

public class Main {

    public static void main(String[] args) {

	//UtilBD.initBD();

	Application.launch(LoginTela.class);

	//UtilBD.closeConection();

    }
}