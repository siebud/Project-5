# Project-5
![Project 5 UML](https://user-images.githubusercontent.com/47228136/56721647-f2105000-670a-11e9-9d0b-936d209f030b.png)

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
