package com.example.stocks.controllers


import com.example.stocks.PriceService
import com.example.stocks.model.StockPrice
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux


@RestController
class StockPriceController(val priceService: PriceService) {
    @GetMapping(value = ["/stocks/{symbol}"],
            produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun pricesFor(@PathVariable symbol: String) = priceService.getPrices(symbol)




}