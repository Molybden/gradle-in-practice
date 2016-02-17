package se.molybden.lab

import org.gradle.tooling.BuildLauncher
import org.gradle.tooling.GradleConnector
import org.gradle.tooling.ProjectConnection
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ExamplePluginIntegrationTest extends AbstractPluginExampleTestBase{
    File projectDir = new File("build/tmp/tests/")
    File buildFile = new File(projectDir, 'build.gradle')

    @Before
    void before() {
        projectDir.mkdirs()
        buildFile.text = """
buildscript {
    dependencies {
        classpath files('../../classes/main')
        classpath files('../../resources/main')
    }
}
"""
    }

    @After
    void after() {
        projectDir.deleteDir()
    }

    protected String runTasks(String... tasks) {
        ProjectConnection connection = GradleConnector.newConnector().forProjectDirectory(projectDir).connect()
        def outputStream = new ByteArrayOutputStream()

        try {
            BuildLauncher build = connection.newBuild()
            build.setStandardOutput(outputStream).forTasks(tasks).withArguments('-u').run()
        } finally {
            connection?.close()
        }

        def output = outputStream.toString('UTF-8')
        return output
    }

    @Test
    void "Test apply the plugin"() {
        buildFile << """
apply plugin: '$pluginName'
"""
        def output = runTasks('tasks')
        Assert.assertTrue('Missing output "BUILD SUCCESSFUL" in: '+output, output.contains('BUILD SUCCESSFUL'))
    }



    //@Test
    void "Test running the create directory task, verify created"() {
        buildFile << """
apply plugin: '$pluginName'
example{
  dirName = 'aDirectory'
}
"""
        def output = runTasks(taskCreateName)
        File buildDir = new File(projectDir, "/build")
        File createdDir = new File(buildDir, "aDirectory")
        Assert.assertTrue('Missing directory after task: '+taskCreateName, createdDir.exists() && createdDir.isDirectory())
    }

}
