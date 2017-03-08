package hellocucumber;

public class MyCucumber {

	public String hello(String name) {
		return "Hello "+name;
	}

	public String introduceYourself(String name) {
		return "Ok "+name+", let's go.\n"+
		"I'm a library for automating scenario validation.\n"+
		"And a vegetable too !!";
	}

}
