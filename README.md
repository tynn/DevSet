# DevSet
###### Set the device locale with ADB

It's not to easy to set the locale of an emulator or device from ADB directly.

*DevSet* provides a system protected `BroadcastReceiver` to do so with just one
(simple) command.


### Usage

    adb shell am broadcast -n dev.set/.locale --es l {locale}

`{locale}` must be a representation or tag of a `java.util.Locale`
like *en*, *en_US* or *en-US*.

##### Required permission
The receiver itself requires the system permission
`android.permission.CHANGE_CONFIGURATION` to protect against abuse.


### Installation

    gradle install

Gradle handles the installation and grants the permission needed to change the
device locale.

##### Granting the permission
Granting the permission manually can be done with

    adb shell pm grant dev.set android.permission.CHANGE_CONFIGURATION

