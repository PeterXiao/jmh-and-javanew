#!/bin/sh

if [ -z "$JAVA_HOME" ] ; then
	echo "JAVA_HOME env doesn't exist, try to find the location of java"
    JAVA_HOME=`readlink -f \`which java 2>/dev/null\` 2>/dev/null | \
    sed 's/\jre\/bin\/java//' | sed 's/\/bin\/java//'`
fi

if [ ! -d "$JAVA_HOME" ] ; then
	echo "Please set JAVA_HOME env before run this script"
	exit 1
fi

TOOLSJAR="$JAVA_HOME/lib/tools.jar"

if [ ! -f "$TOOLSJAR" ] ; then
    echo "$TOOLSJAR doesn't exist" >&2
    exit 1
fi

DIR=$( cd $(dirname $0) ; pwd -P )

JAVA_OPTS="-Xms96m -Xmx96m -Xmn64m -Xss256k -XX:+UseSerialGC -Djava.compiler=NONE -Xverify:none -XX:AutoBoxCacheMax=20000" 

"$JAVA_HOME"/bin/java $JAVA_OPTS -cp "$DIR/vjmxcli.jar:$TOOLSJAR" com.vip.vjtools.jmx.Client $*