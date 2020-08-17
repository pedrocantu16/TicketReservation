# Assignment 10

## MVC Architecture Description

**Pedro Cantu de la Garza**   
**April 14 2020**  
**CS 5004 Spr 2020**

---


### __*Model*__

Model component includes the following classes:

- ```Reservation```: This class is instantiated after a reservation is requested by ```reserve <number>``` . Containing the status and details of the reservation requested.

- ```Row```: Extends ArrayList<Seat>. Instances are created by the ```Configuration``` class every time a ```Theater``` is created. It contains a factory method ```buildRow``` to build an instance of ```Row``` .

- ```Seat```: This class represents a seat in a Theater.

- ```Theater```: Holds a Map of Rows, by default of ```Configuration``` class it has 15 ```Rows``` with 10 ```Seats```. It implements ```optimalOrder``` method to set an "optimal" order of reservation each Row if enough seats are available. Method ```reserveSeats``` is called by the ```Processor``` class when the user requests a reservation. 

### __*Controller*__

The Controller component includes the following classes/interface:
: 

- ```Configuration```: Used to instantiate the initial configurations for the application, including the Option instances that are passed to the CommandParser to validate the arguments received from the user. This class follows a singleton design pattern, so there could be only one instance created when the application starts running. 

- ```CommandParser```: Takes a collection of  concrete```IOption``` objects. Processes and validates arguments provided by the user. When called method ```parse(String args)```, it returns a concrete CommandData object. It follows singleton pattern so there could be only one instance in the program.

- ```SystemReservationExceptions```: Instantiates static nested classes based on the Exception thrown and prints the appropriate error message on the terminal based on the class instantiated. Also provides a standard usage help message for every exception type thrown. 

- ```IOption```: Interface implemented by ```Options``` classes, including ```ReserveOption```, ```ShowOption```, ```DoneOption```. Every option serves to validate the different options that the application can take from the user. Once the ```CMLParser``` has validated the options, it returns concrete ```ICommandData``` object. The ```Options``` follow singleton pattern. 

- ```ICommandData```: Interface implemented by concrete ```CommandData```  objects. They follow singleton pattern, except for ```ReserveCommandData``` which can be instantiated with different number of seats to reserve.
- ```ReservationSystem```: Contains a main method, which instantiate a Theater and pass it to ReservationService class to run the program.
- ```ReservationService``` This class is in charge of controlling the execution of the program, it has only one method ```runService```, which take a Theater as argument and acts as the client in the visitor pattern by calling ```executeCommand(Processor  processor)``` on the CommandData object returned by CommandParser. CommandData object calls method ``` processDataObject() ``` and pass itself as parameter, so the Processor knows which overloaded method to execute. It includes an inner class:
    - ```Processor``` Represents the visitor in the visitor pattern. It receives the concrete ```ICommandData``` objects from the ```ReservationService``` and executes overloaded method ```processDataObject(ICommandData command)``` method with each concrete```ICommandData``` object.
 There are three overloaded versions of ```processDataObject() ``` method, all of which return an int representing a signal to ReservationService if further action is required. Each returns a 1 if further action is needed, otherwise a 0. The three (3) types of overloaded methods are as follows:  
    
        1. ``` public int processDataObject(ReserveCommandData reserveCommand)```: Executes a new reservation requested by the user.
    
        2. ``` public int processDataObject(ShowCommandData command)```: Calls display method on DisplayTheater class, and pass a Theater as parameter. 
    
        3. ``` public int processDataObject(DoneCommandData displayObject)```: Calls display to show ByeMessage and stops the program.

### __*View*__

View component includes the following classes/interfaces: 


- ```DisplayTheater```: Implements ```IDisplay``` interface, it is in charge of displaying all the messages and view to the user. It implements overloaded method ```display()``` to display either IMessage concrete classes or Strings. Also implements ```displayTheater(Theater)``` to display a full theater when requested by the user.

- ```IMessage```: Interface represents behavior of a message that can be displayed to the terminal. Implemented by different concrete Message classes that follow singleton pattern, except for ```ReservationSuccessMessage``` which takes different arguments to build a customized message.
