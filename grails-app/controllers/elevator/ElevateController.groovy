package elevator

class ElevateController {

    def index = {
    
        // remove any old elevator instance
        Elevator.findAll().each { it.delete() }
        
        // Create and save a new instance
        Elevator elevator = new Elevator()
        elevator.save()
    
        [elevator: elevator]
    }
}
