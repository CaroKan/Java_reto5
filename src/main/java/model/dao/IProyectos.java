
package model.dao;

import java.sql.SQLException;
import java.util.List;
import model.vo.ProyectosVo;

public interface IProyectos {
    public List<ProyectosVo> listaProyectos()throws SQLException;
}
