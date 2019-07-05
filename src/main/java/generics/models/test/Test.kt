package generics.models.test

import java.util.*

class PayerIdentificationParameters {

    val notMatchingPayers: List<EOBPayer> = listOf()
}

class EOBPayer {

    val kickreasonCategory: KickReasonCategory = KickReasonCategory()
}

class KickReasonCategory {
    val id: Long = 1
}

fun main() {

    val parameters = listOf(PayerIdentificationParameters())

    parameters.forEach {
        val ids = it.notMatchingPayers.map { it.kickreasonCategory.id }
    }

    val map: Map<PayerIdentificationParameters, List<Long>> = parameters.map {
        val ids = it.notMatchingPayers.map { it.kickreasonCategory.id }
        Pair(it, ids)
    }.toMap()


    val parameters1 = ArrayList<PayerIdentificationParameters>()
    parameters1.add(PayerIdentificationParameters())


    val map1 = HashMap<Long, MutableList<PayerIdentificationParameters>>()

    parameters1.forEach { parameter ->
        parameter.notMatchingPayers.stream()
            .map { eobPayer -> eobPayer.kickreasonCategory.id }
            .forEach { aLong ->
                map1.getOrDefault(aLong, ArrayList()).add(parameter)
            }
    }

    parameters1.forEach { parameter ->
        parameter.notMatchingPayers
            .map { eobPayer -> eobPayer.kickreasonCategory.id to parameter }
            .toMap()
    }

    val map2: Map<Long, List<PayerIdentificationParameters>> = parameters1.flatMap { pa ->
        pa.notMatchingPayers.map { it.kickreasonCategory.id to pa }
    }.groupBy({ it.first }, { it.second })

}