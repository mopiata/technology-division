package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SectionTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Section.clearAllSections();
    }

    public Section addNewSection(){
        return new Section("CNE");
    }

    public Section addOtherSection(){
        return new Section("RNO");
    }

    @Test
    public void clearAllSections_clearsSections_true() {
        Section section=addNewSection();
        Section otherSection=addOtherSection();

        Section.clearAllSections();

        assertEquals(0,Section.getInstances().size());
    }

    @Test
    public void sectionCreatesCorrectly_true() {
        Section section=addNewSection();
        assertTrue(section instanceof Section);
    }

    @Test
    public void getName_returnsSectionName_true() {
        Section section=addNewSection();
        assertEquals("CNE",section.getSection());
    }

    @Test
    public void getInstances_returnsAllSections_true() {
        Section section=addNewSection();
        Section otherSection=addOtherSection();

        assertEquals(2,Section.getInstances().size());
    }

    @Test
    public void arrayContainsAllInstances_true() {
        Section section=addNewSection();
        Section otherSection=addOtherSection();

        assertTrue(Section.getInstances().contains(section));
        assertTrue(Section.getInstances().contains(otherSection));

    }

    @Test
    public void idSetCorrectly_true() {
        Section section=addNewSection();
        Section otherSection=addOtherSection();

        assertEquals(2,otherSection.getId());
    }

    @Test
    public void setName_nameSettingWorksCorrectly_true() {
        Section section=addNewSection();

        section.setSectionName("Transmission");

        assertEquals("Transmission",section.getSection());
    }
}