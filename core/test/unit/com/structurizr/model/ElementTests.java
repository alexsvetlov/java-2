package com.structurizr.model;

import com.structurizr.Workspace;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElementTests {

    private Element element = new Workspace("", "").getModel().addSoftwareSystem(Location.Internal, "Name", "Description");

    @Test
    public void test_getTags_WhenThereAreNoTags() {
        assertEquals("softwareSystem", element.getTags());
    }

    @Test
    public void test_getTags_ReturnsTheListOfTags_WhenThereAreSomeTags() {
        element.addTags("tag1", "tag2", "tag3");
        assertEquals("softwareSystem,tag1,tag2,tag3", element.getTags());
    }

    @Test
    public void test_setTags_DoesNotDoAnything_WhenPassedNull() {
        element.setTags(null);
        assertEquals("softwareSystem", element.getTags());
    }

    @Test
    public void test_addTags_DoesNotDoAnything_WhenPassedNull() {
        element.addTags(null);
        assertEquals("softwareSystem", element.getTags());

        element.addTags(null, null, null);
        assertEquals("softwareSystem", element.getTags());
    }

    @Test
    public void test_addTags_AddsTags_WhenPassedSomeTags() {
        element.addTags(null, "tag1", null, "tag2");
        assertEquals("softwareSystem,tag1,tag2", element.getTags());
    }

}
