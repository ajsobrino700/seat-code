## Seat Code Challenge

This is a little project to solve the kata challenge.
The technology which I have chosen are:

1. Java
2. Maven

Also, I use some dependencies of java for simplify my solution.

My solution is with an input through keyboard, then it is necessary to introduce **ctrl+d** to finish the input stage.

The program will read each line and generate the stage of plateu and mower with this information. Then the program will execute the orders in each Mower sequential way.

The project has maven then is very easy to compile the program.
You can use the common maven command.
For example, we can compile with the follow:
<pre>
    mvn -U clean package
</pre>

We can run very easy, because it is a void main, then if we want to run, previously we have to compile and generate the file **\*.jar**. So we have this file we need to run the .jar
<pre>
    java -jar seat-code-1.0.0.jar
</pre>