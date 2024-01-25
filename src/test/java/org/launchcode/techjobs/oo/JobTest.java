package org.launchcode.techjobs.oo;

import static org.junit.Assert.*;

import org.junit.Test;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job test1 = new Job();
        Job test2 = new Job();
        System.out.println(test1.getId() + test2.getId());
        assertNotEquals(test1.getId(), test2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //test that constructor assigns both class and value for each field
        assertNotNull("name is not null", test1.getName());
        assertTrue("employer is instance of Employer", test1.getEmployer() instanceof Employer);
        assertTrue("location is instance of Location", test1.getLocation() instanceof Location);
        assertTrue("positionType is instance of PositionType", test1.getPositionType() instanceof PositionType);
        assertTrue("coreCompetency is an instance of CoreCompetency", test1.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("employer value is expected value", "ACME", test1.getEmployer().toString());
        assertEquals("location value is expected value", "Desert", test1.getLocation().toString());
        assertEquals("positionType value is expected value", "Quality control", test1.getPositionType().toString());
        assertEquals("coreCompetency value is expected value", "Persistence", test1.getCoreCompetency().toString());
        assertEquals("name value is expected value", "Product tester", test1.getName());
    }
    @Test
    public void testJobsForEquality () {
        Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        boolean result = test1.equals(test2);

        assertFalse("", result);
    }
    @Test
    public void testJobToStringFormatIsCorrect () {
        Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency(""));
        String result = test1.toString();
        String lb = System.lineSeparator();
        String expected = lb +
                "ID: " + test1.getId() + lb +
                "Name: Product tester" + lb +
                "Employer: ACME" + lb +
                "Location: Desert" + lb +
                "Position Type: Quality control" + lb +
                "Core Competency: Data not available" + lb;
        assertEquals("Job.toString() formats properly", expected, result);
        assertEquals("Blank field in constructor has 'Data not available' as value", "Data not available",
                test1.getCoreCompetency().getValue());


    }
}
