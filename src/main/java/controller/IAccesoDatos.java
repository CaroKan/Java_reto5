
package controller;

import java.sql.SQLException;
import java.util.List;
import model.dao.LideresDao;
import model.vo.ComprasVo;
import model.vo.LideresVo;
import model.vo.ProyectosVo;

public interface IAccesoDatos {
    List<LideresVo> listarLideres() throws SQLException;
    List<ProyectosVo> listarProyectos()throws SQLException;
    List<ComprasVo> listarCompras()throws SQLException;
}
