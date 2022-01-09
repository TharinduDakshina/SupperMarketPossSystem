package bo;



import entity.OrderDetail;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MostMovableItemBo extends SuperBo{
    ArrayList<OrderDetail> getAllOrderDetails() throws SQLException, ClassNotFoundException;
}
