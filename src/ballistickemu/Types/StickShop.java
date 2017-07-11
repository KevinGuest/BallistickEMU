/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ballistickemu.Types;
import java.util.LinkedHashMap;
import ballistickemu.Tools.DatabaseTools;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author Simon
 */
public class StickShop {
    private LinkedHashMap<Integer, Integer> ShopList;
    public StickShop()
    {
        ShopList = new LinkedHashMap<Integer, Integer>();
    }

    public int getPriceByItemID(int itemID)
    {
        if(ShopList.containsKey(itemID))
        {
            return ShopList.get(itemID);
        } else
        {
            return -1;
        }
    }

    public Boolean PopulateShop()
    {
        try
        {
            ResultSet rs = DatabaseTools.executeSelectQuery("select * from shop");
            while (rs.next())
            {
                int IID = rs.getInt("itemID");
                int cost = rs.getInt("cost");
                this.ShopList.put(IID, cost);
            }
            if(ShopList.size() > 1)
                return true;
            else
                return false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

}
