# Setup

REF: https://gist.github.com/noahcoad/fc9d3984a5d4d61648269c0a9477c622

```bash
# Download raspberryjuice plugins and put in spigot plugs
$ wget https://dev.bukkit.org/projects/raspberryjuice/files/2496319/download
$ mv ~/Downloads/raspberryjuice-1.11.jar .

# Get mcpi library
$ git clone https://github.com/zhuowei/RaspberryJuice.git; mkdir py/
$ cp -r RaspberryJuice/src/main/resources/mcpi/api/python/modded/mcpi py/; cd py/

# Start spigot,
$ java -jar spigot-1.16.5.jar --nogui
# then start minecraft and then join local spigot server

# make minecraft cubs and towers in realm
$ python2 minecraft-cubes-and-towers.py
```
