# Setup guidelines

These instructions will help you to set up your development 
environment, get the source code of the BatteryAlarn Android app 
and build it by yourself. If you want to help develop the 
app take a look at the [contribution guidelines](https://github.com/ByteMonk-GCECT/GCECT-APP/blob/develop/Assets/Contributing.md)

If you have any problem, remove the 'android' folder, 
start again from 1) and work your way down. If something 
still does not work as described here, please open a new issue 
describing exactly what you did, what happened, and what should 
have happened.

## 0. Common software dependencies

There are some tools needed, no matter what is your specific 
IDE or build tool of preference.

[git](https://git-scm.com/) is used to access to the different versions of 
the BatteryAlarm's source code. Download and install the 
version appropriate for your operating system from [here](https://git-scm.com/downloads). 
Add the full path to the 'bin/' directory from your git 
installation into the PATH variable of your environment so that
it can be used from any location.

The [Android SDK](https://developer.android.com/sdk/index.html) is necessary to build the app. There are 
different options to install it in your system, depending of 
the IDE you decide to use. Check Google [documentation](https://developer.android.com/sdk/installing/index.html) about 
installation for more details on these options. 
After installing it, add the full path to the directories 'tools/' 
and 'platform-tools/' from your Android SDK installation 
into the PATH variable of your environment.

Open a terminal and type 'android' to start the Android SDK Manager. To build the Nextcloud for Android app you will need to install at least the next SDK packages:

* Android SDK Tools and Android SDK Platform-tools 
(already installed); upgrade to their last versions is 
usually a good idea.

Install any other package you consider interesting, 
such as emulators.

For other software, dependencies check the details 
in the section corresponding to your preferred IDE or build system.

## 1. Fork & Download GCECT-APP Repository

You will need [git](https://git-scm.com/) to access to the different versions of the Nextcloud's source code. The source code is hosted on GitHub and may be read by anybody, without a GitHub account. You will need one if you want to contribute to the development of the app with your own code.

The next steps will assume you have a GitHub account and that you will get the code from your own fork.

* In a web browser, go to ```https://github.com/ByteMonk-GCECT/GCECT-APP.git```, and click the 'Fork' button near the top right corner.
* Open a terminal and go on with the next steps in it.
* Clone your forked repository: git clone ```https://github.com/YOURGITHUBNAME/android.git```.
* Move to the project folder with ```cd BatteryAlarm```.
* Pull any changes from your remote branch 'master': `git pull origin master`
* Make official BatteryAlarm repo known as upstream: `git remote add upstream https://github.com/ByteMonk-GCECT/GCECT-APP.git`
* Make sure to get the latest changes from official android/master branch: `git pull upstream master`

## 2.  Working with Android Studio

[Android Studio](https://developer.android.com/tools/studio/index.html) is currently 
the official Android IDE. Due to this, we recommend it as the 
IDE to use in your development environment. Follow the 
installation instructions [here](https://developer.android.com/sdk/installing/index.html?pkg=studio).

We recommend to use the last version available in 
the stable channel of Android Studio updates. 
See what update channel is your Android Studio checking for
updates in the menu path 'Help'/'Check for Update…'/link 'Updates' in the dialog.

To set up the project in Android Studio follow the next steps:

* Open Android Studio and select 'Import Project (Eclipse ADT, Gradle, etc)'. Browse through your file system to the folder 'android' where the project is located. Android Studio will then create the '.iml' files it needs. If you ever close the project but the files are still there, you just select 'Open Project…'. The file chooser will show an Android face as the folder icon, which you can select to reopen the project.
* Android Studio will try to build the project directly after importing it. To build it manually, follow the menu path 'Build'/'Make Project', or just click the 'Play' button in the toolbar to build and run it in a mobile device or an emulator. The resulting APK file will be saved in the 'build/outputs/apk/' subdirectory in the project folder.
* Setup Android Studio editor configurtation for the 
project: `Settings` → `Editor` → `Code Style` → `Scheme: Project` and `Enable EditorConfig support`
