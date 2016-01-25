# DevSet
###### Set the device locale with `ADB`

It's not to easy to set the locale of an emulator or device from `ADB`.

*DevSet* provides a `BroadcastReceiver` to do so with one (simple) command.
Be careful here, everyone can call it!


### Setting the locale
A `BroadcastReceiver` is used to handle the locale input from `ADB`.
`{locale}` should be a representation of `Locale` like *en*, *en_US* or *en-US*.

    adb shell am broadcast -n dev.set/.locale --es l {locale}


### Installation
Gradle handles the installation and the permission granting with

    gradle install

##### Granting the permission
Granting the permission is done with

    adb shell pm grant dev.set android.permission.CHANGE_CONFIGURATION

