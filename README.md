# BallistickEMU

Stick Arena: Ballistick | Server Creation Files

-Fixed some PHP bugs -Fixed the incomplete SQL template -Added all the settings/maps/ect (Currently missing maps, sadly I cannot provide you with a number but you can get them yourself) -Added the unobfuscated 558 .swf

Notes:

Buying items is buggy.
Sometimes newly bought items aren't listed.
If re-log in after purchasing an item, it should appear again in your items list.
Map creation isn't functional!
Instructions for Installation:

Set up a webserver and MySQL database. IIS, preferably something similar like NGINX or XAMPP.

Copy the contents of web/wwwroot to your wwwroot or htdocs depending on what webserver you are using.

Open up "stick_arena.php" and set your database details in there (server is normally localhost).

Also open "crossdomain.xml" and set the IP to the server IP you are running on.
Open up the folder "game". (This folder contains the needed tools.)

In there open up the file "flo.flm" and search for "http://localhost/stick_arena.php".
Replace this with the desired URL of your stick_arena.php.
Run "assemble.bat". This will create your new client. Rename the client to "game_internet.swf".

Open up "settings558b.ini".

Change "&sServerName0=" to your desired server name, "&sServerURL0=" to your IP address, and "&sAdminMsgText=" to your desired server message.
Copy the "maps" folder, "com" folder, "game_internet.swf", "settings558b.ini", "mapEditorTiles.csv", "upgradevalues558.ini" all over to your wwwroot folder.

Using phpMyAdmin or similar, create a new database called "stick_arena". -Once this is done, select the database, click import, then use the page to upload "ballistick_struct.sql".

I either recommend db4free.net or xampp's mysql option in the control panel.
Open up the folder "BallistickEMU" and open config.properties.

Change these to the credentials of your database.
Also set the IP at which your server will be running in the server_IP field.
Run "run.bat" and you're done!

1138 = American Port. 80 = European Port.
