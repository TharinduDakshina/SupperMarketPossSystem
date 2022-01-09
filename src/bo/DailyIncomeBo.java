package bo;



import dto.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DailyIncomeBo extends SuperBo{

    ArrayList<CustomDTO> getdailyItems() throws SQLException, ClassNotFoundException;

    ArrayList<CustomDTO> getDailyItemsIncome() throws SQLException, ClassNotFoundException;
}
