import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.testing.TestDescriptor
import org.gradle.api.tasks.testing.TestListener
import org.gradle.api.tasks.testing.TestResult

/**
 * Will currently not work when running tests in parallel
 */
class PluginUnit implements Plugin<Project>{

    @Override
    void apply(Project project) {
        project.tasks.withType(Test){task->
            task.addTestListener(new TestListener() {
                long start
                @Override
                void beforeSuite(TestDescriptor suite) {

                }

                @Override
                void afterSuite(TestDescriptor suite, TestResult result) {

                }

                @Override
                void beforeTest(TestDescriptor testDescriptor) {
                    start = System.nanoTime()
                }

                @Override
                void afterTest(TestDescriptor testDescriptor, TestResult result) {
                    long diff = System.nanoTime() - start
                    println "Test $testDescriptor.name took ${diff/1000000} milliseconds"
                }
            })
        }
    }
}
