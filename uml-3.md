```puml
@startuml
skinparam classAttributeIconSize 0
class "Application" {
    {static} + main(args : String[]) : void
}

interface "Back" {
    + raiseBack() : void
    + lowerBack() : void
}

abstract class "Car" {
    - movement : Movement
    
    + startEngine() : void
    + stopEngine() : void
}

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
    ~ vehicleImages : HashMap<Vehicle, BufferedImage>
    ~ vehiclePoints : HashMap<BufferedImage, Point>
    
    ~ moveit(x : int, y : int, index : int) : void
    # paintComponent(g : Graphics) : void
    + addVehicle(Vehicle vehicle, BufferedImage image) : void
    + removeVehicle(Vehicle vehicle) : void
}

interface "Engine" {
    + startEngine() : void
    + stopEngine() : void
    + gas() : void
    + brake() : void
}

interface "HasName" {
    + getName() : String
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
    + updateMovement() : void
    + addVehicle() : void
    + removeVehicle() : void
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
    - modelName : String
    
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
class "Vehicle<T extends Movable & Engine & HasName>" {
    + vehicle : T
    
    + move() : void
    + turnLeft() : void
    + turnRight() : void
    + gas() : void
    + break () : void
    
}

class "VehicleController" {
    ~ vehicles : Stack<Vehicles>
    - timer : Timer
    ~ various buttons : JButton
    
    
    ~ gas(amount : int) : void
    ~ brake(amount : int) : void
    + createFrameWithButtons() : JFrame
}



class "VehicleView" {
    {static} - X : int
    {static} - Y : int
    /' ~ vehicleC : VehicleController '/
    ~ frame : JFrame
    ~ DrawPanel : drawPanel
    
    - initComponents(String title) : void
    + updateMovement(double x, double y, Vehicle vehicles) : void
    + addVehicle(Vehicle vehicle) : void
    + removeVehicle(Vehicle vehicle) : void
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

Back <|.. Scania

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
Engine <.. "Vehicle<T extends Movable & Engine & HasName>"

HasName <|.. Car
HasName <|.. Scania
HasName <.. "Vehicle<T extends Movable & Engine & HasName>"

Movable <|.. CarStack
Movable <|.. MercedesCarTransport
Movable <|.. Movement
Movable <|.. Scania
Movable <.. "Vehicle<T extends Movable & Engine & HasName>"

Movement <-- Car
Movement <-- Truck

MovementListener <-- VehicleController
MovementListener <|.. VehicleView

Truck <-- Scania
Truck <-- MercedesCarTransport

"Vehicle<T extends Movable & Engine & HasName>" <-- VehicleController
/' "Vehicle<T extends Movable & Engine>" <-- DrawPanel '/
"Vehicle<T extends Movable & Engine & HasName>" <-- Application
"Vehicle<T extends Movable & Engine & HasName>" <.. VehicleView

VehicleController <-- Application
/' VehicleController <-- VehicleView '/

VehicleView <-- Application
/' VehicleView <-- VehicleController '/

@enduml