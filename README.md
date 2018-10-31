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
The *ADB* shell already has this permission granted.


### Installation

On Linux/Mac:

    ./gradlew install

On Windows:

    gradlew install

Gradle handles the installation and grants the permission needed to change the
device locale.

#### Granting the permission

##### From Android Oreo
Granting the permission must be done by the user. Just start the manager with

    adb shell am start -a android.settings.action.MANAGE_WRITE_SETTINGS

and allow *DevSet* to write the settings.

##### Up to Android Nougat
Granting the permission manually can be done with

    adb shell pm grant dev.set android.permission.CHANGE_CONFIGURATION
