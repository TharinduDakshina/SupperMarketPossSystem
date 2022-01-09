package bo;


import entity.Item;

import java.sql.SQLException;

public interface RemoveItemBo extends SuperBo{

    Item searchItem(String text) throws SQLException, ClassNotFoundException;

    boolean deleteItem(String text) throws SQLException, ClassNotFoundException;
}
