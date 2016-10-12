#!/bin/sh
usage () echo "usage: $0 command [arguments]"
commands() echo "  l locale"
[ $# -lt 1 ] && usage && exit 1
case "${1#-}" in
	l) argc=1 ; exec="adb shell am broadcast -n dev.set/.locale --es l" ;;
    h|?) usage && commands && exit 0 ;;
	*) usage && exit 2 ;;
esac
shift
[ $# -ne $argc ] && usage && exit 1
PATH="$PATH:$ANDROID_HOME/platform-tools"
$exec $@
