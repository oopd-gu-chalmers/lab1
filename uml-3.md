```puml
@startuml

class "Application" {
    {static} + main(args : String[]) : void
}

abstract class "Car" {
    - movement : Movement
    
    + startEngine() : void
    + stopEngine() : void
}
skinparam classAttributeIconSize 0
class "CarStack" {
    - maxCars : int
    - maxDoors : int

    + addCar(car : Car) : void
    + removeCar() : Car
    + getNrOfLoadedCars() : int
    + isCarLoaded(car : Car) : boolean
}

class "DrawPanel" {
    /' ~ vehicles : ArrayList<Vehicle> '/
    ~ images : ArrayList<BufferedImage>
    ~ vehiclePoints : ArrayList<Point>

    ~ moveit(x : int, y : int, index : int) : void
    # paintComponent(g : Graphics) : void
}

interface "Engine" {
    + startEngine() : void
    + stopEngine() : void
    + gas() : void
    + brake() : void
}

class "MercedesCarTransport" {
    - cars : Carstack
    - truck : Truck
    
    + addCar(car : Car) : void
    + removeCar() : Car
    + raiseBack() : void
    + lowerBack() : void
    + move() : void
    + turnLeft() : void
    + turnRight() : void
}

interface "Movable" {
    + move() : void
    + turnLeft() : void
    + turnRight() : void
}

class "Movement" {
    + position : double[]
    + direction : double[]
    
    + move() : void
    + turnLeft() : void
    + turnRight() : void
}

interface "MovementListener" {
    + update() : void
}

class "Saab95" {
    # turboOn : boolean
    
    + setTurboOn() : void
    + setTurboOff() : void
    + speedFactor() : double 
}

class "Scania" {
    - tilt : double
    - truck : Truck
    
    + raiseBack() : void
    + raiseBack(amount : double) : void
    + lowerBack() : void
    + lowerBack(amount : double) : void
}

class "Truck" {
    # backIsClosed : boolean
    - movement : Movement
    
    + speedFactor() : double
    {abstract} + raiseBack() : void
    {abstract} + lowerBack() : void
    + startEngine() : void
    + stopEngine() : void
    + gas() : void
}
/'
class "Vehicle" {
    # nrDoors : int
    # enginePower : double
    # currentSpeed : double
    # color : Color
    # modelName : String
    
    {abstract} + speedFactor() : double
    # incrementSpeed(amount : double) : void
    # decrementSpeed(amount : double) : void
    + gas(amount : double) : void
    + brake(amount : double) : void
}
'/
class "Vehicle<T extends Movable & Engine>" {
    + vehicle : T
    
    + move() : void
    + turnLeft() : void
    + turnRight() : void
    + gas() : void
    + break () : void
    
}

class "VehicleController" {
    ~ frame : VehicleView
    ~ vehicles : ArrayList<Vehicle>
    

    ~ gas(amount : int) : void
    ~ brake(amount : int) : void
}



class "VehicleView" {
    {static} - X : int
    {static} - Y : int
    /' ~ vehicleC : VehicleController '/
    ~ DrawPanel : drawPanel
    
    - initComponents(String title) : void
    + addListener(ActionListener listener) : void
    + update(double x, double y, Vehicle vehicles) : void
}

class "Volvo240" {
    {static} # trimFactor : double
    - car : Car
    
    + speedFactor() : double
}

class "Workshop<CarBrand>" {
    - maxCars : int
    + cars : Vector<CarBrand>
    
    + addCar(car : CarBrand) : void
    + removeCar(car : CarBrand) : void
}

Car <|-- Saab95
Car <|-- Volvo240
Car <.. CarStack
Car <.. MercedesCarTransport
Car <.. "Workshop<CarBrand>"

CarStack <-- MercedesCarTransport

DrawPanel <-- VehicleView

Engine <|.. Car
Engine <|.. Truck
Engine <|.. Scania
Engine <|.. MercedesCarTransport
Engine <|.. "Vehicle<T extends Movable & Engine>"

Movable <|.. CarStack
Movable <|.. Movement
Movable <|.. Scania
Movable <|.. MercedesCarTransport
Movable <.. "Vehicle<T extends Movable & Engine>"

Movement <-- Car
Movement <-- Truck

/' MovementListener <.. VehicleController '/
MovementListener <|.. VehicleView

Truck <-- Scania
Truck <-- MercedesCarTransport

/' "Vehicle<T extends Movable & Engine>" <.. VehicleController
"Vehicle<T extends Movable & Engine>" <-- DrawPanel '/
"Vehicle<T extends Movable & Engine>" <-- Application
"Vehicle<T extends Movable & Engine>" <.. VehicleView

VehicleController <-- Application
/' VehicleController <-- VehicleView '/

VehicleView <-- Application
/' VehicleView <-- VehicleController '/

@enduml