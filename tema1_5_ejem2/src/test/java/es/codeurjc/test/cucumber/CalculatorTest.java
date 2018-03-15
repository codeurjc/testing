package es.codeurjc.test.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
  plugin = {"pretty"}, 
  features = { "classpath:es/codeurjc/test/cucumber" },
  glue = {"es.codeurjc.test.cucumber" })
public class CalculatorTest {}