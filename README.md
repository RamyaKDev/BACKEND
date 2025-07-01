ConsoleBased application – courseapplication 
1.To create a Console based application we have to implements CommandlineRunner Interface in main class and override run() method in the main method.

2. In the console based application, our application starts from main method but not in web based or RestAPI’s.

3. We are having Service package in that Icourse interface is there, which has following abstract methods
    getlistofcourse()- Displays all the list of courses
    getcoursebyID()-Displays the list of course based on Id
    getcoursebyType()-Displays the list of courses based on Type
    getByLessDurationAndCost()-Displays the list of course based on less duration and cost
    getCourseName()-Displays the list of course based on Name

4. Implemented all the abstract methods in CourseServiceImpl class
   
6. Having Util package. This package has CourseUtil class which is going to have list of courses. We don’t have repository package. Instead of db we have util class which has list of courses.
   
8.  @Service and @Component both are stereotype annotations. There are no differences between them. Both create object for the class. Service layer is used to provide business logic. For easy understand and maintenance we have provide here @Service.

9.  Here Lombok dependency is used to reduce boilerplatecode. (Getter and Setter methods, Noarg Constructor, AllArg constructor, toString() Method everything is given in single line)
    
10. Created Model class with following instance variable. Here CourseID going to work through the internet to DB as a primary key. Primitive data types will not work in the internet so have to give wrapper class Object always for primary Key.
    
12. Created Exception Package under the package create ClassNotFoundException class file. Always extend RuntimeException because Spring supports unchecked Exception. And keep version ID for reference.
