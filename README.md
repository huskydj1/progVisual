## Program Visualizer (progVisual)
[![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-v2.0%20adopted-ff69b4.svg)](code_of_conduct.md)

<p float="left">
  <img src="https://github.com/huskydj1/progVisual/blob/master/progVisual_demonstration.gif" width="300" height="225">
  <code Hello>
</p>


~~~
mainWindow window = new mainWindow();

ArrayListVisual<Integer> iList = new ArrayListVisual<Integer>("Integer list");
iList.add(120);
iList.add(2);
iList.add(154523);
iList.add(214);
iList.removeIndex(2);
window.addTab(iList);

ArrayListVisual<String> sList = new ArrayListVisual<String>("String list");
sList.add("Hello ");
sList.add("My name ");
sList.add(" is ");
sList.removeIndex(2);
window.addTab(sList);

window.visual();
~~~)



**A Java library that visualizes modifications to stored data-structures, making it easier for programmers to run, debug, and understand their code. It is currently only compatible with  ArrayLists, but more is on the way.**

**Please note that this project is released with the [Contributor Covenant Code of Conduct](https://github.com/huskydj1/progVisual/blob/master/CODE_OF_CONDUCT.md). By participating in this project you agree to abide by its terms. Our code of conduct was put in place to create an inclusive, welcoming community of developers. If a participant engages in unacceptable behavior, maintainers may take any action they deem appropriate, including warning of the offender or a permanant ban from this repository.**

### Table of Contents
- [Guide](#Guide)
- [Features](#Completed-Features)
- [Resources](#Resources)
- [Contributing](#Contributing)
- [Feedback](#Feedback)


### Guide

- #### Installation
You can use this library by making a local copy on your device!
#### 1) Open your terminal with git
If you don't have git installed, here are [instructions](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) for getting started on different operating systems.
#### 2) Make a clone of the repository
Navigate to the folder wherein you want to make a copy of this repository using your terminal. Paste or type ```git clone https://github.com/huskydj1/progVisual.git```.
- #### Application/Use
##### 1) Navigate to the subfolder
Enter your copy of ```progVisual``` and navigate to the subfolder under ```src```, ```main```, and then ```java```. You will find the classes of this library. These can be copied, by file or by code, into your work when you need.
##### 2) Necessary classes
You will need to have ```DrawArray.java```, ```DrawArraySize.java```, and ```mainWindow.java``` in the package you wish to use this library in. The other observer classes for various data-structures can be chosen based on your needs.
##### 3) Using the observer classes

Let's imagine that you chose to use ```ArrayListVisual.java```, which simulates an ArrayList. Copy the class into your current package and replace all instances of "ArrayList" with "ArrayListVisual" in the program(s) you wish to visualize. Your code should operate the same as before, except our observer ```ArrayListVisual``` class is now observing all of the modifications made to each instance.

  Create an instance of "mainWindow.java" at the beginning of the program. Then, insert all ArrayListVisual variables whose history you would like to print at the end of the program using method ```addTab(ArrayListVisual list)```. Finally, print the list of observed instances using ```viewList``` and the history of their modifications using method ```visual```.

   We did our best to make the class compatible with  ArrayList's operations. If something is not working, please look under the documentation to understand discrepancies. You can also [leave feedback](#Feedback), if you wish!


### Completed Features
<details open>
<summary>Click to Close/Expand</summary>
<p>

- DrawArray:
  - Visualize any 1D data structure
  - Parameterize specific components to allow flexibility
  - Generic Type
- Observers:
  - ArrayList
- mainWindow
  - Tabs
  - Scrollable
    - DrawArraySize.java
  - add tabs/variables

</p>
</details>  

### Features in Progress
<details open>
<summary>Click to Close/Expand</summary>
<p>

- Add wrapper methods for rest of features to observe changes
     - Stack
     - Deque
     - Queue
     - ArrayList

</p>
</details>

### Future Features
<details open>
<summary>Click to Close/Expand</summary>
<p>

- Graphs
  - Adjacency matrices and lists
  - Arranging them as trees, undirected/directed, etc)

</p>
</details>


### Resources
##### Helpful resources used to create this library
- ["How to Write a Git Commit Message" - Chris Beams](https://chris.beams.io/posts/git-commit/#imperative)
- [Choose an open source license](https://choosealicense.com/)
- Developing new Java Libraries:
  - ["How can I develop my own Java Library? [closed] - stackoverflow](https://stackoverflow.com/questions/6496597/how-can-i-develop-my-own-java-library)
- Graphics Tutorials:
  - [Isay Katsman](https://www.youtube.com/results?search_query=isay+katsman+java+graphics&ab_channel=thenewboston)
  - [Bucky's "Drawing Graphics"](https://www.youtube.com/watch?v=2l5-5PMUc5Y&ab_channel=thenewboston)
  - [Bucky's "JColorChooser"](https://www.youtube.com/watch?v=052U-bWEXrk&ab_channel=thenewboston)
  - [Bucky's "Drawing More Stuff"](https://www.youtube.com/watch?v=OWOeE90ET6w&list=PLFE2CE09D83EE3E28&index=86&ab_channel=thenewboston)
- Generics:
  - https://www.softwaretestinghelp.com/java-generic-array/
- Java Observers:
  - https://www.baeldung.com/java-observer-pattern
- GUI Details:
  - Java Documentation Tutorials:
    - ["How to Use Tabbed Panes"](https://docs.oracle.com/javase/tutorial/uiswing/components/tabbedpane.html)
    - ["Class JTabbedPane"](https://docs.oracle.com/javase/7/docs/api/javax/swing/JTabbedPane.html)
    - ["How to Use Scroll Panes"](https://docs.oracle.com/javase/tutorial/uiswing/components/scrollpane.html)
    - ["The JComponent Class"](https://docs.oracle.com/javase/tutorial/uiswing/components/jcomponent.html)
    - ["java.awt - Class Graphics"](https://docs.oracle.com/javase/6/docs/api/java/awt/Graphics.html)
    - []
  - [Keep on Coding's "Java Generics Tutorial"](https://www.youtube.com/watch?v=h7piyWnQbZA&ab_channel=KeepOnCoding)
  - [Bucky's "Generic Return Types"](https://www.youtube.com/watch?v=QB5pQT45zvg&list=PL27BCE863B6A864E3&index=19&ab_channel=thenewboston)

### Contributing
Contributions are always welcome! Please refer to [CONTRIBUTING.md](https://github.com/huskydj1/progVisual/blob/master/CONTRIBUTING.md) to understand how you can help! Please keep in mind that our [Code of Conduct](https://github.com/huskydj1/progVisual/blob/master/CODE_OF_CONDUCT.md) outlines the standards users should uphold while interacting with the library.

### Feedback
#### All comments, questions, and ideas are appreciated!

You can reach us through [our contact form!](https://docs.google.com/forms/d/e/1FAIpQLSc_xLESmhYyBImdq7zi3NQ_zh7jUOZvVgxZ3rRdQYkt7x_YcA/viewform?usp=sf_link) Alternatively, you can make pull requests with your suggestions, ideas, or questions below, so that other users may be able to see our response.

#### Suggestions and Ideas

<details>
<summary>Click to Expand</summary>
<p>

- I don't know how possible this is, but it would be really cool if you could edit the arrays and array lists by messing with the graphic created.  From what I remember, I think that would be pretty difficult.  
    - What I mean by this is that you could switch around the order of an array by moving around elements, add elements to array lists, etc.  I'm kind of excited about your project, in that I really want to use it!  
- I really like how you can piggyback off of an array to make the arraylist - do you think you could do the same thing but in the opposite direction? (Array-list -> array).
- Is something like this what you are envisioning? http://www1.cs.columbia.edu/~bert/courses/3137/hw3_files/GraphDraw.java
- **Thank you [llee4](https://github.com/llee4) for adding your ideas! We'll look into them and update the [Features section](#Completed-Features) with the ones we'd like to pursue! - progVisual team**.

</p>
</details>

#### Questions
<details>
<summary>Click to Expand</summary>
<p>

[Currently Empty]

</p>
</details>
