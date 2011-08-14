package elevator

import grails.test.*
import elevator.Elevator

class ElevatorTests extends GroovyTestCase {

    def elevator

    protected void setUp() {
        super.setUp()
        
        elevator = new Elevator()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testAllWayUpAndAllWayDown() {
        
        assertTrue(elevator.changeStateTo("second"))
        assertTrue(elevator.changeStateTo("third"))
        assertTrue(elevator.changeStateTo("fourth"))
        assertTrue(elevator.changeStateTo("third"))
        assertTrue(elevator.changeStateTo("second"))
        assertTrue(elevator.changeStateTo("ground"))
        
    }
    
    void testGoToUnexistentState(){
        assertTrue(!elevator.changeStateTo("xxxyyyzzz"))
    }

    void testCantGoFromGroundToFourth(){
        assertTrue(!elevator.changeStateTo("fourth"))
    }

}
