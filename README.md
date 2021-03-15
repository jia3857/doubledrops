# Build spigot plugins

Following https://www.youtube.com/watch?v=GK4aQzxQSoQ

# Test built plugin
## setup spigot server

```bash
$ export PROJECT_TOP_DIR=$(git rev-parse --show-toplevel)
$ mkdir -p ${PROJECT_TOP_DIR}/MC; cd ${PROJECT_TOP_DIR}/MC

# instructions on https://www.spigotmc.org/wiki/buildtools/#latest
$ wget -O BuildTools.jar https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar

$ java -jar BuildTools.jar
$ java -jar BuildTools.jar -rev <version> # or build specific <version>, eg: 1.16.5

# In eula.txt, change "eula=false" to "eula=true"
$ java -jar spigot-1.16.5.jar --nogui
# Once spigot server started successfully, type "stop" to shutdown spigot server
```

## Put file under ${spigot_dir}/plugins/

```bash
$ cd $PROJECT_TOP_DIR

# build src/**/*.java into target/doubledrops-1.0-SNAPSHOT.jar
$ mvn package

# copy target/doubledrops-1.0-SNAPSHOT.jar ${PROJECT_TOP_DIR}/MC/plugins
$ mvn install
```

## Start spigot server again and verify plugin properly load

```bash
$ cd $PROJECT_TOP_DIR/MC

$ java -jar spigot-1.16.5.jar --nogui
# verify plugin properly load, eg:
#   [13:26:56] [Server thread/INFO]: Time elapsed: 1481 ms
#   [13:26:56] [Server thread/INFO]: [Doubledrops] Enabling Doubledrops v1.0-SNAPSHOT
#   [13:26:56] [Server thread/INFO]: Hello World!
#   [13:26:57] [Server thread/INFO]: Server permissions file permissions.yml is empty, ignoring it
#   [13:26:57] [Server thread/INFO]: Done (21.969s)! For help, type "help"
```
