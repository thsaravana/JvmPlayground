package generics.models.eob;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainEob {

    public static void main(String[] args) {

        final List<PayerIdentificationParameters> parameters = new ArrayList<>();
        parameters.add(new PayerIdentificationParameters());

        parameters.forEach(paramter -> {
            List<Long> collect = paramter.notMatchingPayers.stream()
                    .map(eobPayer -> eobPayer.getKickreasonCategory().getId())
                    .collect(Collectors.toList());
        });


        parameters.stream().map(parameter -> parameter.notMatchingPayers.stream()
                .map(eobPayer -> eobPayer.getKickreasonCategory().getId()).collect(Collectors.toList()));


        Map<List<Long>, PayerIdentificationParameters> collect = parameters.stream()
                .collect(Collectors.toMap(
                        payerIdentificationParameters -> payerIdentificationParameters.notMatchingPayers
                                .stream()
                                .map(eobPayer -> eobPayer.getKickreasonCategory().getId())
                                .collect(Collectors.toList()
                                ),
                        payerIdentificationParameters -> payerIdentificationParameters
                        )
                );


        final Map<Long, List<PayerIdentificationParameters>> map = new HashMap<>();

        parameters.forEach(parameter ->
                parameter.notMatchingPayers.stream()
                        .map(eobPayer -> eobPayer.getKickreasonCategory().getId())
                        .forEach(aLong ->
                                map.getOrDefault(aLong, new ArrayList<>()).add(parameter)
                        )
        );
    }
}
