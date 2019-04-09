package Controller;

import java.util.ArrayList;
import java.util.List;
import Model.Restaurante;

public class ControllerRestaurante {

	List<Restaurante> arrayRestaurante = new ArrayList<Restaurante>(3);
	
	public void cadRestaurante(Restaurante rest){
		arrayRestaurante.add(rest);
	}
}
