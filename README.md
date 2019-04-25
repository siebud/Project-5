# Project-5
![Project 5 UML](https://user-images.githubusercontent.com/47228136/56763297-a8098780-6767-11e9-8c20-5aef031df99d.png)

I began my code based on two classes, the Frame class and the Panel class. I knew from previous projects and labs that
most of my coding would be done in th Frame class. At this point I simply created the first half of the required 
components. After that I made a layoutManager and added them all to a panel. I then created the second half of the
required components and added those as well. At this point I added the first panel to the frame and did tests until 
I got the formatting right. 
After this I knew it looked right but did not function. My next step was to add the functionality. I began with the
easiest things, which were buttons and selectors whose action listeners only set a variable equal to their input value. 
This was relatively wuick, and I then moved on to the more complicated buttons. I knew that I would have to calculate the
hamming distance eventually, so I created a new class called Comparison to do that, using code from my previous projects as a basis.
I ren into quite a lot of trouble dealing with IO errors but eventually ironed them out. The compare class would create all 
of the information that I would eventually neeed to call into my components in the frame class, so after implementing the 
calculation code, I had to make getters or each of the variable parts that I had created. By now it was trial and error in terms
of figuring out how to make the program run correctly, but eventuually with some research into API's it was alright.
After that I went about trying to figure out the creativity section. Because all of the Mesonet ID's are station names, it reminded me 
of train maps and locations, which inspired me to do a calculation for travel time, as I am almost always late. This works by selecting
a method and inputting a distnce to calculate how long it would take that transportation to travel that distance.
Then After that was successful I turned toward part of the extra credit, which was about how to ensure there were no repilcas in the
list of names to choose from. I did this by creating an entirely new ArrayList for the names that had been added to the box, which
was much easier to check in to see if there were duplicates.

HeyFrame Class:
This class has two important objects, which are the two panels. panel1 holds all of the components for the required implementation, whicle panel2 holds all the components for the creative section.
HeyFrame() constructor does most of the heavy lifting, with no parameters it creates and places all of the GUI components as well as adding and implementing the methods for actionListeners in nested classes. 
the panel2Stuff() method creates and places all of the creative side GUI components and places them into a second panel, which is added to the frame in HeyFrame(). It also defines the actionListeners for its side's components.
The main method only does one thing which is creating an object of HeyFrame.

HeyPanel
HeyPanel() constuctor has no other implementation, and only serves as a placeholder for possibly adding other creative features to my panels.

Comparison
This class has many variables. zerod, ones, twos, threes, fours each are in integer counting how many Stations from Mesonet are that distance away from the comparison String. zer, one, two, three, and four are all ArrayLists to hold all of the strings of their respective distances away from the comparison string. all is an ArrayList holding all of the names in the Mesonet file.
Comparison(String) is a constructor with a parameter of the string that the rest will be compared to.  It reads from the text file, calls a method to calculate individual hamming distances, and then adds those strings to their respective lists and adds the respective amounts to each int. 
getHammingDistance takes two Strings as its parameters, and then calculates the hamming disdtance between them, returning it as an int. It does this by iterating through each character in the String and counting when they are not the same.
getZeros returns the number of Strings distance zero from the comparison string as an int.
getOnes returns the number of Strings distance one from the comparison string as an int.
getTwos returns the number of Strings distance two from the comparison string as an int.
getThrees returns the number of Strings distance three from the comparison string as an int.
getFours returns the number of Strings distance four from the comparison string as an int.
getNames takes an int as a parameter, which would be the hamming distance that the user wants to be shown. It then returns the corresponding ArrayList.
getNamesList returns a String[] of all of the names from the text file.
