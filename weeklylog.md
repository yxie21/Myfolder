

### Week One: 
1.  

We start off with a simple scenario,

- ##### Context:

In the folder "folder," you enter two more levels of subfolders before being able to reach individual files ending with ".txt"

- ##### Goal:

Drag out all of the files ending with txt to the big folder. 

2. [Dropfolder.2]

- ##### Problem:

Right now, the line putting in the *folderpath* and the *document ending (.txt)* are hard codes.
When other people want to run it, they have to change these two configurations. In order to do so,
they have to use Eclipse. However, for the average users with zero programming experience, this could be
a very difficult task (also for users without programming software). 

- ##### Change made:

Therefore, I used *config.txt* to save all of the configurations and used HashMap (keys and values) to read the input configurations.
In this way, the users simply have to change the configurations in the txt file, which is easy for everyone.

- ##### An additional change:

By getting the location of config.txt in the first few lines of code through the relative path, users no longer have to worry about the exact location of the file. 


- ##### why use map?

###### 1. Retrieving values from the input key is very convenient.
###### 2. When there are a lot of configurations later on, map can be very time-efficient (changing O(N) to O(1)).



### Week Two:

1. 

- ##### Context:

Sometimes, when users move the files around, it is easy to cause confusion and delete some important files during the process.

- ##### Goal:

Generate report for the original folder and the folder after the user does some manipulations on it to check if they are consistent (if there
are important files missing)

- ##### Special feature

To distinguish among the reports generated at different times, the output file includes the exact time at which the report is created. 

