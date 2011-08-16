import elevator.*

class BootStrap {

    def init = { servletContext ->
    
        Elevator elevator = new Elevator()
        elevator.save()
    
    }
    
    def destroy = {
    }
}
