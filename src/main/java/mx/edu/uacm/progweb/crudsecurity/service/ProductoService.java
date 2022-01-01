package mx.edu.uacm.progweb.crudsecurity.service;
import java.util.List;


 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uacm.progweb.crudsecurity.dominio.Producto;
import mx.edu.uacm.progweb.crudsecurity.repository.ProductoRepository;

 
@Service
@Transactional
public class ProductoService {
 
    @Autowired
    private ProductoRepository repo;
     
    public List<Producto> listAll() {
        return repo.findAll();
    }
     
    public void save(Producto producto) {
        repo.save(producto);
    }
     
    public Producto get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
