package base.boudicca.api.eventcollector.collections

import java.util.*
import java.util.Collections

data class FullCollection(
    val id: UUID,
    var startTime: Long,
    var endTime: Long,
    val singleCollections: MutableList<SingleCollection>,
    val logLines: MutableList<String>,
    var errorCount: Int,
    var warningCount: Int,
) {
    constructor() : this(
        UUID.randomUUID(),
        0,
        0,
        Collections.synchronizedList(mutableListOf()),
        Collections.synchronizedList(mutableListOf()),
        0,
        0
    )

    override fun toString(): String {
        return "FullCollection(\nid=$id, \nstartTime=$startTime, \nendTime=$endTime, \nsingleCollections=$singleCollections, \nlogLines=$logLines, \nerrorCount=$errorCount, \nwarningCount=$warningCount)"
    }

}

data class SingleCollection(
    val id: UUID,
    val collectorName: String,
    var startTime: Long,
    var endTime: Long,
    var totalEventsCollected: Int,
    val httpCalls: MutableList<HttpCall>,
    val logLines: MutableList<String>,
    var errorCount: Int,
    var warningCount: Int,
) {
    constructor(collectorName: String) : this(
        UUID.randomUUID(),
        collectorName,
        0,
        0,
        0,
        mutableListOf(),
        mutableListOf(),
        0,
        0
    )

    override fun toString(): String {
        return "SingleCollection(\nid=$id, \ncollectorName='$collectorName', \nstartTime=$startTime, \nendTime=$endTime, \ntotalEventsCollected=$totalEventsCollected, \nhttpCalls=$httpCalls, \nlogLines=$logLines, \nerrorCount=$errorCount, \nwarningCount=$warningCount)"
    }
}

data class HttpCall(
    var startTime: Long,
    var endTime: Long,
    var url: String?,
    var postData: String?,
    var responseCode: Int,
) {
    constructor() : this(0, 0, null, null, 0)
}