package bancoDeDados;

import java.util.List;

public interface InterfaceDAO<T> {

	public void add(T reference);

	public void remove(T reference);
	
	public void update(T reference);

	public List<T> all();
	
	public int getLastId();
}