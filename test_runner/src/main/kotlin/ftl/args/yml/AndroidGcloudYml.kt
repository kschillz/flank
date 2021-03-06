package ftl.args.yml

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import ftl.config.Device
import ftl.config.FtlConstants.defaultAndroidModel
import ftl.config.FtlConstants.defaultAndroidVersion

/**
 * Android specific gcloud parameters
 *
 * https://cloud.google.com/sdk/gcloud/reference/firebase/test/android/run
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class AndroidGcloudYmlParams(
    val app: String? = null,
    val test: String? = null,

    @field:JsonProperty("auto-google-login")
    val autoGoogleLogin: Boolean = true,

    @field:JsonProperty("use-orchestrator")
    val useOrchestrator: Boolean = true,

    @field:JsonProperty("environment-variables")
    val environmentVariables: Map<String, String> = emptyMap(),

    @field:JsonProperty("directories-to-pull")
    val directoriesToPull: List<String> = emptyList(),

    @field:JsonProperty("performance-metrics")
    val performanceMetrics: Boolean = true,

    @field:JsonProperty("test-runner-class")
    val testRunnerClass: String? = null,

    @field:JsonProperty("test-targets")
    val testTargets: List<String?> = emptyList(),

    val device: List<Device> = listOf(Device(defaultAndroidModel, defaultAndroidVersion))
) {
    companion object : IYmlKeys {
        override val keys = listOf(
            "app", "test", "auto-google-login", "use-orchestrator", "environment-variables",
            "directories-to-pull", "performance-metrics", "test-runner-class", "test-targets", "device"
        )
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class AndroidGcloudYml(
    val gcloud: AndroidGcloudYmlParams = AndroidGcloudYmlParams()

) {
    companion object : IYmlMap {
        override val map = mapOf("gcloud" to AndroidGcloudYmlParams.keys)
    }
}
