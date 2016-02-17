package se.molybden.lab

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Assert
import org.junit.Test

class ExamplePluginUnitTest extends AbstractPluginExampleTestBase{

    @Test
    void "Test apply the plugin and verify that the task exists"(){
        Project project = ProjectBuilder.builder().build()
        project.with {
            apply plugin:  pluginName
        }
        Assert.assertNotNull(project.tasks.findByName(taskName))
    }

}

