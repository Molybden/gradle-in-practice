

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Assert
import org.junit.Test

class CachePluginUnitTest {

    @Test
    void "Test apply the plugin and verify that the tasks exist"(){
        Project project = ProjectBuilder.builder().build()
        project.with {
            apply plugin:  'java'
            apply plugin:  'plugin-cache'
        }
        Assert.assertNotNull('Missing extension', project.extensions.getByName('cache'))
        Assert.assertNotNull('Missing task ', project.tasks.findByName('saveBuildBinaries'))
        Assert.assertNotNull('Missing task', project.tasks.findByName('prepareBuildBinaries'))
    }

}

