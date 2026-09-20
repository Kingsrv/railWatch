package com.railwatch.pnr.controller;
import com.railwatch.pnr.dto.PnrResponse;

import com.railwatch.pnr.service.PnrService;
import jakarta.validation.constraints.Pattern;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PnrController {

    private final PnrService pnrService;

    public PnrController(PnrService pnrService) {
        this.pnrService = pnrService;
    }

    @GetMapping("/api/v1/pnr/{pnr}")
    public PnrResponse getPnr(@PathVariable
                                  @Pattern(regexp = "\\d{10}", message = "PNR must be exactly 10 digits")
                                  String pnr){
        return pnrService.getPnr(pnr);
    }
}
