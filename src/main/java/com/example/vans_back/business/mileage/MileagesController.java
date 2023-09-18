package com.example.vans_back.business.mileage;

import com.example.vans_back.business.mileage.dto.MileageDto;
import com.example.vans_back.business.mileage.dto.MileageRequest;
import com.example.vans_back.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mileage")
public class MileagesController {

    @Resource
    private MileagesService mileagesService;

    @GetMapping("/all-info")
    @Operation(summary = "Tagastab kilometraazi")
    public List<MileageDto> findAllMileageInfo(@RequestParam Integer vanId, @RequestParam Integer monthNumber, @RequestParam Integer yearNumber) {
        return mileagesService.findAllMileageInfo(vanId, monthNumber, yearNumber);
    }

    @PostMapping
    @Operation(summary = "Lisab uue kuupäeva ja läbisõidu mileage tabelisse.",
            description = "vanId on sisse logimisel front'is olemas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellel kuupäeval on läbisõit juba süsteemis olemas", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void addMileage(@RequestBody MileageRequest mileageRequest) {
        mileagesService.addMileage(mileageRequest);
    }
}
