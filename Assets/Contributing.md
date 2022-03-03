# Contributing Guidelines

### 👍🎉 First off, welcome to the project and thanks for taking the time to contribute! 🎉👍
<br>

#### When contributing to this repository, please first discuss the change you wish to make before making a change.
<br>

## Before Getting Started!
Learn how to fork a repo, create an issue, make changes, create a pull request.
Please read our SETUP.md file for setting up our project in your local environment.

For more information, refer to <a href = "https://docs.github.com/en" target = "_self">GitHub Documentation</a>

--------
### Issue Reporting
* Report the issue and choose bug report or feature request. The template includes all the information we need to track down the issue.
* This repository is only for issues within the BatteryAlarm Android app code. Issues in other components should be reported in their own repositories.
* Search the existing issues first, it's likely that your issue was already reported. If your issue appears to be a bug, and hasn't been reported, open a new issue.

## Contributing to Source Code
### Branching model
* All contributions bug fix or feature PRs target the develop branch
* Feature releases will always be based on develop.
* Bugfix releases will always be based on their respective feature-release-bug-fix-branches
* Hotfixes not relevant for an upcoming feature release but the latest release can target the bug fix branch directly

### Android Studio formatter setup
* Standard Android Studio
* Line length 120 characters (Settings->Editor->Code Style->Right margin(columns): 120)
* Auto optimize imports (Settings->Editor->Auto Import->Optimize imports on the fly)

### Contribution process
 * Go through 'Issues' to ensure whether the said issue has already been raised.

 * If you do find a new issue, do not hesitate to open a new one. Make sure to describe any additions required in the message.

 * If you want to contribute on UI theme of the application make sure you maintain the proper color theme of our college app. For reference, you can see our [UI design in figma]( https://www.figma.com/file/6xXpKNhilvlLJ6HUpC2kkC/University-APP?node-id=0%3A1)
 * If interested, do mention the issue that you want to work on it.

 * Kindly wait for approval from the maintainers of this project before starting to work on any issue.

* *Do not make changes to the main branch.* All the changes should be made to the develop branch.

* Make sure that your code is properly formatted and does not contain any commented-out code.

* Create a pull request after making the required changes and do mention the issue number that your pull request is related to.

* Finally, wait for it to be reviewed. Make the required changes if the reviewer asks for them. 

* Your pull request will be merged once everything seems okay.

* That's it! You have successfully made your contribution to the project.
<br>

### Fork and download android repository
* Commit your changes locally: git commit -a
* Push your changes to your GitHub repo: git push
* Browse to https://github.com/YOURGITHUBNAME/android/pulls and issue a pull request
* Enter a description and send a pull request.




## GIT AND GITHUB


Before continuing we want to clarify the difference between Git and Github. Git is a version control system(VCS) which is a tool to manage the history of our Source Code. GitHub is a hosting service for Git projects.

We assume you have created an account on Github and installed Git on your System.

Now tell Git your name and E-mail (used on Github) address.

     $ git config --global user.name "YOUR NAME"
     $ git config --global user.email "YOUR EMAIL ADDRESS"
     

This is an important step to mark your commits to your name and email.

### FORK A PROJECT -

You can use [github explore]( https://github.com/explore) to find a project that interests you and match your skills. Once you find your cool project to workon, you can make a copy of project to your account. This process is called forking a project to your Github account. On Upper right side of project page on Github, you can see -

<p align="center">  <img  src="https://i.imgur.com/P0n6f97.png">  </p>

Click on fork to create a copy of project to your account. This creates a separate copy for you to workon.

### FINDING A FEATURE OR BUG TO WORKON - 

Open Source projects always have something to workon and improves with each new release. You can see the issues section to find something you can solve or report a bug. The project managers always welcome new contributors and can guide you to solve the problem. You can find issues in the right section of project page.

<p align="center">  <img  src="https://i.imgur.com/czVjpS7.png">  </p>

### CLONE THE FORKED PROJECT -

You have forked the project you want to contribute to your github account. To get this project on your development machine we use clone command of git.

$ git clone https://github.com/<your-account-username>/<your-forked-project>.git  
Now you have the project on your local machine.

### ADD A REMOTE (UPSTREAM) TO ORIGINAL PROJECT REPOSITORY 

Remote means the remote location of project on Github. By cloning, we have a remote called origin which points to your forked repository. Now we will add a remote to the original repository from where we had forked.

    $ cd <your-forked-project-folder>
    $ git remote add upstream https://github.com/<author-account-username>/<project>.git
    
You will see the benefits of adding remote later.

### SYNCHRONIZING YOUR FORK -

Open Source projects have a number of contributors who can push code anytime. So it is necessary to make your forked copy equal with the original repository. The remote added above called Upstream helps in this.


    $ git checkout master
    $ git fetch upstream
    $ git merge upstream/master
    $ git push origin master
  

The last command pushes the latest code to your forked repository on Github. The origin is the remote pointing to your forked repository on GitHub.

### CREATE A NEW BRANCH FOR A FEATURE OR BUGFIX -

Normally, all repositories have a master branch that is considered to remain stable and all new features should be made in a separate branch and after completion merged into the master branch. So we should create a new branch for our feature or bugfix and start working on the issue.

$ git checkout -b <feature-branch>
This will create a new branch out of master branch. Now start working on the problem and commit your changes.

    $ git add --all
    $ git commit -m "<commit message>"
    

The first command adds all the files or you can add specific files by removing -a and adding the file names. The second command gives a message to your changes so you can know in the future what changes this commit makes. If you are solving an issue on the original repository, you should add the issue number like #35 to your commit message. This will show the reference to commits in the issue.

### REBASE YOUR FEATURE BRANCH WITH UPSTREAM-

It can happen that your feature takes time to complete and other contributors are constantly pushing code. After completing the feature your feature branch should be rebased on the latest changes to the upstream master branch.

    $ git checkout <feature-branch>
    $ git pull --rebase upstream master

Now you get the latest commits from other contributors and check that your commits are compatible with the new commits. If there are any conflicts solve them.

### SQUASHING YOUR COMMITS-

You have completed the feature, but you have made a number of commits that make less sense. You should squash your commits to make good commits.

$ git rebase -i HEAD~5    
This will open an editor which will allow you to squash the commits.

### PUSH CODE AND CREATE A PULL REQUEST -

Till this point, you have a new branch with the feature or bugfix you want in the project you had forked. Now push your new branch to your remote fork on Github.

$ git push origin <feature-branch>
    
Now you are ready to help the project by opening a pull request means you now tell the project managers to add the feature or bugfix to the original repository. You can open a pull request by clicking on the green icon -

<p align="center">  <img  src="https://i.imgur.com/aGaqAD5.png">  </p>

Remember your upstream base branch should be master and the source should be your feature branch. Click on create a pull request and add a name to your pull request. You can also describe your feature.

Awesome! You have made your first contribution.

#### BE OPEN!
<br>
-----------------

### *Note*: Always comment and provide apt descriptions wherever necessary for the efficient running of the project.
