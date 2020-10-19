# Folder Project

### Objective: 
We usually encounter a lot of unncessary troubles when dealing with folders with a lot of subfolders in our lives, so this Java project saves users time and effort when dealing with files in folders. 

### Functions: 

1. Drag out all of the files with the same ending (ex. ".txt", ".java") from a folder (including from the subfolders within the folder) and place them under the main folder 

2. Generate reports of the original folder and the modified folder for users to check if there is any error in the process of moving files around. 

3. Simplify the path length. Sometimes, a file is under a chain of subfolders (ex. subfolder A-- subfolder B--- subfolder C--- file). Delete the unnecessary subfolders and shorten the pathlength to get the file. 

4. The program can be generalized to any amount of subfolders now (an improvement from before)

5. Convert all of the jpg files to png files automatically. (similar conversion can happen for other such changes)

6. Users now have two options
##### - if grouptogether=yes, then files of different suffixes would be grouped together and placed in newly created folders (using their suffix) under the main folder 
##### - if grouptogether=no, then all of the indiviual files would simply be placed under the main folder. 


##### Functions to Develop 

4. When there are two files with the same name in the folder, rename them with different suffixes to distinguish them. 

5. Generalize the [Dropfolder](https://github.com/yxie21/library/blob/master/DropFolder.java) to make it
    a. able to be executed in folders with more than two layers of subfolders
    b. compatible on all devices (Mac, Windows, Linux)

