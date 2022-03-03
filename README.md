 <p align="center">
 <img src="https://github.com/ByteMonk-GCECT/GCECT-APP/blob/develop/Assets/github_banner.jpeg" height= 500 width = 889 />
</p>

# GCECT-APP
An native android application of Government College of Engineering and Ceramic Technology

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?&style=for-the-badge&logo=kotlin&logoColor=white)
<br>
![Minimum API Level](https://img.shields.io/badge/Min%20API%20Level-23-green)
![Maximum API Level](https://img.shields.io/badge/Max%20API%20Level-31-orange)
![GitHub repo size](https://img.shields.io/github/repo-size/ByteMonk-GCECT/GCECT-APP)
[![License](https://img.shields.io/badge/license-MIT-%2397ca00.svg)](https://github.com/sitamadex11/CovidHelp/blob/develop/LICENSE)
[![Open Source Love svg1](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)](https://github.com/ellerbrock/open-source-badges/) 
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com) 
![contributions welcome](https://img.shields.io/static/v1.svg?label=Contributions&message=Welcome&color=0059b3&style=flat-square) 
![Maintenance](https://img.shields.io/maintenance/yes/2022)

## The Problems we are trying to resolve 😁:

Our university website was not properly optimised and responsive for mobile devices which posed difficulties for students to navigate and to utilise all the features the website has to offer. Also some times students are missing important notices as they don't get any notification. Also to view a simple notice all students need to download the notice from the website. Our university website Ui also not so user friendly and informative for new comers also there has not any discussion or helping. Altogather we can achieve a lot of functionality using an user friendly mobile application. Therefore we, team GDSC-GCECT come with an idea of an user friendly android app named "GCECT APP".


## The solution, we are working on 💡:

This project proposes a university app that has all the features of the university website with some extra added features and a good user interface. As in each page of our website, all the information's are messy and not cleared therefore our first target is a good user interface that makes every detail attractive to all. On our college's website, for a less important notice, we need to download the pdfs therefore we made a pdf viewer section in our app where users can read the notice without downloading it. We also add functionality to download the notice if required. Also through an app students can get the update of important notices and also there should be a discussion forum in the app where students can discuss their doubts and teachers can share their notes and assignments directly through the app to all of the students. Students also can take short notes which can be saved offline. Also in our different college fests there we need different websites which are not maintained later on. So we can integrate all the necessary things regarding fests directly to the app therefore there will not be required a separate website for a separate fest or events. Not only that, many many more functionality could be added to the app which will make the app more useful to both students and teachers but this will not be possible on a website. Actually, it is an ongoing project, and we are trying to make it our college's official app.

Some features that are included in the app are:
<ul>
  <li>A good UI/UX to make every page more attractive and informative</li>
  <li>recent announcements</li>
  <li>general notice</li>
  <li>download examination schedule</li>
  <li>a note taking section</li>
</ul>

## Functionality & Concepts used 👨‍💻 :

### The App has a very simple, interactive, clean and attractive interface which helps the students to get all the informations of college like notice, faculty detail, syllabus, last year question paper etc. Following are few android concepts used to achieve the functionalities in app:
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development. Our app is totally written in kotlin.
- [Different Layouts](https://developer.android.com/guide/topics/ui/declaring-layout) -  In this app we have used difrenet layouts to make the app UI responsive. The used layouts are LinearLayout, RelativeLayout, ConstraintLayout, FrameLayout and CoordinatorLayout.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android. We used material components like MaterialCardView, MaterialButton etc to make the UI attractive and amke the development easy.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more. Speacially used at the time of PDF fetching from url.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. Highly used shared viewmodel in the app.
  - [Data Binding](https://developer.android.com/topic/libraries/data-binding?authuser=2) - The Data Binding Library is a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically. Used two data binding in each fragments.
  - [Navigation](https://developer.android.com/guide/navigation#:~:text=Navigation%20refers%20to%20the%20interactions,bars%20and%20the%20navigation%20drawer.) - Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app. In our app we followed single app architecture using navigation and also implemented an unique nav nav drawer.
  - [Room](https://developer.android.com/jetpack/androidx/releases/room) - The Room persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite. To store notes.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - LiveData is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services. To check new notes added or not.
- [Firebase](https://firebase.google.com/docs/android/setup) - Firebase is Google's mobile application development platform that helps you build, improve, and grow your app. 
  - [Storage](https://firebase.google.com/docs/storage/web/start#:~:text=Cloud%20Storage%20for%20Firebase%20lets,high%20availability%20and%20global%20redundancy.) - Cloud Storage for Firebase lets you upload and share user generated content, such as images and video, which allows you to build rich media content into your apps. Here we used store to add static data.
- [Glide](https://github.com/bumptech/glide) - Glide is a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface. We have used it for image loading.
- [BottomSheet](https://material.io/components/sheets-bottom/android) - Bottom sheets are surfaces containing supplementary content that are anchored to the bottom of the screen. To show the general notice list in home page.
- [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview?authuser=2) - RecyclerView makes it easy to efficiently display large sets of data. To show large lists.
- [MVVM](https://developer.android.com/jetpack/guide) - MVVM architecture is a Model-View-ViewModel architecture that removes the tight coupling between each component. In the note taking section we used MVVM.
- [ViewPager2](https://developer.android.com/training/animation/screen-slide-2) - ViewPager2 objects have built-in swipe gestures to transition through pages, and they display screen slide animations by default. Using ViewPager2 and tablayout we have used a slidable fragment.
- [TabLayout](https://developer.android.com/reference/com/google/android/material/tabs/TabLayout) - TabLayout provides a horizontal layout to display tabs.Using ViewPager2 and tablayout we have used a slidable fragment.
- [Android PdfViewer](https://github.com/barteksc/AndroidPdfViewer) - To view PDFs from url inside app.
- **Some more 3rd party libraries used in this project :**
  - [CircularImageView](https://github.com/lopspower/CircularImageView) - This is an Android project allowing to realize a circular ImageView in the simplest way possible. To make image view circular we have implented it in gate ranker list.
  - [Android-Image-Slider](https://github.com/smarteist/Android-Image-Slider) -  An amazing image slider for the Android. In home fragment and Nss fragment we have used Auto Image Slider.
  - [PRDownloader](https://github.com/MindorksOpenSource/PRDownloader) - A file downloader library for Android with pause and resume support. We used to download PDF files.
  - [Dexter](https://github.com/Karumi/Dexter) - Dexter is an Android library that simplifies the process of requesting permissions at runtime. We used to take External Storage Read and Write permission from the user.
  
  ## Download 📥
- Click [Here](https://drive.google.com/file/d/1dYNF4PMQSnzelyyqQsvGvo4NispntQu6/view?usp=sharing) to download the latest apk.

## Requirements 🎯 
- Android 6.0 and Above
- Min sdk version 23

## Permissions 💻
- Internet
- Storage

## Future Scope 📲:
For the time being we are working with static datas of the website. After completiing all the tasks with static datas, our principal sir had promised that he would give us the access of the database of our college website.  According with developer team, we have made a UI team and a Testing team to make the app production ready. Also we have planned to add realtime notification services, discussion pannel, class notes adding section and a library management system. And whenever it will be publication ready then we will upload it to the playstore and it will be our official college app.

## Contributing Guideline ✍
- Before start your contribution please go through our contribution guideline carefully. ([READ](https://github.com/ByteMonk-GCECT/GCECT-APP/blob/develop/Assets/Contributing.md))
- You need to push your PR on [develop](https://github.com/ByteMonk-GCECT/GCECT-APP/tree/develop) branch only.
- Join your whatsapp group for further discussion.[CLICK HERE](https://chat.whatsapp.com/JXYziNoD3lD9RWQwD3VyEe) TO JOIN.

## 😎Maintainers
<table>
  <tbody><tr>
    <td align="center"><a href="https://github.com/sitamadex11"><img alt="" src="https://avatars.githubusercontent.com/sitamadex11" width="200px;"><br><sub><b> Sitam Sardar </b></sub></a><br></td> </a></td>
        <td align="center"><a href="https://github.com/Kunal-Kayal"><img alt="" src="https://avatars.githubusercontent.com/Kunal-Kayal" width="200px;"><br><sub><b> Kunal Kayal </b></sub></a><br></td> </a></td>
            <td align="center"><a href="https://github.com/chayan-dev"><img alt="" src="https://avatars.githubusercontent.com/chayan-dev" width="200px;"><br><sub><b> Chayan Das </b></sub></a><br></td> </a></td>
	    <td align="center"><a href="https://github.com/cdhiraj40"><img alt="" src="https://avatars.githubusercontent.com/cdhiraj40" width="200px;"><br><sub><b> Dhiraj Chauhan </b></sub></a><br></td> </a></td>
	    <td align="center"><a href="https://github.com/hellosagar"><img alt="" src="https://avatars.githubusercontent.com/hellosagar" width="200px;"><br><sub><b> Sagar Khurana </b></sub></a><br></td> </a></td>
</tr>
</tbody>
</table>
<hr>

 <h1 align="center">-: 📷SCREEN SHOTS📷 :-</h1>

<hr>

## * App Splash-Screen and Navigation-Drawer:-
<p align="center">
  <img src=https://github.com/Shounak2001/GCECT-APP/blob/faa7f15f3108d40541a183ebe5c4719998bda2f4/Assets/App%20Navigation.jpg height= 500 width = 1500 />
</p>

## * Home Section:-
<p align="center">
 <img src=https://github.com/Shounak2001/GCECT-APP/blob/4cbb4cb31331dc3f74f5b2f7d99d0d16a48e0cb1/Assets/Home%20Section%201.jpg height= 650 width = 1000 />
  <img src=https://github.com/Shounak2001/GCECT-APP/blob/4cbb4cb31331dc3f74f5b2f7d99d0d16a48e0cb1/Assets/Home%20Section%202.jpg height= 650 width = 700 />
</p>

## * Examination Section:-
<p align="center">
 <img src="https://github.com/Shounak2001/GCECT-APP/blob/4cbb4cb31331dc3f74f5b2f7d99d0d16a48e0cb1/Assets/Examination%20Section.jpg" height= 500 width = 1500 />
</p>

## * Trainaing and Placement Section:-
<p align="center">
 <img src="https://github.com/Shounak2001/GCECT-APP/blob/4cbb4cb31331dc3f74f5b2f7d99d0d16a48e0cb1/Assets/Trainaing%20and%20Placement%20Section.png" height= 624 width = 1500 />
</p>

## * Campus Life Section:-
<p align="center">
 <img src="https://github.com/Shounak2001/GCECT-APP/blob/4cbb4cb31331dc3f74f5b2f7d99d0d16a48e0cb1/Assets/Campus%20Life%20Section%201.png" height= 624 width = 1000 />
  <img src="https://github.com/Shounak2001/GCECT-APP/blob/4cbb4cb31331dc3f74f5b2f7d99d0d16a48e0cb1/Assets/Campus%20Life%20Section%202.png" height= 624 width = 1000 />
</p>

## * Take Note Section:-
<p align="center">
 <img src="https://github.com/Shounak2001/GCECT-APP/blob/4cbb4cb31331dc3f74f5b2f7d99d0d16a48e0cb1/Assets/Take%20Note%20Section.jpg" height= 994 width = 1000 />
</p>


## License 

```
MIT License

Copyright (c) 2022 ByteMonk-GCECT Tech Club

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
### If you liked the project don't forget to star 🌟 and fork 🍽 the project.
![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)
![ForTheBadge ANDROID](https://forthebadge.com/images/badges/built-for-android.svg)
![ForTheBadge GIT](https://forthebadge.com/images/badges/uses-git.svg)

### Credits goes to these people:✨

<table>
	<tr>
		<td>
   <a href="https://github.com/ByteMonk-GCECT/GCECT-APP/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=ByteMonk-GCECT/GCECT-APP" />
</a>
		</td>
	</tr>
</table>



<br>
<br>
<h2 align="center">❤ Our Aim to help college community ❤</h2>

<br>
