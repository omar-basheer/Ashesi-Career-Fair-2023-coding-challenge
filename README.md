# Ashesi Career Fair 2023 coding challenge


## Problem I
You are given a list of points that represent the 2D coordinates of the terrain where a person is located during an earthquake. Each point represents
a location that is unsafe during an earthquake, such as next to a multi-storey building or a power grid. The task is to find a safe location where a 
person can wait out the earthquake. A safe location can be identified as the middle of a large triangle of empty space, where the vertices of the 
triangle are three points among those given. You are tasked with finding the largest triangle of empty space given the list of unsafe points.
For example: Given the five points (0.5, 0.5), (1, 3.5), (2,3) (3, 0.5) and (3, 4), we can form several triangles of open space, as shown with the 
red lines in the figure below. The largest such triangle is shaded blue.

<insert image>

Building on this, your next task will be to combine triangles to form the largest convex polygon of empty space, as shown by the shaded area 
in the figure below.

<insert image>


## Problem II
An earthquake has hit a city, and a person is trapped amidst the debris. You have access to the coordinates of several points in the area via a points.csv 
file which will be passed as a command line argument, and you need to find the smallest triangle that can be formed by three of these points such that
the person is inside the triangle, and the area of the triangle does not contain any other points. You need to find the vertices of this triangle and 
write them to a safesurrounding.csv file. The first point in the input points.csv file represents the location of the person.
Consequently, you need to implement a FindSafeSurrounding program. If there exists an empty triangle containing the person, write the vertices of the 
smallest empty triangle to the safesurrounding CSV file. The points should be arranged in increasing order of x-coordinates then y-coordinates. If multiple
triangles have the same largest area, return any one of them. If no such triangle exists, return the two closest points to the person. Again, if 
there is a tie you may return any of them.
