
package model.dao;

import java.sql.SQLException;
import java.util.List;
import model.vo.LideresVo;

public interface ILideres {
    public List<LideresVo> Listarlideres()throws SQLException;
}
