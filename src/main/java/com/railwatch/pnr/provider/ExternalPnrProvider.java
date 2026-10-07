package com.railwatch.pnr.provider;

import com.railwatch.pnr.domain.Pnr;
import com.railwatch.pnr.domain.PnrPassenger;
import com.railwatch.pnr.domain.PnrStatus;
import com.railwatch.pnr.provider.railkit.RailKitPnrResponse;
import com.railwatch.pnr.service.PnrStatusResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
@Primary
public class ExternalPnrProvider implements PnrProvider {

    private final RestClient restClient;
    private final PnrStatusResolver pnrStatusResolver;
    private final String baseUrl;
    private final String apiKey;

    public ExternalPnrProvider(
            RestClient restClient,
            PnrStatusResolver pnrStatusResolver,
            @Value("${pnr.provider.base-url}") String baseUrl,
            @Value("${pnr.provider.api-key}") String apiKey) {

        this.restClient = restClient;
        this.pnrStatusResolver = pnrStatusResolver;
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }

    @Override
    public Pnr getPnrStatus(String pnr) {

        RailKitPnrResponse response = restClient.get()
                .uri(baseUrl + "/pnr/{pnr}", pnr)
                .header("x-api-key", apiKey)
                .header("accept", "application/json")
                .retrieve()
                .body(RailKitPnrResponse.class);

        PnrStatus status = pnrStatusResolver.resolve(
                response.data().passengers()
                        .stream()
                        .map(passenger -> passenger.current().status())
                        .toList()
        );

        List<PnrPassenger> passengers = response.data().passengers()
                .stream()
                .map(passenger -> new PnrPassenger(
                        Integer.parseInt(
                                passenger.serialNumber().replace("Passenger ", "")
                        ),
                        passenger.booking().status(),
                        passenger.booking().berthNo(),
                        passenger.current().status(),
                        passenger.current().berthNo()
                ))
                .toList();

        return new Pnr(
                pnr,
                status,
                passengers
        );
    }
}