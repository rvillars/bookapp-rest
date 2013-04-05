package ch.bfh.swos.bookapp.service;


public interface IndexService<T> {
	
	 void index(T item, String type, long id);
	 
	 long index(T item, String type);
	 
	 void delete(String Type, long id);

}
