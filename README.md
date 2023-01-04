CV management desktop application for SE302 Project 


***CV MANAGER***

------------

Welcome Page
------------

![WhatsApp Image 2023-01-04 at 11 02 37 PM](https://user-images.githubusercontent.com/72270515/210640699-85baa988-7916-4a24-8614-37f332a78ea1.jpeg)

------------



CV Manager is a desktop application in which users can create their own CVs. If you want to create a digital CV and edit it whenever you want, this desktop application provides you with these features. CV Manager’s architecture is designed as simply as possible. You can switch from one page to another page easily and can view your CVs clearly.

CV Manager is a school project which aims to create CVs for its users easily and efficiently. We focused to make a simple CV Manager desktop application for the user to understand directly how to use it.

If you want to get any help, you can return to the first page (welcome page) and click to the 'Help' button.

### NOTES

------------

- As an announcement, you can open the project from CV Manager Build Launcher.

### CV Manager Engine Tools

------------

- [CV Manager Build Launcher](https://github.com/2rall7/CV-JAVA/releases/tag/untagged-cdee51e0fa716553f856) You can reach the executable file and source code of the project from this link.


### Libraries Included in the Source Code

------------

 - MAVEN

 - SQLite

 - SQLite-dll
 - SQLite-JDBC
 

### Installation

------------

- CV Manager Engine git repository

> *1. Initialize git in your directory.*

git init

> *2. Clone CV Manager*

git clone https://github.com/2rall7/CV-JAVA

> *3. You can also clone recursively, this will download all the submodules if there exists any along with CV Manager source code.*

git clone --recursive https://github.com/2rall7/CV-JAVA

- You can generate project files and build using: CV Manager Build Launcher, JavaFX GUI or JavaFX

### Using CV Manager Build Launcher

------------

- Download a binary release from CV Manager Build Launcher Repository.

- Run the .jar file, launcher will open.

- Select the directory where you downloaded CV Manager's source. (this repository)

- Select your desired build directory for project files.

- Select your target generator & desired build options.

- Hit "Generate Project Files" to generate only the project files, hit "Generate and Build" to generate project files and then build the binaries using the generated files.

------------

- After generating project files, you can either open your IDE and build the ALL_BUILD project which will build all the targets.

> 1. *Create a directory for binaries*

mkdir bin

> 2. *Navigate to directory*

cd bin

> 3. Build the root project

cmake --build ../

##### Using JavaFX GUI

- Choose the directory where the repository is as the source directory.

- Choose a build directory, this can be the same as the source directory or anywhere you like.

- Hit configure, select the IDE you want to generate the project files for.

- Select options, you can leave them as default.

- Select generate, this will generate the project files for your desired IDE.

##### After project file generation

- After generating files, as mentioned above, you can either build from CV Manager Build Launcher, your operating system's shell or from your IDE.

- If you choose to build from your IDE, run the project file generated in the root directory

- Run the project file located in the root directory (or in the root of your output project file directory if you have specified one), CV Manager.*

### Run

------------

- You can run through debugger in your IDE which is attached.

### License

------------

[License Apache](http://opensource.org/licenses/Apache-2.0 "License Apache")

### Notes

------------

#### Design Document

[Link to Design Document](https://docs.google.com/document/d/1jNLg8rkK5mhhv64I0uMcwYcxC5Do2Yc-qCu1EmMGR8s/edit)

[Link to Requirements Document (SRS)](https://docs.google.com/document/d/1vY3T0a8HVWax_Lw3mKZc8aCILwyaChy4JmUNIxh7O_c/edit)

