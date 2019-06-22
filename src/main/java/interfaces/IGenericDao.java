package interfaces;

import java.io.Serializable; 
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order; 

/**
 *
 * @author BiaChacon
 */
public interface IGenericDao<T, ID extends Serializable> { 
 
    void save(T object); 
    void delete(T object); 
    T findById(ID id);
    List<T> listAll(); 
    List<T> findAllBy(String property, List<?> values); 
    List<T> findAllBy(String property, List<?> values, Order order); 
    List<T> findAllBy(String property, Object value); 
    List<T> findAllBy(String property, Object value, Order order); 
    List<T> findAll(); 
    List<T> findAll(Order order); 
    List<T> findAllByMulti(Map<String, Object> condition); 
    T findBy(String property, Object value); 
}
