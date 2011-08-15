package elevator

import gestate.*

class Elevator extends Gestate {

    def gestateService
    
    static constraints = {
    }
    
    // Simple domain class for an elevator with 4 floors
    // The floors are: Ground <-> 2nd Floor <-> 3rd Floor <-> 4th Floor
    
    static _elevatorStates = [
    
       ground:[
            verb: 'Ground', 
            destinations: [
                second:{ println "Going up from Ground to 2nd" },
            ]],
    
       second:[
            verb: '2nd floor', 
            destinations: [
                ground:{ println "Going up from 2nd to 3rd" },
                third:{ println "Going down to Ground from 2nd" },
            ]],
    
       third:[
            verb: '3rd floor', 
            destinations: [
                fourth:{ println "Going up from 3rd to 4th" },
                second:{ println "Going down from 2nd to 3rd" },
            ]],
    
       fourth:[
            verb: '4th floor', 
            destinations: [
                third:{ println "Going down from 4th to 3rd" },
            ]],
    
    ]
    
    public Elevator(){
        this._states = _elevatorStates
        this.state = _elevatorStates.collect{it.key}[0]
    }
    
    boolean changeStateTo(String state) {
        return gestateService.changeTo(this, state)
    }
    
    String toString(){ "[Elevator ${this.id} on ${state} floor]"  }
    
}
