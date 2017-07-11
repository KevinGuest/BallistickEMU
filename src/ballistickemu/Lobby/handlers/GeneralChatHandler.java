/*
 *     THIS FILE AND PROJECT IS SUPPLIED FOR EDUCATIONAL PURPOSES ONLY.
 *
 *     This program is free software; you can redistribute it
 *     and/or modify it under the terms of the GNU General
 *     Public License as published by the Free Software
 *     Foundation; either version 2 of the License, or (at your
 *     option) any later version.
 *
 *     This program is distributed in the hope that it will be
 *     useful, but WITHOUT ANY WARRANTY; without even the
 *     implied warranty of MERCHANTABILITY or FITNESS FOR A
 *     PARTICULAR PURPOSE. See the GNU General Public License
 *     for more details.
 *
 *     You should have received a copy of the GNU General
 *     Public License along with this program; if not, write to
 *     the Free Software Foundation, Inc., 59 Temple Place,
 */
package ballistickemu.Lobby.handlers;
import ballistickemu.Main;
import ballistickemu.Types.StickClient;
import ballistickemu.Tools.StickPacketMaker;

/**
 *
 * @author Simon
 */
public class GeneralChatHandler {
    public static void HandlePacket(StickClient client, String Packet)
        {

            if (client != null)
            {
                /*
                if ((Packet.length() > 9) && (Packet.substring(1, 10).equalsIgnoreCase("!setcolor")))
                {
                    setNewColor(client, Packet.substring(11).replaceAll("\0", "").split(" "), false);
                    return;
                }
                if ((Packet.length() > 12) && (Packet.substring(1, 13).equalsIgnoreCase("!setpetcolor")))
                {
                    setNewColor(client, Packet.substring(14).replaceAll("\0", "").split(" "), true);
                    return;
                }
                if ((Packet.length() > 16) && (Packet.substring(1, 16).equalsIgnoreCase("!builderspinner")))
                {
                    addSpinner(client, Packet.substring(17).replaceAll("\0", "").split(" "), 181);
                    return;
                }
                if ((Packet.length() > 14) && (Packet.substring(1, 14).equalsIgnoreCase("!fuzzyspinner")))
                {
                    addSpinner(client, Packet.substring(15).replaceAll("\0", "").split(" "), 182);
                    return;
                }
                if ((Packet.length() > 14) && (Packet.substring(1, 14).equalsIgnoreCase("!fuzzyspinner")))
                {
                    addSpinner(client, Packet.substring(15).replaceAll("\0", "").split(" "), 182);
                    return;
                }
                if ((Packet.length() > 14) && (Packet.substring(1, 14).equalsIgnoreCase("!fuzzyspinner")))
                {
                    addSpinner(client, Packet.substring(15).replaceAll("\0", "").split(" "), 182);
                    return;
                }
                if ((Packet.length() > 12) && (Packet.substring(1, 12).equalsIgnoreCase("!modspinner") && (client.getModStatus())))
                {
                    addSpinner(client, Packet.substring(13).replaceAll("\0", "").split(" "), 183);
                    return;
                }
/*
                if (Packet.length() > 12 && (Packet.substring(1, 12).equalsIgnoreCase("::modverify")))
                {
                    ModVerify(client, Packet);
                    return;
                }
*/
                if(Packet.substring(1).startsWith("!"))
                {
                    PlayerCommandHandler.HandlePacket(client, Packet.substring(1));
                    return;
                }
                
                if(Packet.substring(1, 3).equalsIgnoreCase("::"))
                {
                    ModCommandHandler.ProcessModCommand(client, Packet.substring(1).replaceAll("\0", ""));
                    return;
                }

                if(client.getMuteStatus())
                {
                    client.writeCallbackMessage("SERVER MESSAGE: Unable to send chat message as you have been muted.");
                    return;
                }
                String UIDFrom = client.getUID();
                String Text = Packet.substring(1);
                if (client.getLobbyStatus())
                    Main.getLobbyServer().BroadcastPacket(StickPacketMaker.GeneralChat(UIDFrom, Text));
                else
                    client.getRoom().BroadcastToRoom(StickPacketMaker.GeneralChat(UIDFrom, Text));
            }

        }
 /*
    private static void ModVerify(StickClient client, String Packet)
        {
        ResultSet result = null;
        String toCheck_User = "";
        String toCheck_Pass = "";
        String[] Splitted = Packet.replaceAll("\0", "").split(" ");
        if(Splitted.length != 3)
        {
            client.writeCallbackMessage("::modverify syntax: ::modverify <username> <password>");
            return;
        }
        toCheck_User = Splitted[1];
        int rowCount = -1;
                    if(!toCheck_User.equalsIgnoreCase(client.getName()))
                    {
                        client.writeCallbackMessage("SERVER MESSAGE: Verification unsuccessful: invalid username supplied.");
                    }
                    try
                    {
                         toCheck_Pass = PasswordHasher.generateHashedPassword(Splitted[2]);
                    }
                    catch(NoSuchAlgorithmException e){}
                    try
                    {
                        synchronized (DatabaseTools.lock)
                        {
                          PreparedStatement ps = DatabaseTools.getDbConnection().prepareStatement("SELECT * FROM `users` WHERE `userNAME` = ? AND `userPASS` = ? AND `user_level` = '1'");
                          ps.setString(1, toCheck_User);
                          ps.setString(2, toCheck_Pass);
                          rowCount = DatabaseTools.getRowCount(ps);
/*                          result = ps.executeQuery();
                          result.last();
*                      }

                    } catch(SQLException e){
                        System.out.println(e.toString());
                    }
                    if (rowCount != -1)
                    {

                            if (rowCount > 0)
                                {
                                    //is a mod
                                    client.setModStatus(true);
                                    client.writeCallbackMessage("SERVER MESSAGE: You have successfully verified as a Moderator.");
                                } else {
                                    client.writeCallbackMessage("SERVER MESSAGE: Verification unsuccessful: Either you are not a moderator, or your login details are wrong.");
                                }
                        }
                     return;
            }
*/
    
                

}
