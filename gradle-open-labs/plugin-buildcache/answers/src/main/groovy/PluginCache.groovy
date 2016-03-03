import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.tasks.bundling.Zip
import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.testing.TestDescriptor
import org.gradle.api.tasks.testing.TestListener
import org.gradle.api.tasks.testing.TestResult

class PluginCache implements Plugin<Project>{

    @Override
    void apply(Project project) {
        project.extensions.create("cache", CacheExtension)
        if (project.plugins.hasPlugin(JavaPlugin)){
            Zip zip = project.tasks.create('saveBuildBinaries',Zip)
            Task prepare = project.tasks.create('prepareBuildBinaries'){
                doFirst{
                    Process process = ['git', 'rev-parse', 'HEAD'].execute()
                    if (process.waitFor() != 0){
                        throw new RuntimeException("Git command failed: $process.errorStream.text")
                    }
                    String version = process.inputStream.text.trim()
                    File destination =  project.extensions.getByType(CacheExtension).saveTo
                    zip.version = version
                    zip.destinationDir = destination
                    zip.from project.buildDir
                }
            }
            prepare.finalizedBy zip
            project.tasks.build.finalizedBy prepare
        }
    }
}
