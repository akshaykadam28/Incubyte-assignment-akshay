package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resource/features" ,
                 glue= {"stepdefinations","hooks"},
                 plugin= {"pretty","html:target/CucumberReport/CucumberReport.html"})
public class MyRunner {

}
