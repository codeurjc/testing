package es.codeurjc.test.cucumber;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ComplexAddRunSteps {
 
    private Complex number;
	private Complex result;
	
	private double real;
	private double img;
 
    @Given("^\\((\\d+)\\+(\\d+)i\\)$")
    public void givenNumber(int real, int img) throws Throwable {
        number = new Complex(real, img);
    }
     
    @When("^is added to \\((\\d+)\\+(\\d+)i\\)$")
    public void isAddedToNumber(int real, int img) throws Throwable {
        result = number.add(new Complex(real, img));
    }
    
    @Then("^\\((\\d+)\\+(\\d+)i\\) is obtained$")
    public void isObtained(int real, int img) throws Throwable {
        assertThat(new Complex(real, img), equalTo(result));      
    }
    
    @When("^parts are requested$")
    public void parts_are_requested() throws Throwable {
    	real = number.getRealPart();
    	img = number.getImaginaryPart();
    }

    @Then("^real part is (\\d+)$")
    public void real_part_is(double real) throws Throwable {
        assertThat(this.real, equalTo(real));
    }

    @Then("^imaginary part is (\\d+)$")
    public void imaginary_part_is(double img) throws Throwable {
    	assertThat(this.img, equalTo(img));
    }
}