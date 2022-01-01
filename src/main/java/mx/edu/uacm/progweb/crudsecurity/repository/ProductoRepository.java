package mx.edu.uacm.progweb.crudsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edu.uacm.progweb.crudsecurity.dominio.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
