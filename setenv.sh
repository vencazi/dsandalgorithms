# Directory where the application is installed
#
APP_PATH=/home/venkat/tech/interview/build
# Java Home
#

CP=$APP_PATH/classes
CP=$CP:$APP_PATH/lib/commons-lang3-3.1.jar
CP=$CP:$APP_PATH
echo $CP
export CLASSPATH=$CP

#$JAVA_HOME/bin/java -classpath $CP -Xmx2048m -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8701
