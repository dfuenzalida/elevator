package elevator

class ElevateController {

    def index = {
    
        // remove any old elevator instance
        // Elevator.findAll().each { it.delete() }
        
        // Create and save a new instance
        // Elevator elevator = new Elevator()
        // elevator.save()
        
        def elevators = Elevator.findAll()
    
        [elevators: elevators]
    }
    
    def create = {
        Elevator elevator = new Elevator()
        elevator.save()
    
        redirect(action: index)
    }
    
    // Move an elevator to the second floor
    def move = {
        def elevator = Elevator.get(new Integer(params.id))
        elevator.changeStateTo(params.to)
        redirect(action: index)
    }
    
    def delete = {
        def elevator = Elevator.get(new Integer(params.id))
        elevator.delete()
        redirect(action: index)
    }
}
