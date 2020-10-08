# Folder Project

We usually encounter a lot of unncessary troubles when dealing with folders with a lot of subfolders in our lives, 
so this project will facilitate this process and provide the users with a lot of functions that could save them time and effort.

> Some of the functions to include 

1. Drag out all of the files with the same ending (ex. ".txt", ".java") from a folder (including from the subfolders within the folder) and place them in the location the user wants

2. When there are two files with the same name in the folder, rename them with different suffixes to distinguish them. 

3. Generalize the [Dropfolder](https://github.com/yxie21/library/blob/master/DropFolder.java) to make it
    a. able to be executed in folders with more than two layers of subfolders
    b. compatible on all devices (Mac, Windows, Linux)

4. Add all of the tags of individual files in a folder to the folder itself.
5.

### Week One: 
1.  [Dropfolder](https://github.com/yxie21/library/blob/master/DropFolder.java)

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

