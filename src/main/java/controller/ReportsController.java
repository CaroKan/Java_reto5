
package controller;

import java.sql.SQLException;
import java.util.List;
import model.dao.*;
import model.vo.*;


public class ReportsController implements IAccesoDatos {
    private final LideresDao lideres;
    private final ProyectosDao proyectos;
    private final ComprasDao compras;

    public ReportsController() {
        lideres = new LideresDao();
        proyectos = new ProyectosDao();
        compras= new ComprasDao();
    }
    
    
    @Override
    public List<LideresVo> listarLideres() throws SQLException {
        return lideres.Listarlideres();
    }

    @Override
    public List<ProyectosVo> listarProyectos() throws SQLException {
        return proyectos.listaProyectos();
    }

    @Override
    public List<ComprasVo> listarCompras() throws SQLException {
        return compras.listadoCompras();
    }
    
}
