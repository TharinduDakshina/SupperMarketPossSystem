package bo;



import entity.Item;

import java.sql.SQLException;

public interface ModifyItemBo extends SuperBo{
    boolean updateItem(Item i) throws SQLException, ClassNotFoundException;


    Item searchItem(String text) throws SQLException, ClassNotFoundException;
}
