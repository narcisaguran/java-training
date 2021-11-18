class Motor {
	public void spin(){
		System.out.println("the rotor is spinning");
	}
}

class Wheel {
	public void moveCar(){
		System.out.println("the wheel moves the car in a certain direction");
	}
}

class TransmissionBeltAdapter extends Wheel {
	Motor motor;
	public TransmissionBeltAdapter(Motor motor){
		// reference to the object we are adapting (i.e. the motor)
		this.motor = motor;
	}

	public void moveCar () {
		motor.spin();
	}
}

class Main
{
    public static void main(String args[])
    {
        Motor motor = new Motor();
        Wheel wheel = new Wheel();
  
        Wheel transmissionBeltAdapter = new TransmissionBeltAdapter(motor);
  
        motor.spin();
        wheel.moveCar();
  		// the adapter will do the same thing as the motor, it will spin the wheel
  		System.out.println("The transmission belt will transfer the energy of the motor to the wheel while");
        transmissionBeltAdapter.moveCar();
    }
}