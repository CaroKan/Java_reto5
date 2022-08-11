
package model.dao;

import java.sql.SQLException;
import java.util.List;
import model.vo.ComprasVo;

public interface ICompras {
    public List<ComprasVo> listadoCompras()throws SQLException;
}
