```puml
@startuml
abstract class "Car"
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
    ~ vehicles : ArrayList<Vehicle>
    ~ images : ArrayList<BufferedImage>
    ~ vehiclePoints : ArrayList<Point>

    ~ moveit(x : int, y : int, index : int) : void
    # paintComponent(g : Graphics) : void
}

class "MercedesCarTransport" {
    - cars : Carstack
    
    + addCar(car : Car) : void
    + removeCar() : Car
    + raiseBack() : void
    + lowerBack : void
    + move() : void
    + turnLeft() : void
    + turnRight() : void
}

interface "Movable" {
    move() : void
    turnLeft() : void
    turnRight() : void
}

class "Saab95" {
    # turboOn : boolean
    
    + setTurboOn() : void
    + setTurboOff() : void
    + speedFactor() : double 
}

class "Scania" {
    - tilt : double
    
    + raiseBack() : void
    + raiseBack(amount : double) : void
    + lowerBack() : void
    + lowerBack(amount : double) : void
}

abstract class "Truck" {
    # backIsClosed : boolean
    
    + speedFactor() : double
    {abstract} + raiseBack() : void
    {abstract} + lowerBack() : void
    + gas() : void
}

abstract class "Vehicle" {
    # position : double[]
    # direction : double[]
    # nrDoors : int
    # enginePower : double
    # currentSpeed : double
    # color : Color
    # modelName : String
    
    + startEngine() : void
    + stopEngine() : void
    {abstract} + speedFactor() : double
    # incrementSpeed(amount : double) : void
    # decrementSpeed(amount : double) : void
    + gas(amount : double) : void
    + brake(amount : double) : void
    + move() : void
    + turnLeft() : void
    + turnRight() : void
}

class "VehicleController" {
    ~ frame : VehicleView
    ~ vehicles : ArrayList<Vehicle>
    
    {static} + main(args : String[]) : void
    ~ gas(amount : int) : void
    ~ brake(amount : int) : void
}

class "VehicleView" {
    {static} - X : int
    {static} - Y : int
    ~ vehicleC : VehicleController
    ~ DrawPanel : drawPanel
    
    - initComponents(String title) : void
}

class "Volvo240" {
    {static} # trimFactor : double
    
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

Movable <|.. CarStack
Movable <|.. Vehicle

Truck <|-- Scania
Truck <|-- MercedesCarTransport

Vehicle <|-- Car
Vehicle <|-- Truck
Vehicle <.. DrawPanel
Vehicle <.. VehicleView
Vehicle <.. VehicleController

VehicleController <-- VehicleView

VehicleView <-- VehicleController
@enduml