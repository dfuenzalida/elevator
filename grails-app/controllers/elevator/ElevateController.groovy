package elevator

class ElevateController {

    def index = {
        def elevators = Elevator.findAll()
        [elevators: elevators]
    }
    
    def create = {
        Elevator elevator = new Elevator()
        elevator.save()
        redirect(action: index)
    }
    
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
